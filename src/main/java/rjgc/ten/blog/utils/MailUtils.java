package rjgc.ten.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
//郭子昀
//邮件发送工具类实现
@Component
public class MailUtils {
    @Autowired(required = false)
    private JavaMailSenderImpl mailSender;
    //${spring.mail.username}
    @Value("${spring.mail.username}")
    private String mailfrom;
    //用于发送简单邮件
    public void sendSimpleEmail(String mailto,String title,String content){
        //定制邮件发送内容
        SimpleMailMessage message = new SimpleMailMessage();
        //message用来存储
        message.setFrom(mailfrom);
        message.setTo(mailto);
        message.setSubject(title);
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }
}
