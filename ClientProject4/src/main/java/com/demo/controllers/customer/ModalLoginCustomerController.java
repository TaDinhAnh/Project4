package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"customer/account/modal/login" })
public class ModalLoginCustomerController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index() {
		return "customer/account/modal/login/index";
	}
}
