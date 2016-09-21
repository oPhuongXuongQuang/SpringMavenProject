/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.staff;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.news.News;
import sample.news.NewsDAO;

/**
 *
 * @author quangphuong
 */
@Service
public class StaffService {
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    NewsDAO newsDAO;
    
    public void delete(int id) {
        List<News> newsList = staffDAO.getStaffById(id).getNewsList();
        for (News news : newsList) {
            newsDAO.delete(news.getNewsId());
        }
        staffDAO.delete(id);
    }
}
