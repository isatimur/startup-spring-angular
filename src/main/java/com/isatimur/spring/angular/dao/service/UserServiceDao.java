package com.isatimur.spring.angular.dao.service;

import com.isatimur.spring.angular.dao.CustomUser;
import com.isatimur.spring.angular.dao.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by tisachenko on 15.10.15.
 */
@Service("userService")
public class UserServiceDao {

    @Autowired
    CustomUserRepository customUserRepository;


    public UserDetails findUserByName(String name){
        CustomUser user = customUserRepository.findByUsername(name);
        return user;
    }


}
