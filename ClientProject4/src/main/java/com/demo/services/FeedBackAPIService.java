package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.Dtos.Output.FeedBackOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FeedBackAPIService {
	
	@POST("feedback")
	Call<Boolean> create(@Body FeedBackInput feedBackInput);
	
	@GET("feedback")
	Call<List<FeedBackOutput>> findList();

	@GET("feedback/admin")
	Call<List<FeedBackOutput>> getAll();
	
}
