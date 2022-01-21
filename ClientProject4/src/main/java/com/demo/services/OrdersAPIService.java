package com.demo.services;

import java.util.List;
import com.demo.Dtos.Output.OrdersOutput;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OrdersAPIService {
	@GET("orders/limit")
	Call<List<OrdersOutput>> getListLimit();
	
}
