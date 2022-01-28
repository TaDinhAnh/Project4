package com.demo.controllers.customer;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Input.FeedBackInput;
import com.demo.services.APIClient;
import com.demo.services.FeedBackAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/view/contact" })
public class ContactCustomerController {
	private FeedBackAPIService feedBackAPIService = APIClient.getClient().create(FeedBackAPIService.class);

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("feedback", new FeedBackInput());
		return "customer/contact/index";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("feedback") FeedBackInput backInput, ModelMap modelMap, HttpSession session) {
		try {
			int accountid = (int) session.getAttribute("accountid");
			backInput.setAccountId(accountid);
			Response<Boolean> response = feedBackAPIService.create(backInput).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "error/400page";
			case 401:
				return "customer/account/signIn/index";
			default:
				if (!response.body()) {
					return "error/400page";
				}
				return "redirect:/customer/view/contact";
			}
		} catch (Exception e) {
			return "error/400page";
		}

	}
}
