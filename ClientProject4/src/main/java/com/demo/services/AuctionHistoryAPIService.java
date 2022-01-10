package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuctionHistoryAPIService {

	@GET("auctionhistory")
	Call<List<AuctionHistoryOutput>> findList();

	@PUT("auctionhistory/{accountid}")
	Call<List<AuctionHistoryOutput>> getAuctionHistoryByCustomer(@Path("accountid") int accountid);

	@POST("auctionhistory")
	Call<Boolean> create(@Body AuctionHistoryInput auctionHistoryInput);
	
	@GET("auctionhistory/auction/{id}")
	Call<List<AuctionHistoryOutput>> getAuctionHistoryById(@Path("id") int id);
	
	
	@GET("auctionhistory/count/{id}")
	Call<Integer> countAuctionHistoryById(@Path("id") int id);
	
	
	@GET("auctionhistory/maxprice/{id}")
	Call<Double> maxPricetAuctionHistoryById(@Path("id") int id);

}
