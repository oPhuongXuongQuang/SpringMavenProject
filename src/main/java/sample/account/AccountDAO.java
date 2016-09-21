package sample.account;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sample.role.Role;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by quangphuong on 9/20/16.
 */
@Component
public class AccountDAO {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public boolean checkExist(String id) {
        return em.find(Account.class, id) != null;

    }

    @Transactional
    public void persist(Object object) {
        em.persist(object);
    }

    @Transactional
    public List<Account> getAllAccount() {
        Query query = em.createNamedQuery("Account.findAll");
        List<Account> list = query.getResultList();
        return list;
    }

    @Transactional
    public Account getAccountById(String id) {
        try {
            Account Account = (Account) em.find(Account.class, id);
            return Account;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Transactional
    public void delete(String id) {
        Account Account = (Account) em.find(Account.class, id);
        em.remove(Account);
        em.flush();
    }

    @Transactional
    public void update(Account Account) {
        Account std = (Account) em.find(Account.class, Account.getUsername());
        std.setUsername(Account.getUsername());
        std.setPassword(Account.getPassword());
        em.merge(std);
    }


}
