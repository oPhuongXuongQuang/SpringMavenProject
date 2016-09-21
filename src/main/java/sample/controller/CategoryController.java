/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sample.category.CategoryDAO;
import sample.service.CategoryService;

/**
 *
 * @author quangphuong
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private CategoryService categoryService;
    
//    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
//    public String add(Model model, HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        String name = request.getParameter("txtName");
//        int idInt = Integer.parseInt(id);
//        if (!categoryDAO.checkExist(idInt)) {
//            categoryDAO.persist(new Category(idInt, name));
//        } else {
//            System.out.println("Hello!!!!!!!" + id);
//            model.addAttribute("ERROR", "This category ID has been existed! Please choose another ID.");
//        }
//        
//        return "redirect:/category";
//    }
    
    @RequestMapping(value = "/actionCategory", method = RequestMethod.POST)
    public String action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");
        
        if (action.equals("Update")) {
//            updateCategory(request, response);
        } else {
//            deleteCategory(request, response);
        }
        return "redirect:/category";
    }
    
//    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
//    public String updateCategory(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        String name = request.getParameter("txtName");
//        categoryDAO.update(new Category(Integer.parseInt(id), name));
//        return "redirect:/category";
//    }
    
//    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
//    public String deleteCategory(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("txtId");
//        categoryService.delete(Integer.parseInt(id));
//        return "redirect:/category";
//    }
}
