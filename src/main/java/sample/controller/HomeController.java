/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sample.category.CategoryDAO;
import sample.course.CourseDAO;
import sample.product.ProductDAO;
import sample.student.StudentDAO;
import sample.teacher.TeacherDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author scien
 */
@Controller
public class HomeController {
    
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("USER", getPrincipal());
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
            if (csrf.getToken() != "") {
                System.out.println("---------CSRF: " + csrf.getToken());
                Cookie cookie = new Cookie("XSRF-TOKEN", csrf.getToken());
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:login?logout";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        if (logout != null) {
            model.addObject("logout", "You have logged out successfully!");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return model;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDeny(Model model) {
        return "access-deny";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(Model model) {
        model.addAttribute("STUDENTS", studentDAO.getAllStudent());
        return "student";
    }
    
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String teacher(Model model) {
        model.addAttribute("TEACHERS", teacherDAO.getAllTeacher());
        return "teacher";
    }
    
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String course(Model model) {
        model.addAttribute("COURSES", courseDAO.getAllCourse());
        return "course";
    }
    
//    @RequestMapping(value = "/product", method = RequestMethod.GET)
//    public String product(Model model) {
//        model.addAttribute("PRODUCTS", productDAO.getAllProduct());
//        model.addAttribute("CATEGORIES", categoryDAO.getAllCategory());
//        return "product";
//    }
//    
//    @RequestMapping(value = "/category", method = RequestMethod.GET)
//    public String category(Model model) {
//        model.addAttribute("CATEGORIES", categoryDAO.getAllCategory());
//        return "category";
//    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
