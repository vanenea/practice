package com.chen.javaMail;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * spring Mail
 */
public class SpringMailDemo {

    public static JavaMailSender mailSender;

    static {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(25);//默认端口，标准的SMTP端口
        mailSender.setUsername("vanenea@163.com");//用户名
        mailSender.setPassword("password");//密码
        SpringMailDemo.mailSender = mailSender;
    }

    /**
     * 普通邮件
     */
    @Test
    public void sendMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("vanenea@163.com");
        mailMessage.setTo("576700973@qq.com");
        mailMessage.setText("我是谁，我来自哪里？");
        mailMessage.setSubject("subject");
        System.out.println("mailSender:"+mailSender+", mailMessage"+ mailMessage);
        mailSender.send(mailMessage);
    }

    /**
     * 发送带有附件的email
     * @throws MessagingException
     */
    @Test
    public void sendEmailWithAttachment() throws MessagingException {
        System.out.println("mailSender:"+mailSender);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);//构造消息helper，第二个参数表明这个消息是multipart类型的
        helper.setFrom("vanenea@163.com");
        helper.setTo("576700973@qq.com");
        helper.setSubject("Spring Email Test");
        helper.setText("这是一个带有附件的消息");
        //使用Spring的FileSystemResource来加载fox.png
        FileSystemResource image = new FileSystemResource("D:\\fox.png");
        System.out.println(image.exists());
        helper.addAttachment("fox.png", image);//添加附加，第一个参数为添加到Email中附件的名称，第二个人参数是图片资源
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }
}
