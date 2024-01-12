package com.tap.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.mail.exception.InvalidException;
import com.tap.mail.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/sendEmail")
	public String sendMail(@RequestParam String to,
			@RequestParam String subject,@RequestParam String message,Model model) {
		
		System.out.println(to);
		System.out.println(subject);
		System.out.println(message);
		
		boolean validateMailData = mailService.validateMailData(to, subject, message);
		
		if(validateMailData) {
			try {
				boolean email = mailService.sendEmail(to, subject, message);
				model.addAttribute("response", "Mail Sent SuccessFully to " + to);
				System.out.println("Mail Sent SuccessFully to "+ to);
			}
			catch(InvalidException e) {
				model.addAttribute("response", e.getMessage());
				System.out.println("Something Went Wrong");
				
			}
		}
		else {
			model.addAttribute("response", "Invalid Data ");
		}
		
		
	return "/index.jsp";	
	}
}
