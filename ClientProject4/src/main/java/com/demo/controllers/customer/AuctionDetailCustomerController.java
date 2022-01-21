package com.demo.controllers.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Input.AuctionInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.AuctionHistoryAPIService;

@Controller
@RequestMapping(value = { "customer/auction/detailAuction" })
public class AuctionDetailCustomerController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(@RequestParam("id") int id, ModelMap modelMap, HttpSession session)   {
		try {
			AuctionHistoryAPIService auctionHistoryAPIService = APIClient.getClient()
					.create(AuctionHistoryAPIService.class);
			List<AuctionHistoryOutput> auctionHistoryOutput = auctionHistoryAPIService.getAuctionHistoryById(id).execute()
					.body();
			var count = auctionHistoryAPIService.countAuctionHistoryById(id).execute().body();
			modelMap.put("count", count);
			var maxpriceATM = auctionHistoryAPIService.maxPricetAuctionHistoryById(id).execute().body();
			modelMap.put("maxPriceATM",  maxpriceATM);
			for(int i =0; i <auctionHistoryOutput.size(); i++) {
				modelMap.put("getAuction", auctionHistoryOutput.get(1));
				modelMap.put("vendor", auctionHistoryOutput.get(1).getAccountname());
					session.setAttribute("productId", auctionHistoryOutput.get(1).getProductOutput().getId());
			}	
			
			modelMap.put("auctionhistorys", auctionHistoryOutput);		
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			AuctionOutput auctionOutput = auctionAPIService.search(id).execute().body();
			modelMap.put("auction", auctionOutput);
			
			modelMap.put("aucHis", new AuctionHistoryInput());
			return "customer/auction/detailAuction/index";
			
		} catch (Exception e) {
			return "customer/error/404page";
		}
	}
	
	@RequestMapping(value = {"sendPrice" }, method = RequestMethod.POST)
	public String sendPrice(@RequestParam("id") int id,  @ModelAttribute("aucHis") AuctionHistoryInput auctionHistoryInput, HttpSession session) throws IOException {
		AuctionHistoryAPIService auctionHistoryAPIService = APIClient.getClient()
				.create(AuctionHistoryAPIService.class);
		auctionHistoryInput.setAccountid(3);
		auctionHistoryInput.setAuctionid(id);
		auctionHistoryInput.setProductid((int) session.getAttribute("productId"));
		boolean auctionHistoryOutput = auctionHistoryAPIService.create(auctionHistoryInput).execute().isSuccessful();
		if(auctionHistoryOutput) {
			return "redirect:/customer/auction/detailAuction/index?id="+ id;
		}
		return "redirect:/customer/auction/detailAuction/index?id="+ id;
	}
	
}
