package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Dtos.Input.FeedBackInput;
import com.demo.services.APIClient;
import com.demo.services.FeedBackAPIService;

import retrofit2.Response;

@Controller
@RequestMapping(value = { "customer/view/contact" })
public class ContactCustomerController {

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("feedback", new FeedBackInput());
		return "customer/contact/index";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("feedback") FeedBackInput backInput,
			ModelMap modelMap) {
		try {
			backInput.setAccountId(3);
			FeedBackAPIService feedBackAPIService = APIClient.getClient().create(FeedBackAPIService.class);
			Response<Boolean> response = feedBackAPIService.create(backInput).execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "redirect:/customer/view/contact";
			default:
				if(!response.body()) {
					return "redirect:/customer/view/contact";
				}
				return "redirect:/customer/view/contact";
			}
		} catch (Exception e) {
			return "redirect:/customer/view/contact";
		}


	}
}
