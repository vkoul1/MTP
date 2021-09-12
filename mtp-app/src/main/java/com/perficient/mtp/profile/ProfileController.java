package com.perficient.mtp.profile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProfileController {

	private final ProfileService priceHistoryService;

	@Timed
	@ResponseBody
	@GetMapping("/symbol-profile/{ticker}")
	public ResponseEntity<SymbolProfile> getSymbolProfile(@PathVariable String ticker) {

		Mono<SymbolProfile> mono = priceHistoryService.getSymbolProfile(ticker);

		SymbolProfile sp = mono.block();
		
		return (sp == null)
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(sp);
	}

	@Timed
	@ResponseBody
	@GetMapping("/price-history/{ticker}")
	public ResponseEntity<PriceHistory> getPriceHistory(
			@PathVariable String ticker,
			@RequestParam(defaultValue = "30") int days) {

		Mono<PriceHistory> mono = priceHistoryService.getPriceHistory(ticker, days);

		PriceHistory ph = mono.block();
		
		return (ph == null)
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(ph);
	}

}
