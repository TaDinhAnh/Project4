package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.demo.controllers.SocketController;
import com.demo.services.SocketService;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	SocketService socketService;

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		SocketController sc = new SocketController();
		sc.setSocketService(socketService);
		registry.addHandler(sc, "/auction-socket").setAllowedOrigins("*");
		;
	}
}
