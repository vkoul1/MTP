package com.perficient.mtp.watchlist.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.perficient.mtp.watchlist.model.WatchlistList;

public class WatchListServiceTest {

	@Test
	public void testGetWatchLists() {
		
		WatchlistService service = new WatchlistService();
		
		Optional<WatchlistList> opt = service.getWatchLists();

		assertNotNull(opt);
		assertFalse(opt.isEmpty());
		assertNotNull(opt.get().getWatchlists());
		assertFalse(opt.get().getWatchlists().isEmpty());
	}
}
