package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.buy.Admins;
import com.example.app.buy.Message;

@Controller
public class HomeController {
	@Autowired
	private productService ps;
@GetMapping({"/","/home"})
public String homePage() {
	return "HomePage";
}
@GetMapping("/products")
public String productpage(Model m) {
	m.addAttribute("ProductList",ps.getAllProducts());
	return "ProductPage";
}
@GetMapping("/contact")
public String contactPage(Model m) {
	m.addAttribute("message",new Message());
	return "ContactPage";
}
@GetMapping("/aboutUs")
public String AboutUs() {
	return "AboutUs";
}
@GetMapping("/login")
public String login(Model m) {
	m.addAttribute("admin", new Admins());
	return "Login";
}
}
