package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.buy.Message;

@Repository
public interface ContactRepo extends JpaRepository<Message,Long>{
	

}
