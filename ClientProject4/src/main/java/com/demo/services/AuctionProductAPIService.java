package com.demo.services;

import com.demo.Dtos.Output.AuctionProductOutput;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuctionProductAPIService {

	@GET("auctionProduct/findListSold/{accountId}/{productId}")
	Call<AuctionProductOutput> findListSold(@Path("accountId") int accountId, @Path("productId") int productId);

	@GET("auctionProduct/getProduct/{auctionId}/{productId}")
	Call<AuctionProductOutput> getByIdProductAndAuction(@Path("auctionId") int auctionId,
			@Path("productId") int productId);

}
