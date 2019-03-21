package com.zyc.springboottask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月16日 18:30
 * @desc AsynsService 异步任务
 */
@Service
@Slf4j
@Async
public class AsyncService {

    private static Random random = new Random();


    public void async() throws InterruptedException {
        Thread.sleep(3000);
    }

    public Future<String> task1() throws InterruptedException {
        log.info("任务1开始...");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        Long end = System.currentTimeMillis();
        log.info("任务1结束，耗时:{} ms",end-start);
        return new AsyncResult<>("任务1结束");
    }

    public Future<String> task2() throws InterruptedException {
        log.info("任务2开始...");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        Long end = System.currentTimeMillis();
        log.info("任务2结束，耗时:{} ms",end-start);
        return new AsyncResult<>("任务2结束");
    }

    public Future<String> task3() throws InterruptedException {
        log.info("任务3开始...");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        Long end = System.currentTimeMillis();
        log.info("任务3结束，耗时:{} ms",end-start);
        return new AsyncResult<>("任务3结束");
    }
}
