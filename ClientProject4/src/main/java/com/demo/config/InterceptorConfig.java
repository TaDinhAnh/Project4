package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.interceptors.AdminInterceptor;
import com.demo.interceptors.CustomerInterceptor;
import com.demo.interceptors.VendorInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private VendorInterceptor vendorInterceptor;

	@Autowired
	private CustomerInterceptor customerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");
		registry.addInterceptor(vendorInterceptor).addPathPatterns("/vendor/**").excludePathPatterns(
				"/customer/view/**", "/customer/account/signIn", "/customer/account/register",
				"/customer/account/changeInfor", "/customer/account/logout", "/customer/auction/detailAuction/sendPrice");
		registry.addInterceptor(customerInterceptor).addPathPatterns("/customer/**").excludePathPatterns(
				"/customer/view/**", "/customer/account/signIn", "/customer/account/register",
				"/customer/account/changeInfor", "/customer/account/logout", "/customer/auction/detailAuction/sendPrice");
	}

}
