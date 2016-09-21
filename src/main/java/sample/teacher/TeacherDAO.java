/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.teacher;

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
public class TeacherDAO {
    @PersistenceContext
    EntityManager em;
    
    @Transactional
    public void persist(Object object) {
        em.persist(object);

    }
    
    @Transactional
    public List<Teacher> getAllTeacher() {
        Query query = em.createNamedQuery("Teacher.findAll");
        List<Teacher> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        Teacher teacher = (Teacher) em.find(Teacher.class, id);
        em.remove(teacher);
    }
    
    @Transactional
    public void update(Teacher teacher) {
        Teacher std = (Teacher) em.find(Teacher.class, teacher.getId());
        std.setName(teacher.getName());
        std.setAddr(teacher.getAddr());
        std.setPhone(teacher.getPhone());
        em.merge(std);
    }
}
