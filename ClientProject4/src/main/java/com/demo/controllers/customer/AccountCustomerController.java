package com.demo.controllers.customer;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.services.APIClient;
import com.demo.services.AccountAPIService;
import com.demo.validators.Validate;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "/customer/account/" })
public class AccountCustomerController {
	@Autowired
	private Validate validate;

	@RequestMapping(value = { "signIn" }, method = RequestMethod.GET)
	public String login() {
		return "customer/account/signIn/index";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap map) {
		map.put("account", new AccountInput());
		return "customer/account/register/index";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("account") @Valid AccountInput accountInput, BindingResult bind,
			ModelMap map) {
		try {
			validate.validate(accountInput, bind);
			AccountAPIService accountAPIService = APIClient.getClient().create(AccountAPIService.class);
			Boolean checkGmail = accountAPIService.checkGmail(accountInput.getGmail()).execute().body();
			if (bind.hasErrors()) {
				return "customer/account/register/index";
			}
			if (checkGmail) {
				map.put("gmailExists", checkGmail);
				return "redirect:/customer/account/register";
			}
			Response<Boolean> response = accountAPIService.create(accountInput).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "customer/account/register/index";
			default:
				if (!response.body()) {
					return "customer/account/register/index";
				}
				return "redirect:/customer/account/signIn";

			}
		} catch (Exception e) {
			return "customer/account/register/index";
		}

	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
	public String login(@RequestParam("gmail") String gmail, @RequestParam("password") String password) {
		return "customer/view/home";

	}

	@RequestMapping(value = { "auctionhistory" }, method = RequestMethod.GET)
	public String auctionhistory() {
		return "customer/account/auctionhistory/index";
	}

	@RequestMapping(value = { "changeInfor" }, method = RequestMethod.GET)
	public String changeAccount(ModelMap map) {
			
			try {
				AccountAPIService accountAPIService = APIClient.getClient().create(AccountAPIService.class);
				Response<AccountOutput> response = accountAPIService.getAccount(2).execute();
				int statusCode = response.code();
				switch (statusCode) {
				case 400:
					return "error/400page";
				default:
					map.put("account", response.body());
					return "customer/account/changeInfor/index";
				}
			} catch (IOException e) {
				return "customer/account/signIn/index";
			}
		


	}
}
