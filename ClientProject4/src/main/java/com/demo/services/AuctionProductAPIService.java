package com.demo.services;

import java.util.List;
import com.demo.Dtos.Input.AuctionInput;

import com.demo.Dtos.Output.AuctionProductOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuctionProductAPIService {

	@GET("auctionProduct/findListSold/{accountId}/{productId}")
	Call<AuctionProductOutput> findListSold(@Path("accountId") int accountId, @Path("productId") int productId);

	@GET("auctionProduct/{accountId}")
	Call<List<AuctionProductOutput>> findById(@Path("accountId") int accountId);


	@POST("auctionProduct")
	Call<Boolean> create(@Body AuctionInput auctionInput);

}
