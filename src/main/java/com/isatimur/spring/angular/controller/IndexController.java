package com.isatimur.spring.angular.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tisachenko on 15.10.15.
 */
@Controller
public class IndexController {

    // Match everything without a suffix (so not a public resource)
    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect() {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    @ResponseBody
    public Map<String, Object> home(HttpServletRequest request) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", "Hello " + principal.getUsername());
        model.put("authorities", principal.getAuthorities());
        return model;
    }

}
