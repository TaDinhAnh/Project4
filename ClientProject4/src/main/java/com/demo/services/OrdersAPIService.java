package com.demo.services;

import java.util.List;

import com.demo.Dtos.Output.OrdersOutput;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OrdersAPIService {
	
	@GET("orders/limit")
	Call<List<OrdersOutput>> getListLimit();
	@GET("orders/findAll")
	Call<List<OrdersOutput>> findAll();
	
	@GET("orders/find/{id}")
	Call<OrdersOutput> find(@Path("id") int id);
	
}
