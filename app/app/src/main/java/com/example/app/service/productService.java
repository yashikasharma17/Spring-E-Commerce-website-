package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.app.buy.Product;

import com.example.app.repo.productRepo;


@Service
public class productService {
	@Autowired
	private productRepo pr;
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	public Product getProductById(Long id) {
	return	pr.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
	}
	public void createProduct(Product p) {
		pr.save(p);
	}
	public void updateProduct(Product p) {
pr.findById(p.getId()).orElseThrow(() -> new RuntimeException("Admin with id :"+p.getId()+" does not exists"));
pr.save(p);
		}
	public void deleteProduct(Long id) {
		pr.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
		pr.deleteById(id);
	}
	public Product findProductByName(String name) {
		return pr.getByName(name);
	}

}

