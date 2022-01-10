package com.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ResponseInterceptor implements HandlerInterceptor  {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		int statusCode = response.getStatus();
		switch (statusCode) {
		case 404:
			modelAndView.setViewName("404page");
			break;
		case 401:
			modelAndView.setViewName(null);
			break;
		case 400:
			modelAndView.setViewName("404page");
			break;
		default:
			break;
		}
	}


}
