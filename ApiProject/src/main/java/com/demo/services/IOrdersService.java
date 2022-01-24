package com.demo.services;
import java.util.List;
import com.demo.Dtos.Output.OrdersOutput;
public interface IOrdersService {
	OrdersOutput find(int id);
	List<OrdersOutput> getListLimit(int quantity);
	List<OrdersOutput> getAll();
}
