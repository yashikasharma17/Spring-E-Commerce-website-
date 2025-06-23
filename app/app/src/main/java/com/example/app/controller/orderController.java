package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.buy.Orders;
import com.example.app.service.ordersService;

@Controller
public class orderController {
@Autowired
private ordersService os;
}