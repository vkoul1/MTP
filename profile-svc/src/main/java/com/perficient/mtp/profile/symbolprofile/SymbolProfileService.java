package com.perficient.mtp.profile.symbolprofile;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perficient.mtp.commons.logging.LogExecutionTime;
import com.perficient.mtp.profile.SymbolProfile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SymbolProfileService {

	@LogExecutionTime
	public Optional<SymbolProfile> getSymbolProfile(String symbol) {

		return Optional.of(
					SymbolProfile.builder()
						.symbol(symbol)
						.build()
				);
	}

}
