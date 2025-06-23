package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.app.buy.Orders;
import com.example.app.buy.User;
import com.example.app.repo.orderRepo;


@Service
public class ordersService {
	@Autowired
	private orderRepo or;
	public List<Orders> getAllOrders(){
		return or.findAll();
	}
	public Orders getOrderById(Long id) {
	return	or.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
	}
	public void createOrder(Orders o) {
	or.save(o);
	}
	public void updateOrder(Orders o) {
		or.findById(o.getId()).orElseThrow(() -> new RuntimeException("Admin with id :"+o.getId()+" does not exists"));
or.save(o);
		}
	public List<Orders> findByUser(User user){
	return	or.findByUser(user);
	}
	public void deleteOrder(Long id) {
		or.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
		or.deleteById(id);
	}
	

}
