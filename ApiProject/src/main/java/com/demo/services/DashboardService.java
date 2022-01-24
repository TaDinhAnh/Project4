package com.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Output.DataDashboard;
import com.demo.Dtos.Output.FeedBackOutput;
import com.demo.Dtos.Output.OrdersOutput;

@Service
public class DashboardService implements IDashBoardService {

	@Autowired
	private IOrdersService ordersService;
	
	@Autowired
	private IFeedbackService feedbackService;
	@Override
	public DataDashboard getData() {
		List<FeedBackOutput> feedBackOutputs = feedbackService.getlistLimit();
		List<OrdersOutput> ordersOutputs = ordersService.getListLimit(5);
		DataDashboard rs = new DataDashboard();
		rs.setFeedBackOutputs(feedBackOutputs);
		rs.setOrdersOutputs(ordersOutputs);
		return  rs;
	}

}
