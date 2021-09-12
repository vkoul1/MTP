package com.perficient.mtp.watchlist.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WatchlistList {

	protected final List<Watchlist>		watchlists;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public WatchlistList(@JsonProperty("watchlists") List<Watchlist> watchlists) {
	    this.watchlists = watchlists;
	}

}
