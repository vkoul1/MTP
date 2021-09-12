package com.perficient.mtp.profile.pricehistory;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.mtp.profile.PriceHistory;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PriceHistoryController {

	private final PriceHistoryService service;

	@GetMapping("/price-history/{ticker}")
	@ResponseBody
	@Timed
	public ResponseEntity<PriceHistory> getPriceHistory(
			@PathVariable String ticker,
			@RequestParam(defaultValue = "30") int days) {

		Optional<PriceHistory> opt = service.getPriceHistory(ticker, days);
		
		return opt.isEmpty()
			? ResponseEntity.notFound().build()
			: new ResponseEntity<>(opt.get(), HttpStatus.OK);
	}

}
