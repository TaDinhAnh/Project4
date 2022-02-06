package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.AuctionProductAPIService;
import com.demo.services.ProductAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "auctionproduct" })
public class AuctionProductCustomerController {

	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		try {
			AuctionProductAPIService auctionProductAPIService = APIClient.getClient().create(AuctionProductAPIService.class);
			int accountid = (int) session.getAttribute("accountid");
			List<AuctionProductOutput> auctionproduct = auctionProductAPIService.findById(accountid).execute().body();
			modelMap.put("auctionproducts", auctionproduct);
			return "vendor/auctionproduct/index";
		} catch (Exception e) {
			return "error/400page";
		}
	}

}
