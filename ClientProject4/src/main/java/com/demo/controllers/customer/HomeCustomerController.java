package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;

@Controller
@RequestMapping(value = { "customer/home" })
public class HomeCustomerController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) throws IOException {

		AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
		List<AuctionOutput> auctionOutputs = auctionAPIService.find().execute().body();
		modelMap.put("auctions", auctionOutputs);
		for (AuctionOutput a : auctionOutputs) {
			System.out.println(a.getDescription());
		}

		return "customer/home/index";
	}
}
