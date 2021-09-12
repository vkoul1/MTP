package com.perficient.mtp.profile.symbolprofile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.perficient.mtp.profile.SymbolProfile;

public class SymbolProfileServiceTest {

	@Test
	public void testGetSymbolProfile() {
		
		SymbolProfileService service = new SymbolProfileService();
		
		Optional<SymbolProfile> opt = service.getSymbolProfile("TSLA");

		assertNotNull(opt);
		assertFalse(opt.isEmpty());
		assertEquals("TSLA", opt.get().getSymbol());
	}
}
