package com.demo.controllers.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Output.CategoryOutput;
import com.demo.services.APIClient;
import com.demo.services.CategoryAPIService;
import retrofit2.Response;

@Controller
@RequestMapping(value = { "admin/category" })
public class CategoryAdminContronller {
	private CategoryAPIService categoryAPIService = APIClient.getClient().create(CategoryAPIService.class);
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {
			Response<List<CategoryOutput>> response = categoryAPIService.findAll().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				List<CategoryOutput> rs = response.body();
				modelMap.put("categories", rs);
				return "admin/category/index";
			}
		} catch (Exception e) {
			return "errorpage/400page";
		}
	}
}
