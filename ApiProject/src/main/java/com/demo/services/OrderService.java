package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dtos.Output.AccountOutput;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.models.Orders;
import com.demo.reponsitories.OrdersResponsitory;

@Service
public class OrderService implements IOrdersService {
	
	@Autowired
	private OrdersResponsitory ordersResponsitory;
	@Override
	public OrdersOutput find(int id) {
		return  ordersResponsitory.find(id);
	}
	@Override
	public List<OrdersOutput> getListLimit(int quantity) {
		List<Orders> orders = ordersResponsitory.getListLimit(quantity);
		if(orders == null)
			return null;
		List<OrdersOutput> ordersOutputs = new ArrayList<OrdersOutput>();
		for (Orders item : orders) {
			OrdersOutput output = new OrdersOutput();
			output.setId(item.getId());
			output.setSuccessDate(item.getSuccessDate());
			output.setTotal(item.getTotal());
			AccountOutput accountOutput = new AccountOutput();
			accountOutput.setGmail(item.getAccount().getGmail());
			output.setAccount(accountOutput);
			ordersOutputs.add(output);
		}
		return ordersOutputs;
	}
	@Override
	public List<OrdersOutput> getAll() {
		return ordersResponsitory.getAll();
	}

}
