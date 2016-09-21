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
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quangphuong
 */
@Component
public class ProductDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(int id) {
        return em.find(Product.class, id) != null;
    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);

    }

    @Transactional
    public Product getProductById(Integer id) {
        try {
            Product product = (Product) em.find(Product.class, id);
            return product;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Transactional
    public List<Product> getAllProduct() {
        Query query = em.createNamedQuery("Product.findAll");
        List<Product> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        Product product = (Product) em.find(Product.class, id);
        em.remove(product);
    }

    @Transactional
    public void update(Product product) {
        Product std = (Product) em.find(Product.class, product.getProductId());
        std.setName(product.getName());
        std.setDescription(product.getDescription());
        std.setPrice(product.getPrice());
        std.setProductId(product.getProductId());
        std.setCategoryId(product.getCategoryId());
        em.merge(std);
    }
    
}
