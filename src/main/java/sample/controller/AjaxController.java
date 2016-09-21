/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sample.category.Category;
import sample.category.CategoryDAO;
import sample.service.CategoryService;
import sample.product.Product;
import sample.product.ProductDAO;

/**
 *
 * @author quangphuong
 */
@RestController
public class AjaxController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity product() {
        List<Product> list = productDAO.getAllProduct();
        return new ResponseEntity(list, null, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getCategory", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Category> category() {
        return categoryDAO.getAllCategory();
    }
    
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        categoryService.delete(Integer.parseInt(id));
    }
 
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public void updateCategory(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("categoryId");
        String name = request.getParameter("name");
        categoryDAO.update(new Category(Integer.parseInt(id), name));
    }
    
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public void addCategory(Model model, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("categoryId");
        String name = request.getParameter("name");
        int idInt = Integer.parseInt(id);
        if (!categoryDAO.checkExist(idInt)) {
            categoryDAO.persist(new Category(idInt, name));
        } else {
            System.out.println("Hello!!!!!!!" + id);
            model.addAttribute("ERROR", "This category ID has been existed! Please choose another ID.");
        }
        
    }
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct(Model model, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("txtCategoryID");
        int idInt = Integer.parseInt(id);
        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
        if (category != null) {
            if (!productDAO.checkExist(idInt)) {
                productDAO.persist(new Product(idInt, name, description, Float.parseFloat(price), category));
            } else {
                System.out.println("Hello!!!!!!!");
                model.addAttribute("ERROR", "This product ID has been existed! Please choose another ID.");
            }
        }
    }

    @RequestMapping(value = "/actionProduct", method = RequestMethod.POST)
    public void action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");

        if (action.equals("Update")) {
            updateProduct(request, response);
        } else {
            deleteProduct(request, response);
        }
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("txtCategoryID");
        int idInt = Integer.parseInt(id);
        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
        if (category != null) {
            productDAO.update(new Product(idInt, name, description, Float.parseFloat(price), category));
        }
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        productDAO.delete(Integer.parseInt(id));
    }
}
