package com.demo.Dtos.Output;

import java.util.List;

public class DataDashboard {
	List<FeedBackOutput> feedBackOutputs;
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
