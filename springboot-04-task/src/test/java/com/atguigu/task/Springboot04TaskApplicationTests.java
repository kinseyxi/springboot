package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@SpringBootTest
class Springboot04TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知--今晚开会");
        message.setText("今晚7：30开会");
        message.setTo("yanyaoxi0725@163.com");
        message.setFrom("171807707@qq.com");
        mailSender.send(message);
    }
    @Test
    public void test02() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        helper.setSubject("通知--今晚开会(复杂邮件)");
        helper.setText("<b style='color:red'>今晚8：30开会</b>",true);
        helper.setTo("yanyaoxi0725@163.com");
        helper.setFrom("171807707@qq.com");
        //上传文件
        helper.addAttachment("432A5523.JPG",new File("/Users/Documents/已选片_6643677_付文静/12吋月光宝盒/432A5523.JPG"));
        helper.addAttachment("432A5525.JPG",new File("/Users/Documents/已选片_6643677_付文静/12吋月光宝盒/432A5525.JPG"));
        mailSender.send(mimeMessage);
    }

}
