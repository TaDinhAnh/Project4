package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"customer/pageAgentsGrid" })
public class PageAgentsGridCustomerController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index() {
		return "customer/pageAgentsGrid/index";
	}
}
