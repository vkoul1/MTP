package com.perficient.mtp.watchlist;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.watchlist.model.WatchlistDetails;
import com.perficient.mtp.watchlist.service.WatchlistService;

import reactor.core.publisher.Mono;

@Component
public class WatchlistHandler {
	
	private WatchlistService	service;
	
	public WatchlistHandler(WatchlistService service) {
		this.service = service;
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> watchlists(ServerRequest request) {
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(service.getWatchLists()));
	}
	

	@LogExecutionTime
	public Mono<ServerResponse> watchlistDetails(ServerRequest request) {
        final String id = request.pathVariable("id");
        
        return service.getWatchListDetails(Long.parseLong(id))
	        .flatMap(x -> ServerResponse
	        		.ok()
					.contentType(MediaType.APPLICATION_JSON)
	        		.body(Mono.just(x), WatchlistDetails.class))
	        .switchIfEmpty(ServerResponse
	        		.notFound()
	        		.build());
	}
	


}
