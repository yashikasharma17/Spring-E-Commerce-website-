package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.app.buy.Admins;

import com.example.app.repo.Adminrepo;

@Service
public class AdminService {
	@Autowired
	private Adminrepo adminRepo;
	public List<Admins> getAllAdmin(){
		return adminRepo.findAll();
	}
	public Admins getAdminById(Long id) {
	return	adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
	}
	public void createAdmin(Admins admin) {
		adminRepo.save(admin);
	}
	public void updateAdmin(Admins admin) {
adminRepo.findById(admin.getId()).orElseThrow(() -> new RuntimeException("Admin with id :"+admin.getId()+" does not exists"));
adminRepo.save(admin);
		}
	public void deleteAdmin(Long id) {
		adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
		adminRepo.deleteById(id);
	}
	public boolean verifyCredentials(String email,String password) {
		Admins admin=adminRepo.getByEmail(email);
		if(admin!=null && admin.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
