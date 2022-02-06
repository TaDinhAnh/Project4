package com.demo.controllers.customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.ProductAPIService;

@Controller
@RequestMapping(value = { "customer/view/home" })
public class HomeCustomerController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		try {
			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
			List<ProductOutput> productOutputs = productAPIService.getListLimit().execute().body();
			modelMap.put("products", productOutputs);
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			List<AuctionOutput> auctionOutputs = auctionAPIService.getLimitAuctionHappening().execute().body();
			modelMap.put("auctions", auctionOutputs);	
			System.out.println(auctionOutputs.size());
			List<ProductOutput> outputs = productAPIService.findList().execute().body();
			modelMap.put("productlist", outputs);
			session.getAttribute("account");
			return "customer/home/index";
		} catch (Exception e) {
			return "errorpage/400page";
		}
	}
}
