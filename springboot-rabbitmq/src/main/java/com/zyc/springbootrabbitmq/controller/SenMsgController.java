package com.zyc.springbootrabbitmq.controller;

import com.zyc.springbootrabbitmq.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 14:25
 * @desc SenMsgController
 */

/**
 * 自动配置
 *  1、RabbitAutoConfiguration
 *  2、有自动配置了连接工厂ConnectionFactory；
 *  3、RabbitProperties 封装了 RabbitMQ的配置
 *  4、 RabbitTemplate ：给RabbitMQ发送和接受消息；
 *  5、 AmqpAdmin ： RabbitMQ系统管理功能组件;
 *  	AmqpAdmin：创建和删除 Queue，Exchange，Binding
 *  6、@EnableRabbit +  @RabbitListener 监听消息队列的内容
 *
 */
@RestController
@Slf4j
public class SenMsgController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @GetMapping("/send1")
    public String send1(){
        rabbitTemplate.convertAndSend("zyc.direct","aaa.bbb",new User("tom","22"));
        return "ok";
    }

    @GetMapping("/send2")
    public String send2(){
        Map<String,String> map = new HashMap<>();
        map.put("no1","no1msg");
        map.put("no2","no2msg");
        rabbitTemplate.convertAndSend("zyc.direct","aaa",map);
        return "ok";
    }

    @GetMapping("/init")
    public String admin(){
//      创建交换机
        amqpAdmin.declareExchange(new DirectExchange("zyc.direct"));
		log.info("exchange：{zyc.direct}-创建完成");
//      创建消息队列
		amqpAdmin.declareQueue(new Queue("aaa.bbb",true));
        log.info("queue：{aaa.bbb}-创建完成");
		amqpAdmin.declareQueue(new Queue("aaa",true));
        log.info("queue：{aaa}-创建完成");
//      创建绑定规则
		amqpAdmin.declareBinding(new Binding("aaa.bbb",
                Binding.DestinationType.QUEUE,"zyc.direct",
                "aaa.bbb",null));
		amqpAdmin.declareBinding(new Binding("aaa",
                Binding.DestinationType.QUEUE,"zyc.direct",
                "aaa",null));
        log.info("binding：创建完成");
        return "ok";
    }
}
