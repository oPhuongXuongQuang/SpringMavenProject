/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.sql.Timestamp;
import java.util.Date;
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
import sample.staff.Staff;
import sample.staff.StaffDAO;
import sample.staff.StaffService;
import sample.news.News;
import sample.news.NewsDAO;

/**
 *
 * @author quangphuong
 */
@RestController
public class Ajax2Controller {
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private StaffService staffService;
    
    @RequestMapping(value = "/getNews", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity news() {
        List<News> list = newsDAO.getAllNews();
        return new ResponseEntity(list, null, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getStaff", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Staff> staff() {
        return staffDAO.getAllStaff();
    }
    
    @RequestMapping(value = "/deleteStaff", method = RequestMethod.POST)
    public void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        staffService.delete(Integer.parseInt(id));
    }
 
    @RequestMapping(value = "/updateStaff", method = RequestMethod.POST)
    public void updateStaff(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String staffAddress = request.getParameter("staffAddress");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        staffDAO.update(new Staff(Integer.parseInt(id), staffName, staffAddress, phone, email));
    }
    
    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    public void addStaff(Model model, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("staffId");
        String staffName = request.getParameter("staffName");
        String staffAddress = request.getParameter("staffAddress");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int idInt = Integer.parseInt(id);
        if (!staffDAO.checkExist(idInt)) {
            staffDAO.persist(new Staff(idInt, staffName, staffAddress, phone, email));
        } else {
            System.out.println("Hello!!!!!!!" + id);
            model.addAttribute("ERROR", "This staff ID has been existed! Please choose another ID.");
        }
        
    }
    
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public void addNews(Model model, HttpServletRequest request, HttpServletResponse response) {
        String newsId = request.getParameter("newsId");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String contents = request.getParameter("contents");
        String staffId = request.getParameter("staffId");
        String categoryId = request.getParameter("categoryId");
        
        int idInt = Integer.parseInt(newsId);
        Staff staff = staffDAO.getStaffById(Integer.parseInt(staffId));
        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
        if (staff != null) {
            if (!newsDAO.checkExist(idInt)) {
                Date date = new Date();
                newsDAO.persist(new News(idInt, title, summary, contents, new Timestamp(date.getTime()), staff, category));
            } else {
                System.out.println("Hello!!!!!!!");
                model.addAttribute("ERROR", "This news ID has been existed! Please choose another ID.");
            }
        }
    }

    @RequestMapping(value = "/actionNews", method = RequestMethod.POST)
    public void action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");

        if (action.equals("Update")) {
            updateNews(request, response);
        } else {
            deleteNews(request, response);
        }
    }

    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    public void updateNews(HttpServletRequest request, HttpServletResponse response) {
        String newsId = request.getParameter("newsId");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String contents = request.getParameter("contents");
        String staffId = request.getParameter("staffId");
        String categoryId = request.getParameter("categoryId");
        int idInt = Integer.parseInt(newsId);
        System.out.println("Helllllo: " + staffId);
        Staff staff = staffDAO.getStaffById(Integer.parseInt(staffId));
        Category category = categoryDAO.getCategoryById(Integer.parseInt(categoryId));
        if (staff != null) {
            Date date = new Date();
            newsDAO.update(new News(idInt, title, summary, contents, new Timestamp(date.getTime()), staff, category));
        }
    }

    @RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
    public void deleteNews(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        newsDAO.delete(Integer.parseInt(id));
    }
}
