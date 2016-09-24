/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

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
import sample.category.Category;

/**
 *
 * @author quangphuong
 */
@Component
public class ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean checkExist(int id) {
        return sessionFactory.getCurrentSession().find(Product.class, id) != null;
    }

    @Transactional
    public void persist(Object object) {
        sessionFactory.getCurrentSession().persist(object);

    }

    @Transactional
    public Product getProductById(Integer id) {
        try {
            Product product = sessionFactory.getCurrentSession().find(Product.class, id);
            return product;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Transactional
    public List<Product> getAllProduct() {
        Query query = sessionFactory.getCurrentSession().createNamedQuery("Product.findAll");
        List<Product> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.find(Product.class, id);
        session.remove(product);
        session.flush();
    }

    @Transactional
    public void update(Product product) {
        Product std = (Product) sessionFactory.getCurrentSession().find(Product.class, product.getProductId());
        std.setName(product.getName());
        std.setDescription(product.getDescription());
        std.setPrice(product.getPrice());
        std.setProductId(product.getProductId());
        std.setCategoryId(product.getCategoryId());
//        em.merge(std);
        updateCategory(product.getCategoryId().getCategoryId());
    }

    @Transactional
    public List<Product> getProductByCategoryId(Integer categoryId) {
        Query query = sessionFactory.getCurrentSession().createNamedQuery("Product.findByCategoryId");
        query.setParameter("categoryId", categoryId);
        List<Product> list = query.getResultList();
        return list;
    }

    @Transactional
    public void updateCategory(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Category cate = (Category) session.find(Category.class, categoryId);
        List<Product> products = getProductByCategoryId(categoryId);
        cate.setProductList(products);
        session.merge(cate);
    }
    
}
