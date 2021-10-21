package com.OrderService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.OrderService.Entity.OrderShop;
import com.OrderService.Service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/all")
	@ResponseBody
	public String get() {
			
		return "order";
	}
	
	@GetMapping("/orders")
	@ResponseBody
	public List<OrderShop> getAllUsers() {
			
		return orderService.getAllOrders();
	}

}
