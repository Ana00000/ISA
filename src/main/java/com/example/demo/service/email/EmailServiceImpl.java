package com.example.demo.service.email;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class EmailServiceImpl{

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Async
    public void sendEmail(String to, String body, String topic) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String from = env.getProperty("spring.mail.username");
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(topic);
        javaMailSender.send(simpleMailMessage);
        System.out.println("Email sent to: " + to);
    }

    public  void sendHtmlEmail(String to, String bodyHtml, String topic){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = bodyHtml;
        try {
            mimeMessage.setContent(htmlMsg, "text/html");
            //helper.setText(htmlMsg, true); // Use this or above line.
            helper.setTo(to);
            helper.setSubject(topic);
            helper.setFrom(env.getProperty("spring.mail.username"));
        } catch (MessagingException e) {
            e.printStackTrace();
        } /** Use this or below line **/

        javaMailSender.send(mimeMessage);
    }

}
