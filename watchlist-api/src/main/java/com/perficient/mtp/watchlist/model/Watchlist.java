package com.perficient.mtp.watchlist.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Watchlist implements Comparable<Watchlist> {

	protected final Long id;
	protected final String name;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Watchlist(@JsonProperty("id") Long id, @JsonProperty("symbol") String name) {
	    this.id = id;
	    this.name = name;
	}

	@Override
	public int compareTo(Watchlist o) {
		return name.compareTo(o.name);
	}
}
