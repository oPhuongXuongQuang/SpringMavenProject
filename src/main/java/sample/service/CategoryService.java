/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.category.CategoryDAO;
import sample.product.Product;
import sample.product.ProductDAO;

/**
 *
 * @author quangphuong
 */
@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ProductDAO productDAO;
    
    public void delete(int id) {
        List<Product> products = categoryDAO.getCategoryById(id).getProductList();
        for (Product product : products) {
            productDAO.delete(product.getProductId());
        }
        categoryDAO.delete(id);
    }
}
