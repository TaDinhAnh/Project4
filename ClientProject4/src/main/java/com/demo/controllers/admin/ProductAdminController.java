package com.demo.controllers.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Dtos.Output.ProductOutput;
import com.demo.services.APIClient;
import com.demo.services.ProductAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "admin/product" })
public class ProductAdminController {
	private ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {
			Response<List<ProductOutput>> response = productAPIService.findAll().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				List<ProductOutput> rs = response.body();
				modelMap.put("products", rs);
				return "admin/product/index";
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "errorpage/400page";
		}
	}

	@RequestMapping(value = "accpet/{id}", method = RequestMethod.GET)
	public String acceptProduct(@PathVariable("id") int id) {
		try {
			Response<Boolean> response = productAPIService.accept(id).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				return "redirect:/admin/product";
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return "errorpage/400page";
		}
	}
}
