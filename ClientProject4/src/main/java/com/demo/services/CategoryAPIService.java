package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.CategoryInput;
import com.demo.Dtos.Output.CategoryOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface CategoryAPIService {

	@GET("category")
	Call<List<CategoryOutput>> find();
	
	@PUT("category/{id}")
	Call<Boolean> updateCategory(@Path("id") int id, @Body CategoryInput categoryInput);

	@POST("category")
	Call<Boolean> createCategory(@Body CategoryInput categoryInput);
	
}
