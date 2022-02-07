package com.demo.controllers.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.Dtos.Output.AuctionProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.AuctionProductAPIService;
import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.AuctionAPIService;
import com.demo.services.ProductAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/view/auction" })
public class AuctionCustomerController {
	AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);

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
			case 401:
				return "customer/account/signIn/index";
			default:
				modelMap.put("auctions", response.body());
				return "customer/auction/happening/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}
	}

	@RequestMapping(value = { "vendor" }, method = RequestMethod.GET)
	public String vendor(ModelMap modelMap, HttpSession session) {
		try {
			AuctionAPIService auctionAPIService = APIClient.getClient().create(AuctionAPIService.class);
			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
			int accountid = (int) session.getAttribute("accountid");
			List<AuctionOutput> auctionOutputs = auctionAPIService.getAuction(accountid).execute().body();
			List<ProductOutput> productOutputs = productAPIService.getListProductUnsold(accountid).execute().body();
			modelMap.put("productOutputs", productOutputs);
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
			auctionAPIService.delAuction(id).execute().isSuccessful();
			int accountid = (int) session.getAttribute("accountid");
			List<AuctionOutput> auctionOutputs = auctionAPIService.getAuction(accountid).execute().body();
			model.put("auctions", auctionOutputs);
			return "redirect:/customer/view/auction/vendor";
		} catch (Exception e) {
			return "error/400page";
		}

	}

	@RequestMapping(value = { "start/{auctionid}" }, method = RequestMethod.GET)
	public String listProduct(ModelMap modelMap, @PathVariable("auctionid") int auctionid) {
		try {
			Response<AuctionOutput> response = auctionAPIService.getProduct(auctionid).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 401:
				return "customer/account/signIn/index";
			default:
				AuctionOutput rs = response.body();
				if (rs.getProductOutputs() == null) {
					return "error/400page";
				}
				modelMap.put("products", rs.getProductOutputs());
				modelMap.put("hourStart", rs.getHourStart());
				modelMap.put("eventDate", rs.getEventdate());
				modelMap.put("idauction", rs.getId());
				return "customer/auction/listproductauction";

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

	@RequestMapping(value = { "getproduct/{auctionid}/{productid}" }, method = RequestMethod.GET)
	public String listProduct(ModelMap modelMap, @PathVariable("auctionid") int auctionid,
			@PathVariable("productid") int productid) {
		try {
			AuctionProductAPIService apiService = APIClient.getClient().create(AuctionProductAPIService.class);
			Response<AuctionProductOutput> response = apiService.getByIdProductAndAuction(auctionid, productid)
					.execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 401:
				return "customer/account/signIn/index";
			default:
				AuctionProductOutput rs = response.body();
				AuctionHistoryInput auctionHistoryInput = new AuctionHistoryInput();
				modelMap.put("auctionHistoryInput", auctionHistoryInput);
				modelMap.put("product", rs.getProductOutput());
				modelMap.put("auction", rs.getAuctionOutput());
				return "customer/auction/detailAuction/index";

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

}
