package com.perficient.mtp.watchlist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.perficient.mtp.watchlist.model.WatchlistDetails;
import com.perficient.mtp.watchlist.model.WatchlistList;

import reactor.core.publisher.Mono;

@Component
public class WatchlistClient {

	private final WebClient client;

	
	public WatchlistClient(WebClient.Builder builder,
			@Value("${mtp.watchlist-svc.base-url}") String baseURL) {
		
		this.client = builder.baseUrl(baseURL).build();
	}

	public Mono<WatchlistList> getWatchlists() {
		
		return this.client
				.get()
				.uri("/watchlists")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(WatchlistList.class);
	}

	public Mono<WatchlistDetails> getWatchlistDetails(Long id) {
		
		return this.client
				.get()
				.uri("/watchlist/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(WatchlistDetails.class);
	}

}
