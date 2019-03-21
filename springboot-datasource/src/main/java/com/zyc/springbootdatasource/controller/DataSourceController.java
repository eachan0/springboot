package com.zyc.springbootdatasource.controller;

import com.zyc.springbootdatasource.entity.User;
import com.zyc.springbootdatasource.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 14:47
 * @desc DataSourceController
 */
@RestController
public class DataSourceController {

    @Autowired
    DataSourceService service;

    @GetMapping("/add1")
    public User add1(){
        return service.getUserToMaster("2");
    }

    @GetMapping("/add2")
    public User add2(){
        return service.getUserToSlaver("1");
    }
}
