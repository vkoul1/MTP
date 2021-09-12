package com.perficient.mtp.profile;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceHistory {
	
	private final String symbol;
	private final List<Quote> quoteList;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PriceHistory(@JsonProperty("symbol") String symbol, @JsonProperty("quoteList") List<Quote> quoteList) {
	    this.symbol = symbol;
	    this.quoteList = quoteList;
	}
}
