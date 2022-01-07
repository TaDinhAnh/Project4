 package com.demo.controllers.customer;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionHistoryAPIService;

@Controller
@RequestMapping(value = {"customer/auction/detailAuction" })
public class AuctionDetailCustomerController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index(@RequestParam("id") int id, ModelMap modelMap) throws IOException {		
		AuctionHistoryAPIService auctionHistoryAPIService = APIClient.getClient().create(AuctionHistoryAPIService.class);
		List<AuctionHistoryOutput> auctionHistoryOutput  = auctionHistoryAPIService.getAuctionHistoryById(1).execute().body();
		modelMap.put("auctionhistory", auctionHistoryOutput);
		return "customer/auction/detailAuction/index";
	}
}
