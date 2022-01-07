package com.demo.controllers.customer;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;

@Controller
@RequestMapping(value = {"customer/auction/comingsoon" })
public class AuctionComingSoonCustomerController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) throws IOException {
		AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
		List<AuctionOutput> auctionOutputs  = auctionAPIService.getlistAuctionComingsoon().execute().body();
		modelMap.put("auctions", auctionOutputs);
		return "customer/auction/comingsoon/index";
	}
}
