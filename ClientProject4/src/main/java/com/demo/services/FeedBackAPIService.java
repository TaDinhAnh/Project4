package com.demo.services;

import com.demo.Dtos.Input.FeedBackInput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FeedBackAPIService {
	
	@POST("feedback")
	Call<Boolean> create(@Body FeedBackInput feedBackInput);
	
}
