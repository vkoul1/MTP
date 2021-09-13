package com.perficient.mtp.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ProfileClient {

	private final WebClient client;

	
	public ProfileClient(WebClient.Builder builder,
			@Value("${mtp.profile-svc.base-url}") String baseURL) {
		
		this.client = builder.baseUrl(baseURL).build();
	}

	public Mono<SymbolProfile> getSymbolProfile(String symbol) {
		
		return this.client
				.get()
				.uri(uriBuilder -> uriBuilder
					.path("/symbol-profile/"+ symbol)
					.build()
				)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(SymbolProfile.class);
	}
	public Mono<PriceHistory> getPriceHistory(String symbol, int days) {
		
		return this.client
				.get()
				.uri(uriBuilder -> uriBuilder
					.path("/price-history/"+ symbol)
					.queryParam("days", days)
					.build()
				)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(PriceHistory.class);
	}

}
