package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "error/" })
public class ErrorCustomerController {

	@RequestMapping(value = { "400page" }, method = RequestMethod.GET)
	public String error400() {
		return "error/400page";
	}

	@RequestMapping(value = { "404page" }, method = RequestMethod.GET)
	public String error404() {
		return "error/404page";
	}

	@RequestMapping(value = { "403page" }, method = RequestMethod.GET)
	public String error403() {
		return "error/403page";
	}
}
