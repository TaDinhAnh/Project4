package com.demo.controllers.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.common.PaypalPaymentIntent;
import com.demo.common.Utils;
import com.demo.common.paypalMethod;
import com.demo.services.APIClient;
import com.demo.services.OrdersAPIService;
import com.demo.services.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@Controller
@RequestMapping(value = { "paypal/" })
public class PaypalController {
	public static final String URL_PAYPAL_SUCCESS = "paypal/success";
	public static final String URL_PAYPAL_CANCEL = "paypal/cancel";

	@Autowired
	private PaypalService paypalService;

	@RequestMapping(value = { "pay" }, method = RequestMethod.POST)
	public String pay(HttpServletRequest request, @RequestParam("idOrders") String idOrders,
			@RequestParam("price") double price, @RequestParam("address") String address) {
		String desc = idOrders + "@" + address;
		String cancelUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		try {
			Payment payment = paypalService.createPayment(price, "USD", paypalMethod.paypal, PaypalPaymentIntent.sale,
					desc, cancelUrl, successUrl);
			for (Links links : payment.getLinks()) {
				if (links.getRel().equals("approval_url")) {
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			return "error/400page";
		}
		return "redirect:/";
	}

	@GetMapping(value = "cancel")
	public String cancelPay() {
		return "redirect:/customer/orders/getByCus";
	}

	@RequestMapping(value = "success")
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("token") String token,
			@RequestParam("PayerID") String payerId) {
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if (payment.getState().equals("approved")) {
				Transaction item = payment.getTransactions().get(0);
				String desc = item.getDescription();
				String[] rs = desc.split("@");
				int idOrder = Integer.parseInt(rs[0]);
				OrdersAPIService apiService = APIClient.getClient().create(OrdersAPIService.class);
				try {
					apiService.payment(idOrder, rs[1]).execute();
					return "redirect:/customer/orders/getByCus";
				} catch (IOException e) {
					return "redirect:/customer/orders/getByCus";
				}
			}
		} catch (PayPalRESTException e) {
			return "error/400page";
		}
		return "redirect:/";
	}

}
