package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.Dtos.Output.AuctionOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuctionAPIService {

	@GET("auction/vendor/{idVendor}")
	Call<List<AuctionOutput>> getListAuctionByIdVendor(@Path("idVendor") int idVendor);

	@PUT("auction/{id}")
	Call<AccountOutput> updateAuction(@Path("id") int id, @Body AuctionInput auctionInput);

	@POST("auction")
	Call<Boolean> createAuction(@Body AuctionInput auctionInput);

	@GET("auction")
	Call<List<AuctionOutput>> find();

	@GET("auction/{id}")
	Call<AuctionOutput> search(@Path("id") int id);

	@GET("auction/admin")
	Call<List<AuctionOutput>> findAll();

	@GET("auction/over")
	Call<List<AuctionOutput>> getlistAuctionOver();

	@GET("auction/happening")
	Call<List<AuctionOutput>> getlistAuctionHapping();

	@GET("auction/comingsoon")
	Call<List<AuctionOutput>> getlistAuctionComingsoon();

	@GET("auction/limit")
	Call<List<AuctionOutput>> getLimitAuctionHappening();

	@GET("auction/getAuction/{id}")
	Call<List<AuctionOutput>> getAuction(@Path("id") int accountid);
	
	@DELETE("auction/{id}")
	Call<Boolean> delAuction(@Path("id") int id);
	
	@GET("auction/searchbyDate/{eventdate}")
	Call<List<AuctionOutput>> getListbyDate(@Param("eventdate") String eventdate );

}
