/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.category;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quangphuong
 */
@Component
public class CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean checkExist(int id) {
        return sessionFactory.getCurrentSession().find(Category.class, id) != null;

    }

    @Transactional
    public void persist(Object object) {
        sessionFactory.getCurrentSession().persist(object);
    }

    @Transactional
    public List<Category> getAllCategory() {
        Query query = sessionFactory.getCurrentSession().createNamedQuery("Category.findAll");
        List<Category> list = query.getResultList();
        return list;
    }

    @Transactional
    public Category getCategoryById(Integer id) {
        try {
            Category category = (Category) sessionFactory.getCurrentSession().find(Category.class, id);
            return category;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = (Category) session.find(Category.class, id);
        session.remove(category);
        session.flush();
    }

    @Transactional
    public void update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Category std = (Category) session.find(Category.class, category.getCategoryId());
        std.setCategoryId(category.getCategoryId());
        std.setName(category.getName());
        session.merge(std);
    }
}
