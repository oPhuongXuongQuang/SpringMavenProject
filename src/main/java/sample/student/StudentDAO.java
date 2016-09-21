/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.student;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author scien
 */
@Component
public class StudentDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void persist(Object object) {
        em.persist(object);

    }
    
    @Transactional
    public List<Student> getAllStudent() {
        Query query = em.createNamedQuery("Student.findAll");
        List<Student> list = query.getResultList();
        return list;
    }

    @Transactional
    public void delete(int id) {
        Student student = (Student) em.find(Student.class, id);
        em.remove(student);
    }
    
    @Transactional
    public void update(Student student) {
        Student std = (Student) em.find(Student.class, student.getId());
        std.setName(student.getName());
        std.setAddr(student.getAddr());
        em.merge(std);
    }
}
