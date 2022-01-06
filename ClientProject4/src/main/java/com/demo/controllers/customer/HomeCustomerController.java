package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;

@Controller
@RequestMapping(value = {"customer/home" })
public class HomeCustomerController {
	
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {			
			AuctionAPIService auctionAPIService =APIClient.getClient().create(AuctionAPIService.class);
			 int i = auctionAPIService.find().execute().code();
			 System.out.println(i);
			List<AuctionOutput> auctionOutputs = auctionAPIService.find().execute().body();
			modelMap.put("auctions", auctionOutputs);
			for(AuctionOutput a: auctionOutputs) {
				System.out.println(a.getDescription());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "customer/home/index";
	}
}
