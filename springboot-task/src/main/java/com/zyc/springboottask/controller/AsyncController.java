package com.zyc.springboottask.controller;

import com.zyc.springboottask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月16日 18:20
 * @desc AsyncController 异步任务
 */
@RestController
@RequestMapping("/task")
public class AsyncController {

    @Autowired
    private AsyncService service;

    @GetMapping("/async1")
    public String async1(){
        try {
            service.async();
        } catch (InterruptedException e) {
            return "errot";
        }
        return "success";
    }

    @GetMapping("/async2")
    public String async2(){
        try {
            Long start = System.currentTimeMillis();
            Future<String> task1 = service.task1();
            Future<String> task2 = service.task2();
            Future<String> task3 = service.task3();

            while (true){
                if (task1.isDone() && task2.isDone() && task3.isDone()){
                    break;
                }
            }
            Long end = System.currentTimeMillis();
            return "任务完成，总耗时："+(end-start)+" ms";
        } catch (InterruptedException e) {
            return "errot";
        }
    }
}
