package com.demo.Dtos.Output;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataDashboard {
	@SerializedName("feedBackOutputs")
	List<FeedBackOutput> feedBackOutputs;
	@SerializedName("ordersOutputs")
	List<OrdersOutput> ordersOutputs;

	public List<FeedBackOutput> getFeedBackOutputs() {
		return feedBackOutputs;
	}

	public void setFeedBackOutputs(List<FeedBackOutput> feedBackOutputs) {
		this.feedBackOutputs = feedBackOutputs;
	}

	public List<OrdersOutput> getOrdersOutputs() {
		return ordersOutputs;
	}

	public void setOrdersOutputs(List<OrdersOutput> ordersOutputs) {
		this.ordersOutputs = ordersOutputs;
	}

	public DataDashboard(List<FeedBackOutput> feedBackOutputs, List<OrdersOutput> ordersOutputs) {
		super();
		this.feedBackOutputs = feedBackOutputs;
		this.ordersOutputs = ordersOutputs;
	}

	public DataDashboard() {
		super();
	}

}
