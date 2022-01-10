package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.ProductAPIService;

@Controller
@RequestMapping(value = { "customer/view/home" })
public class HomeCustomerController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) throws IOException {
		modelMap.put("date", new Date());
		ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
		List<ProductOutput> productOutputs = productAPIService.findList().execute().body();
		modelMap.put("products", productOutputs);
		for (ProductOutput a : productOutputs) {
			System.out.println(a.getDescription());
		}

		return "customer/home/index";
	}
}
