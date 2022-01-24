package com.demo.services;

import com.demo.Dtos.Output.DataDashboard;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DashBoardAPIService {
	@GET("dashboard")
	Call<DataDashboard> getdata();
}
