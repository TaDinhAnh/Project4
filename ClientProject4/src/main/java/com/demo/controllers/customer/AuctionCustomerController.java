package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/view/auction" })
public class AuctionCustomerController {

	@RequestMapping(value = { "happenning" }, method = RequestMethod.GET)
	public String happenning(ModelMap modelMap) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			Response<List<AuctionOutput>> response = auctionAPIService.getlistAuctionHapping().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			default:
				modelMap.put("auctions", response.body());
				return "customer/auction/happening/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

	@RequestMapping(value = { "happened" }, method = RequestMethod.GET)
	public String happened(ModelMap modelMap) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			Response<List<AuctionOutput>> response = auctionAPIService.getlistAuctionOver().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			default:
				modelMap.put("auctions", response.body());
				return "customer/auction/happened/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

	@RequestMapping(value = { "comingsoon" }, method = RequestMethod.GET)
	public String comingsoon(ModelMap modelMap) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			Response<List<AuctionOutput>> response = auctionAPIService.getlistAuctionComingsoon().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			default:
				modelMap.put("auctions", response.body());
				return "customer/auction/comingsoon/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

	@RequestMapping(value = { "vendor" }, method = RequestMethod.GET)
	public String vendor(ModelMap modelMap, HttpSession session) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			int accountid = (int) session.getAttribute("accountid");
			List<AuctionOutput> auctionOutputs = auctionAPIService.getAuction(accountid).execute().body();
//			AuctionOutput auctionOutput = auctionAPIService.search(id).execute().body();
//			modelMap.put("auction", auctionOutput);
//			System.out.println(auctionOutput.getHourStart());
			modelMap.put("auctions", auctionOutputs);	
			return "vendor/auction/index";
		} catch (Exception e) {
			return "error/400page";
		}
	}
	
	@RequestMapping(value = { "delete" }, method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id, ModelMap model, HttpSession session) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			boolean result = auctionAPIService.delAuction(id).execute().isSuccessful();
			int accountid = (int) session.getAttribute("accountid");
			List<AuctionOutput> auctionOutputs = auctionAPIService.getAuction(accountid).execute().body();	
			model.put("auctions", auctionOutputs);	
			return "redirect:/customer/view/auction/vendor";
		} catch (Exception e) {
			return "error/400page";		}
		
	}
}
