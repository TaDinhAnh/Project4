package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.common.Constant;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@Configuration
public class paypalConfig {
	private String clientId = Constant.paypalClientApp;

	private String clientSecret = Constant.paypalClientSecret;

	private String mode = Constant.paypalMode;

	@Bean
	public Map<String, String> paypalSdkConfig() {
		Map<String, String> sdkConfig = new HashMap<>();
		sdkConfig.put("mode", mode);
		return sdkConfig;
	}

	@Bean
	public OAuthTokenCredential authTokenCredential() {
		return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
	}
	@Bean
	public APIContext apiContext() throws PayPalRESTException {
		APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
		apiContext.setConfigurationMap(paypalSdkConfig());
		return apiContext;
	}
}
