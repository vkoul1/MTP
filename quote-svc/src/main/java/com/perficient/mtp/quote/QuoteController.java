package com.perficient.mtp.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.quote.service.QuoteService;

import reactor.core.publisher.Flux;

@RestController
public class QuoteController {
	
	private QuoteService	service;
	
	public QuoteController(QuoteService service) {
		this.service = service;
	}
	
	@LogExecutionTime
	@GetMapping("/quotes")
	public Flux<Quote> getQuotes(ServerRequest request) {
		return service.getQuotes();
	}

}
