/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sample.category.CategoryDAO;
import sample.product.ProductDAO;

/**
 *
 * @author quangphuong
 */
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CategoryDAO categoryDAO;

//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
//    public String add(Model model, HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        String name = request.getParameter("txtName");
//        String price = request.getParameter("txtPrice");
//        String description = request.getParameter("txtDes");
//        String categoryId = request.getParameter("txtCategoryID");
//        int idInt = Integer.parseInt(id);
//        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
//        if (category != null) {
//            if (!productDAO.checkExist(idInt)) {
//                productDAO.persist(new Product(idInt, name, description, Float.parseFloat(price), category));
//            } else {
//                System.out.println("Hello!!!!!!!");
//                model.addAttribute("ERROR", "This product ID has been existed! Please choose another ID.");
//            }
//        }
//        return "redirect:/product";
//    }
//
//    @RequestMapping(value = "/actionProduct", method = RequestMethod.POST)
//    public String action(HttpServletRequest request, HttpServletResponse response) {
//        String action = request.getParameter("btnAction");
//
//        if (action.equals("Update")) {
//            updateProduct(request, response);
//        } else {
//            deleteProduct(request, response);
//        }
//        return "redirect:/product";
//    }
//
//    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
//    public String updateProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        String name = request.getParameter("txtName");
//        String price = request.getParameter("txtPrice");
//        String description = request.getParameter("txtDes");
//        String categoryId = request.getParameter("txtCategoryID");
//        int idInt = Integer.parseInt(id);
//        System.out.println("Helllllo: " + categoryId);
//        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
//        if (category != null) {
//            productDAO.update(new Product(idInt, name, description, Float.parseFloat(price), category));
//        }
//        return "redirect:/product";
//    }
//
//    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
//    public String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        productDAO.delete(Integer.parseInt(id));
//        return "redirect:/product";
//    }
}
