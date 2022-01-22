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

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/view/auction" })
public class AuctionCustomerController {

	@RequestMapping(value = { "happenning" }, method = RequestMethod.GET)
	public String happenning(ModelMap modelMap) throws IOException {
		AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
		List<AuctionOutput> auctionOutputs = auctionAPIService.getlistAuctionHapping().execute().body();
		modelMap.put("auctions", auctionOutputs);
		return "customer/auction/happening/index";
	}

	@RequestMapping(value = { "happened" }, method = RequestMethod.GET)
	public String happened(ModelMap modelMap) throws IOException {
		AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
		List<AuctionOutput> auctionOutputs = auctionAPIService.getlistAuctionOver().execute().body();
		modelMap.put("auctions", auctionOutputs);
		return "customer/auction/happened/index";
	}

	@RequestMapping(value = { "comingsoon" }, method = RequestMethod.GET)
	public String comingsoon(ModelMap modelMap) throws IOException {
		AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
		List<AuctionOutput> auctionOutputs = auctionAPIService.getlistAuctionComingsoon().execute().body();
		modelMap.put("auctions", auctionOutputs);
		return "customer/auction/comingsoon/index";
	}

	@RequestMapping(value = { "vendor" }, method = RequestMethod.GET)
	public String vendor(ModelMap modelMap) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			List<AuctionOutput> auctionOutputs = auctionAPIService.getlistAuctionComingsoon().execute().body();
			modelMap.put("auctions", auctionOutputs);
			Response<List<AuctionOutput>> response = auctionAPIService.getListAuctionByIdVendor(2).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			default:
				modelMap.put("auctions", response.body());
				return "vendor/auction/index";
			}

		} catch (Exception e) {
			return "error/404page";
		}
	}
}
