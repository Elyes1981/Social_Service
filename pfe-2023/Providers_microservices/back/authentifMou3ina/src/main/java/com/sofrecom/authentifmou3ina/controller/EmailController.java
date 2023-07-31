package com.sofrecom.authentifmou3ina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/test")
public class EmailController {

    /*@Autowired
    private JavaMailSender javaMailSender;*/

    /*@RequestMapping(value = "/sendemail")
    public String send(@RequestParam("email") String email ) throws AddressException, MessagingException, IndexOutOfBoundsException {
        sendEmailCompalin(email);
        //sendEmailWithAttachment();
        return "Email sent successfully";
    }
    void sendEmailCompalin(String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Rating");
        msg.setText("Hello ");

        javaMailSender.send(msg);

    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("email address to whom you send the mail");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        helper.setText("Check attachment for image!");

        // true = text/html
        //helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("C:/Users\\1302143\\Desktop\\ssl4.png"));

        //helper.addAttachment("ssl4.png", file);

        javaMailSender.send(msg);

    }*/

}
