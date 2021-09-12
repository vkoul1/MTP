package com.perficient.mtp.quote;

import org.springframework.stereotype.Service;

import com.perficient.mtp.profile.SymbolProfile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuoteService {

	public SymbolProfile getSymbolProfile(String symbol) {
		
		return SymbolProfile.builder()
				.symbol(symbol)
				.build();
	}

}
