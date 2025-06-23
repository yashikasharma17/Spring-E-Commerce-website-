package com.example.app.buy;



import java.util.Date;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private double price;
private int quantity ;
private Date date;
private double amount;
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@ManyToOne
@JoinColumn(name="userId")
private User user;

public long getId() {
	return id;
}

public void setId(Long id) {
	this.id=id;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
	
}
