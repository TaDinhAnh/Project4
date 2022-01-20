package com.demo.services;

import com.demo.Dtos.Output.OrdersOutput;

public interface IOrdersService {
	OrdersOutput find(int id);
}
