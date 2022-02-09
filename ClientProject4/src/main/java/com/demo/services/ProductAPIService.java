package com.demo.services;

import java.util.List;

import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Input.SendMailInput;
import com.demo.Dtos.Output.ProductOutput;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductAPIService {

	@GET("product")
	Call<List<ProductOutput>> findList();

	@GET("product/find/{productId}/{vendorId}")
	Call<ProductOutput> findByid(@Path("productId") int productId, @Path("vendorId") int vendorId);

	@GET("product/findAll")
	Call<List<ProductOutput>> findAll();

	@GET("product/searchbyid/{id}")
	Call<ProductOutput> findByid(@Path("id") int id);

	@GET("product/{id}")
	Call<ProductOutput> find(@Path("id") int id);

	@GET("product/find/{id}")
	Call<ProductOutput> find2(@Path("id") int id);

	@POST("product")
	Call<ProductOutput> create(@Body ProductInput productInput);

	@PUT("product/{id}")
	Call<ProductOutput> updateProduct(@Path("id") int id, @Body ProductInput productInput);

	@GET("product/search/{name}")
	Call<List<ProductOutput>> search(@Path("name") String name);

	@PATCH("accept/{id}")
	Call<Void> delete(@Path("id") int id);

	@GET("product/limit")
	Call<List<ProductOutput>> getListLimit();

	@GET("product/unSold/{id}")
	Call<List<ProductOutput>> getListProductUnsold(@Path("id") int id);

	@GET("product/getPro2/{id}")
	Call<List<ProductOutput>> getPro(@Path("id") int id);

	@GET("product/sold/{id}")
	Call<List<ProductOutput>> getListProductSold(@Path("id") int id);

	@GET("product/listAccept/{id}")
	Call<List<ProductOutput>> getListProductAccept(@Path("id") int id);

	@GET("product/listNotAccept/{id}")
	Call<List<ProductOutput>> getListProductNotAccept(@Path("id") int id);

	@PATCH("product/accept/{id}")
	Call<Boolean> accept(@Path("id") int id);

	@POST("product/cancel/{id}")
	Call<Boolean> cancel(@Path("id") int id, @Body SendMailInput sendMailInput);

}
