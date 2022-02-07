package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.AuctionHistoryAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/auction/detailAuction" })
public class AuctionDetailCustomerController {
	private AuctionHistoryAPIService auctionHistoryAPIService = APIClient.getClient()
			.create(AuctionHistoryAPIService.class);

//	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
//	public String index(@RequestParam("id") int id, ModelMap modelMap, HttpSession session) {
//		try {
//			List<AuctionHistoryOutput> auctionHistoryOutput = auctionHistoryAPIService.getAuctionHistoryById(id)
//					.execute().body();
//			
//			for (int i = 0; i < auctionHistoryOutput.size(); i++) {
//				modelMap.put("getAuction", auctionHistoryOutput.get(1));
//				modelMap.put("vendor", auctionHistoryOutput.get(1).getAccountname());
//				session.setAttribute("productId", auctionHistoryOutput.get(1).getProductOutput().getId());
//			}
//
//			modelMap.put("auctionhistorys", auctionHistoryOutput);
//			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
//			AuctionOutput auctionOutput = auctionAPIService.search(id).execute().body();
//			modelMap.put("auction", auctionOutput);
//			modelMap.put("aucHis", new AuctionHistoryInput());
//			return "customer/auction/detailAuction/index";
//		} catch (Exception e) {
//			return "error/400page";
//		}
//	}

	@RequestMapping(value = { "sendPrice" }, method = RequestMethod.POST)
	public String sendPrice(@RequestParam("id") int id, @RequestParam("proId") int proId,
			@ModelAttribute("aucHis") AuctionHistoryInput auctionHistoryInput, HttpSession session, ModelMap modelMap) {
		if (session.getAttribute("account") == null) {
			return "redirect:/customer/account/signIn";
		}
		try {
			int accountid = (int) session.getAttribute("accountid");
			auctionHistoryInput.setAccountid(accountid);
			auctionHistoryInput.setAuctionid(id);
			auctionHistoryInput.setProductid(proId);
			Response<Boolean> response = auctionHistoryAPIService.create(auctionHistoryInput).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			default:
				
				return "redirect:/customer/view/auction/getproduct/" + id +"/"+proId;
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

}
