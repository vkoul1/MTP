package com.perficient.mtp.profile.pricehistory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.perficient.mtp.profile.PriceHistory;

public class PriceHistoryServiceTest {

	@Test
	public void testGetSymbolProfile() {
		
		PriceHistoryService service = new PriceHistoryService();
		
		Optional<PriceHistory> opt = service.getPriceHistory("TSLA", 30);

		assertNotNull(opt);
		assertFalse(opt.isEmpty());
		assertEquals("TSLA", opt.get().getSymbol());
		assertEquals(30, opt.get().getQuoteList().size());
	}
}
