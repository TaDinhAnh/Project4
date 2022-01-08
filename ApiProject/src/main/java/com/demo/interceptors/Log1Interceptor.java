package com.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.demo.common.JwtTokenUtils;
import com.demo.models.Account;
import com.demo.services.IAccountService;

@Component
public class Log1Interceptor implements HandlerInterceptor {

	@Autowired
	private IAccountService accountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			String jwt = request.getHeader("Authorization");
			if (jwt == null) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
				return false;
			}
			Account account = accountService.findByGmail(JwtTokenUtils.getGmailFromToken(jwt));
			if (account == null || JwtTokenUtils.isTokenExpired(jwt)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
				return false;
			}
			return true;
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			return false;
		}
	}

}
