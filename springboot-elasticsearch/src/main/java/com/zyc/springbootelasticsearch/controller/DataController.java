package com.zyc.springbootelasticsearch.controller;

import com.zyc.springbootelasticsearch.bean.User;
import com.zyc.springbootelasticsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 16:00
 * @desc DataController
 */
@RestController
public class DataController {

    @Autowired
    UserRepository repository;

    @GetMapping("/dataadd")
    public String dataAdd(){
        User user = new User();
        user.setId(1);
        user.setName("Tom");
        user.setAge("19");
        repository.index(user);
        user.setId(2);
        user.setName("Cat");
        user.setAge("12");
        repository.index(user);
        return "ok";
    }
    @GetMapping("/datasearch")
    public Iterable<User> dataSearch(){
        return repository.findAllById(Collections.singleton(2));
    }

    @GetMapping("/datasearchlike")
    public Iterable<User> dataSearchLike(){
        return repository.findByNameLike("C");
    }
}
