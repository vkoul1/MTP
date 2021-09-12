package com.perficient.mtp.profile.pricehistory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.perficient.mtp.profile.Quote;
import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.profile.PriceHistory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceHistoryService {

	@LogExecutionTime
	public Optional<PriceHistory> getPriceHistory(String symbol, int days) {
		
		LocalDate start = LocalDate.now().minusDays(days);
		
		List<Quote> quoteList = Stream.iterate(start, d -> d.plusDays(1))
				  .limit(days)
				  .map(dt -> new Quote(dt, 1.42, 1000000))
				  .collect(Collectors.toList());

		return Optional.of(
					PriceHistory.builder()
						.symbol(symbol)
						.quoteList(quoteList)
						.build()
				);
	}

}
