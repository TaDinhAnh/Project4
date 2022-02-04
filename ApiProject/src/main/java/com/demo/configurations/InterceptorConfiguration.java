package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.demo.interceptors.Log1Interceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	@Autowired
	private Log1Interceptor log1Interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(log1Interceptor).excludePathPatterns("/api/authentication/**");
	}
	
}
