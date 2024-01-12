package com.tap.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.mail.exception.InvalidException;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	
	public boolean validateMailData(String to,String subject,String message) {
		
		boolean isValid = false;
		
		if(to != null && !to.isEmpty() && !to.isBlank()) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		if(subject != null && !subject.isEmpty() && !subject.isBlank()) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		if(message != null && !message.isEmpty() && !message.isBlank()) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		return isValid;
	}
	
	public boolean sendEmail(String to,String subject,String message) throws InvalidException{
		
		boolean flag = false;
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		try {
			javaMailSenderImpl.send(simpleMailMessage);
			flag = true;
			System.out.println("Mail Sent");
		}
		catch (MailException e) {
			String message2 = e.getMessage();
			System.out.println(message2);
			throw new InvalidException(e.getMessage());
		}
		return flag;
		
	}
}
