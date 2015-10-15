package com.isatimur.spring.angular.dao.service;

import com.isatimur.spring.angular.dao.domain.Customer;
import com.isatimur.spring.angular.dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tisachenko on 15.10.15.
 */
@Service("userService")
public class UserService {

    @Autowired
    CustomerRepository userRepository;

    public Customer findUserByName(String name){
        return userRepository.findByUsername(name);
    }


}
