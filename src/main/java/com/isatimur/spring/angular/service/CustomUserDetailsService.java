package com.isatimur.spring.angular.service;

import com.isatimur.spring.angular.dao.service.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by tisachenko on 15.10.15.
 */
@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

//    private static final StrictLogger LOGGER;

    @Autowired
    UserServiceDao userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findUserByName(username);
    }
}
