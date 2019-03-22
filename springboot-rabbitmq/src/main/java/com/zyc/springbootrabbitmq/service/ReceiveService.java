package com.zyc.springbootrabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 14:21
 * @desc ReceiveService
 */
@Service
@Slf4j
public class ReceiveService {

    @RabbitListener(queues = "aaa.bbb")
    public void receiveObj(Object o){
        log.info("type:{}",o.getClass());
        log.info("msg:{}",o);
    }

    @RabbitListener(queues = "aaa")
    public void receiveMsg(Message msg){
        log.info("body:{}",msg.getBody());
        log.info("pro:{}",msg.getMessageProperties());
    }
}
