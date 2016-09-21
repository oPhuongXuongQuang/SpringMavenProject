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
import sample.teacher.Teacher;
import sample.teacher.TeacherDAO;

/**
 *
 * @author quangphuong
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherDAO teacherDAO;
    
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("txtName");
        String address = request.getParameter("txtAddr");
        String phone = request.getParameter("txtPhone");
        teacherDAO.persist(new Teacher(name, address, phone));
        return "redirect:/teacher";
    }
    
    @RequestMapping(value = "/actionTeacher", method = RequestMethod.POST)
    public String action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");
        
        if (action.equals("Update")) {
            updateTeacher(request, response);
        } else {
            deleteTeacher(request, response);
        }
        return "redirect:/teacher";
    }
    
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public String updateTeacher(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        String addr = request.getParameter("txtAddr");
        String phone = request.getParameter("txtPhone");
        teacherDAO.update(new Teacher(Integer.parseInt(id), name, addr, phone));
        return "redirect:/teacher";
    }
    
    @RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
    public String deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        teacherDAO.delete(Integer.parseInt(id));
        return "redirect:/teacher";
    }
}
