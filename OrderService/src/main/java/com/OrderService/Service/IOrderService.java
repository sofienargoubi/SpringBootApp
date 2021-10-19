package com.OrderService.Service;

import java.util.List;


import com.OrderService.Entity.OrderShop;

public interface IOrderService {
	
	public Long order(OrderShop order);
	public List<OrderShop> getAllOrders();

}
