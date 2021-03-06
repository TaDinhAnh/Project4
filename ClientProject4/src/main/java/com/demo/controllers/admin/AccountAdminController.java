package com.demo.controllers.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.services.APIClient;
import com.demo.services.AccountAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "admin/account" })
public class AccountAdminController {
	private AccountAPIService accountAPIService = APIClient.getClient().create(AccountAPIService.class);
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {
			Response<List<AccountOutput>> response = accountAPIService.findList().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				List<AccountOutput> rs = response.body();
				modelMap.put("accounts", rs);
				return "admin/account/index";
			}
		} catch (Exception e) {
			return "errorpage/400page";
		}
	}
	@RequestMapping(value = { "del/{id}" }, method = RequestMethod.GET)
	public String Del(@PathVariable("id") int id) {
		try {
			Response<Boolean> response = accountAPIService.delAccount(id).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				return "redirect:/admin/account/index";
			}
		} catch (Exception e) {
			return "errorpage/400page";
		}
	}
}
