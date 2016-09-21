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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quangphuong
 */
@Component
public class CategoryDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(int id) {
        return em.find(Category.class, id) != null;

    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);
    }

    @Transactional
    public List<Category> getAllCategory() {
        Query query = em.createNamedQuery("Category.findAll");
        List<Category> list = query.getResultList();
        return list;
    }

    @Transactional
    public Category getCategoryById(Integer id) {
        try {
            Category category = (Category) em.find(Category.class, id);
            return category;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void delete(int id) {
        Category category = (Category) em.find(Category.class, id);
        em.remove(category);
        em.flush();
    }

    @Transactional
    public void update(Category category) {
        Category std = (Category) em.find(Category.class, category.getCategoryId());
        std.setCategoryId(category.getCategoryId());
        std.setName(category.getName());
        em.merge(std);
    }
}
