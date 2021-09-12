package com.perficient.mtp.watchlist.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WatchlistDetails {

	protected final Long id;
	protected final String name;
	private final List<String> symbolList;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public WatchlistDetails(@JsonProperty("id") Long id,
							@JsonProperty("name") String name,
							@JsonProperty("symbolList") List<String> symbolList) {
	    this.id = id;
	    this.name = name;
	    this.symbolList = symbolList;
	}
}
