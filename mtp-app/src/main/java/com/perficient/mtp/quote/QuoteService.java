package com.perficient.mtp.quote;

import java.util.Collection;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class QuoteService {

	public Flux<Quote> getQuotes(Collection<String> symbols) {
		
		return Flux.empty();
	}

}
