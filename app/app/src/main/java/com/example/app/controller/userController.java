package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.buy.Admins;
import com.example.app.buy.User;
import com.example.app.service.UserService;


@Controller
public class userController {
	@Autowired
private UserService us;
@GetMapping("/add/user")
public String addUser() {
	return "AddUser";
}
@PostMapping("/add/user")
public String addUser(User user) {
	us.createUser(user);
	return "Login";
}
@GetMapping("/update/user/{id}")
public String updateAdmin(@PathVariable Long id,Model m) {
	m.addAttribute("user",us.getUserById(id));
	return "UpdateUser";
}
@PostMapping("/update/user")
public String updateAdmin(User user) {
	us.createUser(user);
	return "redirect:/admin/home";

}
@GetMapping("/delete/user/{id}")
public String deleteUser(@PathVariable Long id) {
	us.deleteUser(id);
	return "redirect:/admin/home";
}
}
