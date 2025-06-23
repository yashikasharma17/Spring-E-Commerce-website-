package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.app.buy.User;
import com.example.app.repo.usersrepo;

@Service
public class UserService {
	@Autowired
	private usersrepo user;
	public List<User> getAllUser(){
		return user.findAll();
	}
	public User getUserById(Long id) {
	return	user.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
	}
	public void createUser(User u) {
		user.save(u);
	}
	public User findUserByEmail(String email) {
		return user.getByEmail(email);
	}
	public void updateUser(User u) {
user.findById(u.getId()).orElseThrow(() -> new RuntimeException("Admin with id :"+u.getId()+" does not exists"));
user.save(u);
		}
	public void deleteUser(Long id) {
		user.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
		user.deleteById(id);
	}
	public boolean verifyCredentials(String email,String password) {
		User u=user.getByEmail(email);
		if(u.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}

