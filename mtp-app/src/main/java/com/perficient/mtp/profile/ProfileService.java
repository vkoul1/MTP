package com.perficient.mtp.profile;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/*
 * Created this for unit testing, may not be necessary
 */
@Component
@RequiredArgsConstructor
public class ProfileService {

	private final ProfileClient client;

	
	public Mono<SymbolProfile> getSymbolProfile(String symbol) {
		
		return client.getSymbolProfile(symbol);
	}
	
	
	public Mono<PriceHistory> getPriceHistory(String symbol, int days) {
		
		return client.getPriceHistory(symbol, days);
	}

}
