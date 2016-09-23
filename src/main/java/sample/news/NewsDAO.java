/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.news;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sample.news.News;

/**
 *
 * @author quangphuong
 */
@Component
public class NewsDAO {
    private final String[] newsColumn = {"newsId" , "title", "summary", "contents", "createdDate", "categoryId", "staffId"};

    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(int id) {
        return em.find(News.class, id) != null;
    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);

    }

    @Transactional
    public News getNewsById(Integer id) {
        try {
            News news = (News) em.find(News.class, id);
            return news;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Transactional
    public List<News> getAllNews() {
        Query query = em.createNamedQuery("News.findAll");
        List<News> list = query.getResultList();
        return list;
    }

    @Transactional
    public List<News> getAllNewsBy(String searchVal, int colNum, String sort) {
        String sql = "SELECT * FROM News n WHERE FREETEXT(contents, ?) ORDER BY " + newsColumn[colNum] + " " + sort;
        Query query = em.createNativeQuery(sql, News.class);
        query.setParameter(1, searchVal);
        List<News> list = query.getResultList();
        return list;
    }

    @Transactional
    public List<News> getNewsBy(int start, int length, String searchVal, int colNum, String sort) {
        String sql;
        int end = start + length;
        Query query;
        if (searchVal != "") {
            sql = "SELECT newsId,title,summary,contents,createdDate,staffId,categoryId " +
                    "FROM (" +
                    "    SELECT newsId,title,summary,contents,createdDate,staffId,categoryId, ROW_NUMBER() OVER (" +
                    " ORDER BY "+ newsColumn[colNum] + " " + sort +") AS RowNum" +
                    "    FROM News" +
                    "    WHERE FREETEXT(contents, ?)" +
                    ") AS MyDerivedTable " +
                    "WHERE MyDerivedTable.RowNum BETWEEN " + start + " AND " + end;

            query = em.createNativeQuery(sql, News.class);
            query.setParameter(1, searchVal);
        } else {
            sql = "SELECT * " +
                    "FROM (" +
                    "    SELECT *, ROW_NUMBER() OVER (ORDER BY " + newsColumn[colNum] + " " + sort +") AS RowNum" +
                    "    FROM News" +
                    ") AS MyDerivedTable " +
                    "WHERE MyDerivedTable.RowNum BETWEEN " + start + " AND " + end;
            query = em.createNativeQuery(sql, News.class);
        }
        List<News> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        News news = (News) em.find(News.class, id);
        em.remove(news);
    }

    @Transactional
    public void update(News news) {
        News std = (News) em.find(News.class, news.getNewsId());
        std.setTitle(news.getTitle());
        std.setSummary(news.getSummary());
        std.setCreatedDate(news.getCreatedDate());
        std.setContents(news.getContents());
        std.setCategoryId(news.getCategoryId());
        std.setStaffId(news.getStaffId());
        em.merge(std);
    }
}
