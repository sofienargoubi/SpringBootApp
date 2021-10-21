package com.OrderService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OrderService.Entity.OrderShop;
import com.OrderService.Repository.OrderRepository;


@Service
public class OrderService implements IOrderService{

	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Long order(OrderShop order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderShop> getAllOrders() {
		
		return  (List<OrderShop>) orderRepository.findAll();
	}

}
