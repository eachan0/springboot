package com.zyc.springbootcache.controller;

import com.zyc.springbootcache.bean.User;
import com.zyc.springbootcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    UserService service;
    @GetMapping("/add")
    public User get(){
        return service.getUser();
    }
    @GetMapping("/put")
    public User put(){
        return service.putUser();
    }
    @GetMapping("/del")
    public int del(){
        return service.delUser();
    }

}
