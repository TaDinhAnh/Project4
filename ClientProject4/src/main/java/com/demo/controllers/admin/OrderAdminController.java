package com.demo.controllers.admin;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.services.APIClient;
import com.demo.services.OrdersAPIService;

import retrofit2.Response;
@Controller
@RequestMapping(value = {"admin/orders" })
public class OrderAdminController {
	private OrdersAPIService apiService = APIClient.getClient().create(OrdersAPIService.class);
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {
			Response<List<OrdersOutput>> response = apiService.findAll().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 401:
				return "customer/account/signIn/index";
			default:
				List<OrdersOutput> rs = response.body();
				modelMap.put("orders", rs);
				return "admin/orders/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}
	
}
