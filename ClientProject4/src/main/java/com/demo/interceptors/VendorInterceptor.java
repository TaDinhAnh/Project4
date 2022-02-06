package com.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.Dtos.Output.AccountOutput;
import com.demo.common.ERole;

@Component
public class VendorInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			AccountOutput accountOutput = (AccountOutput) request.getSession().getAttribute("account");
			if (accountOutput == null || accountOutput.getRole() != ERole.vendor) {
			//	response.sendRedirect("/error/403page");
				return true;
			}
			return true;
		} catch (Exception e) {
			response.sendRedirect("/error/403page");
			return false;
		}
	}
}
