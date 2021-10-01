package com.perficient.mtp.watchlist;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.watchlist.model.WatchlistDetails;
import com.perficient.mtp.watchlist.model.WatchlistList;

import reactor.core.publisher.Mono;

@Component
public class WatchlistHandler {
	
	private WatchlistClient	client;
	
	public WatchlistHandler(WatchlistClient service) {
		this.client = service;
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> watchlists(ServerRequest request) {
		return client.getWatchlists()
				.flatMap(x -> ServerResponse
	        		.ok()
					.contentType(MediaType.APPLICATION_JSON)
	        		.body(Mono.just(x), WatchlistList.class))
	        	.switchIfEmpty(ServerResponse
	        		.notFound()
	        		.build());
        
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> watchlistDetails(ServerRequest request) {
        final String id = request.pathVariable("id");
        
        return client.getWatchlistDetails(Long.parseLong(id))
	        .flatMap(x -> ServerResponse
	        		.ok()
					.contentType(MediaType.APPLICATION_JSON)
	        		.body(Mono.just(x), WatchlistDetails.class))
	        .switchIfEmpty(ServerResponse
	        		.notFound()
	        		.build());
	}
	


}
