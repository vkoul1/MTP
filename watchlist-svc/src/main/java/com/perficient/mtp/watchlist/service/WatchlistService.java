package com.perficient.mtp.watchlist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.watchlist.model.Watchlist;
import com.perficient.mtp.watchlist.model.WatchlistDetails;
import com.perficient.mtp.watchlist.model.WatchlistList;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WatchlistService {

	
	private static Map<Long,WatchlistDetails> map = new HashMap<>();
	
	static {
		map.put(1L,  WatchlistDetails.builder()
						.id(1L)
						.name("My watchlist")
						.symbolList(List.of("AAPL", "GOOGL", "MSFT" )).build());

		map.put(2L,  WatchlistDetails.builder()
						.id(2L)
						.name("My 2nd watchlist")
						.symbolList(List.of("FORD", "TSLA", "GM" )).build());

		map.put(3L,  WatchlistDetails.builder()
						.id(3L)
						.name("Another watchlist")
						.symbolList(List.of("AMZN", "DIS" )).build());
	}

	
	// Better to do Optional here?
	@LogExecutionTime
	public Optional<WatchlistList> getWatchLists() {

		List<Watchlist> list = map.values().stream()
			.map(p -> new Watchlist(p.getId(), p.getName()))
			.sorted()
			.collect(Collectors.toList());
		
		return Optional.of(new WatchlistList(list));
	}


	// Or Mono ?
	@LogExecutionTime
	public Mono<WatchlistDetails> getWatchListDetails(long id) {

		return Mono.justOrEmpty(Optional.ofNullable(map.get(id))); 
	}
	
}
