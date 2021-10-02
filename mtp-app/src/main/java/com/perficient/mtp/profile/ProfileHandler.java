package com.perficient.mtp.profile;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perficient.mtp.commons.logging.LogExecutionTime;

import reactor.core.publisher.Mono;

@Component
public class ProfileHandler {
	
	private ProfileClient	client;
	
	public ProfileHandler(ProfileClient service) {
		this.client = service;
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> getSymbolProfile(ServerRequest request) {
		final String symbol = request.pathVariable("symbol");

		return client.getSymbolProfile(symbol)
				.flatMap(x -> ServerResponse
	        		.ok()
					.contentType(MediaType.APPLICATION_JSON)
	        		.body(Mono.just(x), SymbolProfile.class))
	        	.switchIfEmpty(ServerResponse
	        		.notFound()
	        		.build());
        
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> getPriceHistory(ServerRequest request) {
		final String symbol = request.pathVariable("symbol");
		
		int days = request.queryParam("days")
			    .map(s -> Integer.parseInt(s))
			    .orElseGet(() -> 7);
        
        return client.getPriceHistory(symbol, days)
	        .flatMap(x -> ServerResponse
	        		.ok()
					.contentType(MediaType.APPLICATION_JSON)
	        		.body(Mono.just(x), PriceHistory.class))
	        .switchIfEmpty(ServerResponse
	        		.notFound()
	        		.build());
	}
	


}
