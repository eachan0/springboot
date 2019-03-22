package com.zyc.springbootrabbitmq;

import com.zyc.springbootrabbitmq.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("no1","no1msg");
        map.put("no2","no2msg");
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("zyc.direct","aaa.bbb",new User("zyc","20"));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("aaa.bbb");
        log.info("type:{}",o.getClass());
        log.info("msg:{}",o);
    }

}
