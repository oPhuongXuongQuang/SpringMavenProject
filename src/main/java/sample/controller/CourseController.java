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
import sample.course.CourseDAO;
import sample.course.Course;

/**
 *
 * @author quangphuong
 */
@Controller
public class CourseController {
    @Autowired
    private CourseDAO courseDAO;
    
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("txtName");
        String credit = request.getParameter("txtCreditNum");
        courseDAO.persist(new Course(name, Integer.parseInt(credit)));
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/actionCourse", method = RequestMethod.POST)
    public String action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");
        
        if (action.equals("Update")) {
            updateCourse(request, response);
        } else {
            deleteCourse(request, response);
        }
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
    public String updateCourse(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        String credit = request.getParameter("txtCreditNum");
        courseDAO.update(new Course(Integer.parseInt(id), name, Integer.parseInt(credit)));
        return "redirect:/course";
    }
    
    @RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
    public String deleteCourse(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        courseDAO.delete(Integer.parseInt(id));
        return "redirect:/course";
    }
}
