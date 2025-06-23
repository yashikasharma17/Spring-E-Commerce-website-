package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.buy.Product;
import com.example.app.service.productService;

@Controller
public class productController {
@Autowired
private productService ps;
@PostMapping("/add/product")
public String addProduct(Product p) {
	ps.createProduct(p);
	return "Login";
}
@GetMapping("/add/product")
public String addProduct() {
	
	return "AddProduct";
}
@GetMapping("/update/product/{id}")
public String UpdateProduct(@PathVariable Long id,Model m) {
	m.addAttribute("product", ps.getProductById(id));
	return "UpdateProduct";
}
@PostMapping("/update/product")
public String UpdateProduct(Product p) {
	ps.updateProduct(p);
	return "redirect:/admin/home";
}
@GetMapping("/delete/product/{id}")
public String deleteProduct(@PathVariable Long id) {
	ps.deleteProduct(id);
	return "redirect:/admin/home";
}
}
