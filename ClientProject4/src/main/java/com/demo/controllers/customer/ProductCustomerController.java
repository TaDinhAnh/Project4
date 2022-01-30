package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Input.ProductInput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.Dtos.Output.OrdersOutput;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionProductAPIService;
import com.demo.services.CategoryAPIService;
import com.demo.services.OrdersAPIService;
import com.demo.services.ProductAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "vendor/product" })
public class ProductCustomerController {

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		try {
			int accountid = (int) session.getAttribute("accountid");
			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
			CategoryAPIService categoryAPIService = APIClient.getClient().create(CategoryAPIService.class);
			List<CategoryOutput> categoryOutputs = categoryAPIService.getCateNotDel().execute().body();
			Response<List<ProductOutput>> response = productAPIService.getListProductAccept(accountid).execute();
			List<ProductOutput> productOutputSold = productAPIService.getListProductSold(accountid).execute().body();
			List<ProductOutput> productOutputunSold = productAPIService.getListProductUnsold(accountid).execute()
					.body();
			List<ProductOutput> productOutputNotAccept = productAPIService.getListProductNotAccept(accountid).execute()
					.body();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				return "error/404page";
			default:
				modelMap.put("productlistAccept", response.body());
				modelMap.put("productOutputSold", productOutputSold);
				modelMap.put("productOutputunSold", productOutputunSold);
				modelMap.put("productOutputNotAccept", productOutputNotAccept);
				modelMap.put("categories", categoryOutputs);
				return "vendor/product/list/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

	@RequestMapping(value = { "detail" }, method = RequestMethod.GET)
	public String detail(ModelMap modelMap, @RequestParam("id") int productId, HttpSession session) {
		try {
			int accountid = (int) session.getAttribute("accountid");
			AuctionProductAPIService auctionProductAPIService = APIClient.getClient()
					.create(AuctionProductAPIService.class);
			OrdersAPIService ordersAPIService = APIClient.getClient()
					.create(OrdersAPIService.class);
			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
			AuctionProductOutput auctionproductOutput = auctionProductAPIService.findListSold(accountid, productId)
					.execute().body();	
			CategoryAPIService categoryAPIService = APIClient.getClient().create(CategoryAPIService.class);
			List<CategoryOutput> categoryOutputs = categoryAPIService.getCateNotDel().execute().body();
			ProductOutput productOutput = productAPIService.findByid(productId, accountid).execute().body();
			OrdersOutput ordersOutput = ordersAPIService.find(productId).execute().body();
			modelMap.put("orders", ordersOutput);
			modelMap.put("productlist", auctionproductOutput);
			modelMap.put("productOutput", productOutput);	
			modelMap.put("categories", categoryOutputs);
			return "vendor/product/detail/index";
		} catch (Exception e) {
			return "error/400page";
		}
	}
	
}
