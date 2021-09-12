package com.perficient.mtp.watchlist;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class WatchlistRouter {

//	@Bean
//	public RouterFunction<ServerResponse> route(WatchlistHandler watchlistHandler) {
//
//		return RouterFunctions
//			.route(GET("/watchlists"), watchlistHandler::watchlists)
//			.andRoute(GET("/watchlist-details/{id}"), watchlistHandler::watchlistDetails);
//	}

	@Bean
	RouterFunction<ServerResponse> getWatchlistsRoute(WatchlistHandler watchlistHandler) {
		return route(GET("/watchlists"), watchlistHandler::watchlists);
	}

	@Bean
	RouterFunction<ServerResponse> watWatchlistDetailsRoute(WatchlistHandler watchlistHandler) {
		return route(GET("/watchlist/{id}"), watchlistHandler::watchlistDetails);
	}
}
