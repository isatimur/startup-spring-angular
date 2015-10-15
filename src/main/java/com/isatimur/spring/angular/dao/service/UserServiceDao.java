package com.isatimur.spring.angular.dao.service;

import com.isatimur.spring.angular.dao.Customer;
import com.isatimur.spring.angular.dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by tisachenko on 15.10.15.
 */
@Service("userService")
public class UserServiceDao {

    @Autowired
    CustomerRepository customerRepository;


    public UserDetails findUserByName(String name){
        Customer user = customerRepository.findByUsername(name);
        return user;
    }


}
