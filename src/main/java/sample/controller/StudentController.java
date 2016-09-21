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
import sample.student.Student;
import sample.student.StudentDAO;

/**
 *
 * @author quangphuong
 */
@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("txtName");
        String address = request.getParameter("txtAddr");
        studentDAO.persist(new Student(name, address));
        return "redirect:/student";
    }
    
    @RequestMapping(value = "/actionStudent", method = RequestMethod.POST)
    public String action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");
        
        if (action.equals("Update")) {
            updateStudent(request, response);
        } else {
            deleteStudent(request, response);
        }
        return "redirect:/student";
    }
    
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        String addr = request.getParameter("txtAddr");
        studentDAO.update(new Student(Integer.parseInt(id), name, addr));
        return "redirect:/student";
    }
    
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        studentDAO.delete(Integer.parseInt(id));
        return "redirect:/student";
    }
}
