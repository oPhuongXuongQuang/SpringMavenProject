/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.staff;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quangphuong
 */
@Component
public class StaffDAO {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(int id) {
        return em.find(Staff.class, id) != null;

    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);
    }

    @Transactional
    public List<Staff> getAllStaff() {
        Query query = em.createNamedQuery("Staff.findAll");
        List<Staff> list = query.getResultList();
        return list;
    }

    @Transactional
    public Staff getStaffById(Integer id) {
        try {
            Staff staff = (Staff) em.find(Staff.class, id);
            return staff;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void delete(int id) {
        Staff staff = (Staff) em.find(Staff.class, id);
        em.remove(staff);
        em.flush();
    }

    @Transactional
    public void update(Staff staff) {
        Staff std = (Staff) em.find(Staff.class, staff.getStaffId());
        std.setStaffId(staff.getStaffId());
        std.setStaffName(staff.getStaffName());
        std.setStaffAddress(staff.getStaffAddress());
        std.setPhone(staff.getPhone());
        std.setEmail(staff.getEmail());
        em.merge(std);
    }
}
