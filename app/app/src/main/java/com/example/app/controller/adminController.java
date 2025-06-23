package com.example.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.buy.Admins;
import com.example.app.buy.Orders;
import com.example.app.buy.Product;
import com.example.app.buy.User;
import com.example.app.service.AdminService;
import com.example.app.service.UserService;
import com.example.app.service.ordersService;
import com.example.app.service.productService;


@Controller
public class adminController {
	@Autowired
private AdminService as;
	@Autowired
	private ordersService os;
	@Autowired
	private productService ps;
	@Autowired
	private UserService us;
	
	private User u;
	
	@GetMapping("/admin/verify/Creddentials")
		public String verifyCredentials(@ModelAttribute("admin") Admins admin,Model m) {
		if(as.verifyCredentials(admin.getEmail(), admin.getPassword())) {
			m.addAttribute("admin", new Admins());
			m.addAttribute("user", new User());
			m.addAttribute("product", new Product());
			return "redirect:/admin/home";
		}
		m.addAttribute("error1", "Invalid password and email");
		return "Login";
	}
@GetMapping("/admin/home")	
public String adminHome(Model m) {
	m.addAttribute("AdminList",as.getAllAdmin());
	m.addAttribute("UserList",us.getAllUser());
	m.addAttribute("OrdersList",os.getAllOrders());
	m.addAttribute("ProductList",ps.getAllProducts());
	return "AdminHomePage";
}
@GetMapping("/add/admin")
public String createAdmin() {
	return "AddAdmin";
}
@PostMapping("/add/admin")
	public String createAdmin(Admins admin) {
	as.createAdmin(admin);
	return "redirect:/admin/home";
}

@GetMapping("/update/admin/{id}")
public String updateAdmin(@PathVariable Long id,Model m) {
	m.addAttribute("admin",as.getAdminById(id));
	return "UpdateAdmin";
}
@PostMapping("/update/admin")
public String updateAdmin(Admins admin) {
	as.updateAdmin(admin);
	return "redirect:/admin/home";
}

@GetMapping("/user/home")
public String userHome(@ModelAttribute("userId")Long userId,@ModelAttribute("error2")String error2,@ModelAttribute("messageSuccess")String messageSuccess,Model m) {
	User user=us.getUserById(userId);
	m.addAttribute("ordersList",os.findByUser(user));
	if(!error2.isEmpty()) {
		m.addAttribute("error2", error2);
	}
	if(!messageSuccess.isEmpty()) {
		m.addAttribute("messageSuccess", messageSuccess);
	}
	
	return "BuyProduct";
}
@PostMapping("/user/login")
public String userLogin(User u,RedirectAttributes ra,Model m) {
	if(us.verifyCredentials(u.getEmail(), u.getPassword())) {
		u=us.findUserByEmail(u.getEmail());
		
		ra.addAttribute("userId", u.getId());
		
		return "redirect:/user/home";
	}
	ra.addAttribute("error2", "Invalid password and email");
	return "Login";
}
@PostMapping("/product/search")
public String productSearch(String name,Long userId ,Model m) {
	Product pr=ps.findProductByName(name);
	User user=us.getUserById(userId);
	if(pr!=null) {
		m.addAttribute("ordersList",os.findByUser(user));
		m.addAttribute("product",pr);
		
	}
	else {
		m.addAttribute("messageError","Product not available");
		m.addAttribute("ordersList",os.findByUser(user));
		m.addAttribute("userId", userId);
	}
	m.addAttribute("userId",user.getId());
	return "BuyProduct";
}
@PostMapping("/place/order")
public String placeOrder(Orders order,Long userId,Model m,RedirectAttributes ra) {	 
	 
	double totalAmount=order.getPrice()*order.getQuantity();
	
	order.setAmount(totalAmount);
	User user=us.getUserById(userId);
order.setUser(user);
	order.setDate(new Date());
	os.createOrder(order);
	ra.addAttribute("userId",user.getId());
	ra.addAttribute("messageSuccess","The order has been placed");
	return "redirect:/user/home";
}
@GetMapping("/delete/admin/{id}")
public String deleteAdmin(@PathVariable Long id) {
	as.deleteAdmin(id);
	return "redirect:/user/home";
}



}
