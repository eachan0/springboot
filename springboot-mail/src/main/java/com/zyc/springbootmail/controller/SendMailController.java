package com.zyc.springbootmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月21日 19:46
 * @desc SendMail
 */
@RestController
public class SendMailController {
    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/send")
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("今晚加班！");
        message.setTo("zyc199777@gmail.com");
        message.setFrom("1138613536@qq.com");
        mailSender.send(message);
    }

    @GetMapping("/sendFile")
    public void test2() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("通知");
        helper.setText("<span style='color:red'>今晚加班！</span>",true);
        helper.setTo("zyc199777@gmail.com");
        helper.setFrom("1138613536@qq.com");

        helper.addAttachment("1.jpg",new File("C:\\Users\\zhuyc\\Pictures\\tupian.jpg"));
        mailSender.send(message);
    }
}
