package com.example.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.app.buy.Orders;
import com.example.app.buy.User;

@Repository
public interface orderRepo extends JpaRepository<Orders,Long> {
	public List<Orders> findByUser(User user);

}