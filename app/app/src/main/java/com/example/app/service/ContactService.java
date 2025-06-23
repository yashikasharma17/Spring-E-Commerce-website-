package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.buy.Message;

import com.example.app.repo.ContactRepo;

@Service
public class ContactService {
	@Autowired
private ContactRepo cr;
	public List<Message> getAllMessages(){
		return cr.findAll();
	}
	public Message getMessageById(Long id) {
	return	cr.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
	}
	public void createMessage(Message p) {
		cr.save(p);
	}
	public void updateMessage(Message p) {
cr.findById(p.getId()).orElseThrow(() -> new RuntimeException("Admin with id :"+p.getId()+" does not exists"));
cr.save(p);
		}
	public void deleteMessage(Long id) {
		cr.findById(id).orElseThrow(() -> new RuntimeException("Admin with id :"+id+" does not exists"));
		cr.deleteById(id);
	}
	    
}
