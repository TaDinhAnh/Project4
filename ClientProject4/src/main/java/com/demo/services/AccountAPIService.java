package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AccountAPIService {

	@GET("account")
	Call<List<AccountOutput>> findList();
	
	@PUT("account/{id}")
	Call<AccountOutput> changeInfor(@Path("id") int id, @Body AccountInput accountInput);
	
	@DELETE("account/{id}")
	Call<Boolean> delAccount(@Path("id") int id);

	@POST("account")
	Call<Boolean> create(@Body AccountInput accountInput);
	
	@POST("account/changeAvatar/{id}/{imgOld}")
	Call<byte[]> changeAvatar(@Param("file") MultipartFile file, @Path("id") int id, @Path("imgOld")String imgOld);
	
	@GET("account/getAvatar/{filename}")
	Call<byte[]> getImg(@Path("filename") String filename);
	
}
