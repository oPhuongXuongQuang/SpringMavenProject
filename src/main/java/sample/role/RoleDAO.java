package sample.role;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sample.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quangphuong on 9/20/16.
 */
@Component
public class RoleDAO {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(String id) {
        return em.find(Role.class, id) != null;

    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);
    }

    @Transactional
    public List<Role> getAllRole() {
        Query query = em.createNamedQuery("Role.findAll");
        List<Role> list = query.getResultList();
        return list;
    }

    @Transactional
    public Role getRoleById(String id) {
        try {
            Role Role = (Role) em.find(Role.class, id);
            return Role;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void delete(String id) {
        Role Role = (Role) em.find(Role.class, id);
        em.remove(Role);
        em.flush();
    }

    public List<String> findRoleByUserName(String username) {
        Query query = em.createNamedQuery("Role.findByUsername");
        query.setParameter("username", username);
        List<Role> list = query.getResultList();
        List<String> roles = new ArrayList<>();
        for(Role role: list) {
            roles.add(role.getRole());
        }
        return roles;
    }

//    @Transactional
//    public void update(Role Role) {
//        Role std = (Role) em.find(Role.class, Role.getUsername());
//        std.setUsername(Role.getUsername());
//        std.setPassword(Role.getPassword());
//        em.merge(std);
//    }
}
