package com.james;

import com.james.mapper.UserMapper;
import com.james.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BbsApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("小郑同学你好呀！");
        simpleMailMessage.setText("这是java程序发送的简单邮件~");
        simpleMailMessage.setFrom("1927666233@qq.com");
        simpleMailMessage.setTo("1927666233@qq.com");

        mailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);//设置为true, 支持复杂文件组装

        //正文
        helper.setSubject("郑弘湛你好啊~");
        helper.setText("<p style='color:red'>这是java程序发送的复杂文件~</p>", true);//设置为true, 支持html代码的解析

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\lenovo\\Pictures\\登录界面背景图.jpg"));
        helper.addAttachment("2.doc", new File("C:\\Users\\lenovo\\Documents\\C语言程序设计复习题集_环创电脑工作室.doc"));

        helper.setTo("1927666233@qq.com");
        helper.setFrom("1927666233@qq.com");

        mailSender.send(mimeMessage);
    }

    @Test
    void contextLoads3() throws SQLException {
        //查看一下默认的数据源HikariDataSource
        System.out.println(dataSource.getClass());

        //通过数据源获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接
        connection.close();
    }

    @Test
    void contextLoads4() throws SQLException {
        User user = userMapper.findByUid(1);
        System.out.println(user);
    }



}
