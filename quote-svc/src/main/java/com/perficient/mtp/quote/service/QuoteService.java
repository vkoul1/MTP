package com.perficient.mtp.quote.service;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.quote.Quote;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuoteService {

	@LogExecutionTime
	public Flux<Quote> getQuotes() {

        Random r = new Random();
        double min = 130;
        double max = 160;
        
        return Flux.fromStream(Stream.generate(() -> r.nextDouble() * (max - min) + min)
            .map(d -> newQuote(d))
            .peek((q) -> {
                log.info(q.toString());
            }))
            .delayElements(Duration.ofSeconds(1L));
	}

	private Quote newQuote(Double d) {
		
		return Quote.builder()
				.sym("AAPL")
				.ap(d.floatValue())
				.bp(d.floatValue())
				.build();
	}
}
