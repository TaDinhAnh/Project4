package com.demo.controllers.customer;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Input.AccountInput;
import com.demo.Dtos.Input.Login;
import com.demo.Dtos.Output.AccountOutput;
import com.demo.services.APIClient;
import com.demo.services.AccountAPIService;
import com.demo.validators.Validate;
import retrofit2.Response;

@Controller
@RequestMapping(value = { "/customer/account/" })
public class AccountCustomerController {
	private AccountAPIService accountAPIService = APIClient.getClient().create(AccountAPIService.class);
	@Autowired
	private Validate validate;

	@RequestMapping(value = { "signIn" }, method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("login", new Login());
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
				return "error/400page";
			default:
				return "redirect:/customer/account/signIn";
			}
		} catch (Exception e) {
			return "customer/account/register/index";
		}

	}

	@RequestMapping(value = { "signIn" }, method = RequestMethod.POST)
	public String login(@ModelAttribute("login") Login login, ModelMap modelMap, HttpSession session) {

		Response<AccountOutput> response;
		try {
			response = accountAPIService.login(login).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 404:
				modelMap.put("msg", "Email or Password invalid!");
				return "customer/account/signIn/index";
			default:
				AccountOutput accountOutput = response.body();
				String jwtToken = response.headers().get("Authorization");
				session.setAttribute("jwtToken", jwtToken);
				session.setAttribute("accountid", accountOutput.getId());
				session.setAttribute("account", accountOutput);
				return "redirect:/customer/view/home/index";
			}
		} catch (IOException e) {
			return "error/400page";
		}

	}

	@RequestMapping(value = { "auctionhistory" }, method = RequestMethod.GET)
	public String auctionhistory() {
		return "customer/account/auctionhistory/index";
	}

	@RequestMapping(value = { "changeInfor" }, method = RequestMethod.GET)
	public String changeAccount(ModelMap map, HttpSession session) {
		try {
			int accountId = (int) session.getAttribute("accountid");
			Response<AccountOutput> response = accountAPIService.getAccount(accountId).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			default:
				map.put("account", response.body());
				return "customer/account/changeInfor/index";
			}
		} catch (Exception e) {
			return "error/400page";
		}

	}
}
