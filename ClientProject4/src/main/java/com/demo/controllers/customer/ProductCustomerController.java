package com.demo.controllers.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionProductAPIService;
import com.demo.services.ProductAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "vendor/product" })
public class ProductCustomerController {

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {
			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
			Response<List<ProductOutput>> response = productAPIService.getListProductAccept(1).execute();
			List<ProductOutput> productOutputSold = productAPIService.getListProductSold(1).execute().body();
			List<ProductOutput> productOutputunSold = productAPIService.getListProductUnsold(3).execute().body();
			List<ProductOutput> productOutputNotAccept = productAPIService.getListProductNotAccept(1).execute().body();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			case 401:
				return "customer/account/signIn/index";
			default:
				modelMap.put("productlistAccept", response.body());
				modelMap.put("productOutputSold", productOutputSold);
				modelMap.put("productOutputunSold", productOutputunSold);
				modelMap.put("productOutputNotAccept", productOutputNotAccept);
				return "vendor/product/list/index";
			}

		} catch (Exception e) {
			return "error/404page";
		}
	}

	@RequestMapping(value = { "detail" }, method = RequestMethod.GET)
	public String detail(ModelMap modelMap, @RequestParam("id") int productId) {
		try {
			AuctionProductAPIService auctionProductAPIService = APIClient.getClient()
					.create(AuctionProductAPIService.class);
			Response<AuctionProductOutput> response = auctionProductAPIService.findListSold(2, productId).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			default:
				modelMap.put("productlist", response.body());
				return "vendor/product/detail/index";
			}
		} catch (Exception e) {
			return "error/404page";
		}
	}
}
