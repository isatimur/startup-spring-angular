package com.isatimur.spring.angular.service;

import com.isatimur.spring.angular.dao.domain.Customer;
import com.isatimur.spring.angular.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by tisachenko on 15.10.15.
 */
@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        Customer customer = userDao.findUserByName(username);
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(grantedAuthority);
        if (customer != null) {
            user = new User(customer.getUsername(), customer.getPassword(), customer.isEnabled(), true, true, true, authorities);
        } else {
            user = null;
        }
        return user;
    }
}
