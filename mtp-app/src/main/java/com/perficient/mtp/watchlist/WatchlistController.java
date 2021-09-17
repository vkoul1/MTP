package com.perficient.mtp.watchlist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.mtp.watchlist.model.WatchlistDetails;
import com.perficient.mtp.watchlist.model.WatchlistList;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class WatchlistController {

	private final WatchlistClient watchlistClient;

	@Timed
	@ResponseBody
	@GetMapping("/watchlists")
	public ResponseEntity<WatchlistList> getWatchlists() {

		Mono<WatchlistList> mono = watchlistClient.getWatchlists();

		WatchlistList wl = mono.block();
		
		return (wl == null)
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(wl);
	}

	@Timed
	@ResponseBody
	@GetMapping("/watchlist/{id}")
	public ResponseEntity<WatchlistDetails> getWatchlistDetails(@PathVariable Long id) {

		Mono<WatchlistDetails> mono = watchlistClient.getWatchlistDetails(id);

		WatchlistDetails wd = mono.block();
		
		return (wd == null)
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(wd);
	}

}
