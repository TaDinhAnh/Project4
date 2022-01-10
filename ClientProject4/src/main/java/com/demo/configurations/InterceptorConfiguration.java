package com.demo.configurations;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.interceptors.ResponseInterceptor;

@Configurable
public class InterceptorConfiguration implements WebMvcConfigurer {
	private ResponseInterceptor responseInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(responseInterceptor);
	}
	
	
	
}
