package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.services.APIClient;
import com.demo.services.OrdersAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "/customer/orders/" })
public class OrderCustomerController {
	private OrdersAPIService apiService = APIClient.getClient().create(OrdersAPIService.class);

	@RequestMapping(value = { "getByCus" }, method = RequestMethod.GET)
	public String orders(ModelMap modelMap, HttpSession session) {

		try {
			int accountId = (int) session.getAttribute("accountid");
			Response<List<OrdersOutput>> response = apiService.getByCus(accountId).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 401:
				return "customer/account/signIn/index";
			default:
				modelMap.put("orders", response.body());
				return "customer/account/orders/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
		
	}
}
