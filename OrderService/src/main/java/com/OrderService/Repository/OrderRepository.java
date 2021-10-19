package com.OrderService.Repository;

import org.springframework.data.repository.CrudRepository;

import com.OrderService.Entity.OrderShop;

public interface OrderRepository extends CrudRepository<OrderShop, Integer>{

}
