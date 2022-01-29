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

	@GET("orders/getbycus/{idCus}")
	Call<List<OrdersOutput>> getByCus(@Path("idCus") int idCus);

	@GET("orders/payment/{idOrder}/{address}")
	Call<Boolean> payment(@Path("idOrder") int idOrder, @Path("address") String address);

}
