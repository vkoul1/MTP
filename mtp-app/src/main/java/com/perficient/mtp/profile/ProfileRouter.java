package com.perficient.mtp.profile;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class ProfileRouter {


	@Bean
	RouterFunction<ServerResponse> getSymbolProfile(ProfileHandler profileHandler) {
		return route(GET("/mtp/symbol-profile/{symbol}"), profileHandler::getSymbolProfile);
	}

	@Bean
	RouterFunction<ServerResponse> getPriceHistory(ProfileHandler profileHandler) {
		return route(GET("/mtp/price-history/{symbol}"), profileHandler::getPriceHistory);
	}
}
