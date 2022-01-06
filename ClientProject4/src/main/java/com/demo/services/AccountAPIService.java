package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AccountAPIService {

	@GET("account")
	Call<List<AccountOutput>> findList();
	
	@PUT("account/{id}")
	Call<AccountOutput> changeInfor(@Path("id") int id, @Body AccountInput accountInput);
	
	@POST("account")
	Call<Boolean> create(@Body AccountInput accountInput);
	
}
