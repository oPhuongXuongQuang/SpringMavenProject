/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.course;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quangphuong
 */
@Component
public class CourseDAO {
    @PersistenceContext
    EntityManager em;
    
    @Transactional
    public void persist(Object object) {
        em.persist(object);

    }
    
    @Transactional
    public List<Course> getAllCourse() {
        Query query = em.createNamedQuery("Course.findAll");
        List<Course> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        Course course = (Course) em.find(Course.class, id);
        em.remove(course);
    }
    
    @Transactional
    public void update(Course course) {
        Course std = (Course) em.find(Course.class, course.getId());
        std.setName(course.getName());
        std.setCreditNum(course.getCreditNum());
        em.merge(std);
    }
}
