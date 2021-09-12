package com.perficient.mtp.profile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymbolProfile {
	
	private final String symbol;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public SymbolProfile(@JsonProperty("symbol") String symbol) {
	    this.symbol = symbol;
	}
}
