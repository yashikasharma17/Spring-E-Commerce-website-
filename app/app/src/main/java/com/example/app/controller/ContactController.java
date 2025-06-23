package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.buy.Message;
import com.example.app.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService cs;
	
	@PostMapping("/send/message")
	public String sendMessage(Message message,Model m) {
		cs.createMessage(message);
		m.addAttribute("Confirmation","Your Message has been successfully sent!!!!!");
		return "ContactPage";
	}

}
