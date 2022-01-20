package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.reponsitories.OrdersResponsitory;

@Service
public class OrderService implements IOrdersService {
	
	@Autowired
	private OrdersResponsitory ordersResponsitory;
	@Override
	public OrdersOutput find(int id) {
		return  ordersResponsitory.find(id);
	}

}
