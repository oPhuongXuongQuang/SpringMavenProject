package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sample.account.Account;
import sample.account.AccountDAO;
import sample.role.Role;
import sample.role.RoleDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quangphuong on 9/20/16.
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + username);
        Account account = accountDAO.getAccountById(username);
        if (account == null) {
            throw new UsernameNotFoundException("No user present with username: "+username);
        } else {
            return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),
                    true, true, true, true, getGrantedAuthorities(account));
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Account user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role : user.getRoleList()){
            System.out.println("Role: " + role.getRole());
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        }
        return authorities;
    }
}
