package com.example.ClientBook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailService {
	  @Autowired
	    public JavaMailSender emailSender;

	    
	    public String sendSimpleEmail(String to, String text) {

	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo(to);
	        message.setSubject("Lấy lại mật khẩu");
	        message.setText(text);

	        // Send Message!
	        this.emailSender.send(message);

	        return "redirect:forgotPassword";
	    }

	}