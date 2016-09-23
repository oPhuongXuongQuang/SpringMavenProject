/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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
    private final String[] newsColumn = {"newsId" , "title", "summary", "contents", "createdDate", "categoryId", "staffId"};
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private StaffService staffService;
    
    @RequestMapping(value = "/getNews", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity news(HttpServletRequest request) {
        System.out.println("start: " + request.getParameter("start"));
        System.out.println("length: " + request.getParameter("length"));
        System.out.println("search: " + request.getParameter("search[value]"));
        System.out.println("sort: " + request.getParameter("order[0][dir]"));
        System.out.println("column: " + request.getParameter("order[0][column]"));
        String length = request.getParameter("length");
        String searchVal = request.getParameter("search[value]");
        String start = request.getParameter("start");
        String sort = request.getParameter("order[0][dir]");
        String column = request.getParameter("order[0][column]");
        List<News> list;
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            System.out.println(paramName);
//            String[] paramValues = request.getParameterValues(paramName);
//                for (int i = 0; i < paramValues.length; i++) {
//                    System.out.println("--- " + paramValues[i]);
//                }
//            }

            if (Integer.parseInt(length) == -1) {
            list = newsDAO.getAllNewsBy(searchVal, Integer.parseInt(column), sort);
        } else {
            list = newsDAO.getNewsBy(Integer.parseInt(start), Integer.parseInt(length), searchVal, Integer.parseInt(column), sort);
        }
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
