package com.perficient.mtp.quote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/*
 * From https://polygon.io/docs/websockets/ws_stocks_Q_anchor
{
	 "ev": "Q",
	 "sym": "MSFT",
	 "bx": 4,
	 "bp": 114.125,
	 "bs": 100,
	 "ax": 7,
	 "ap": 114.128,
	 "as": 160,
	 "c": 0,
	 "t": 1536036818784,
	 "z": 3
	}
 */

@Data
public class Quote {

	private final char	ev;		// event type
	private final String sym;	// ticker symbol for the given stock
	private final int bx;		// bid exchange ID
	private final float bp;		// bid price
	private final int bs;		// bid size
	private final int ax;		// ask exchange ID
	private final float ap;		// ask price
	private final int as;		// ask size
	private final int c;		// condition
	private final long t;		// timestamp (Unix)
	private final int z;		// The tape. (1 = NYSE, 2 = AMEX, 3 = Nasdaq)
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Quote(	@JsonProperty("ev") char ev,
					@JsonProperty("sym") String sym,
					@JsonProperty("bx") int bx,
					@JsonProperty("bp") float bp,
					@JsonProperty("bs") int bs,
					@JsonProperty("ax") int ax,
					@JsonProperty("ap") float ap,
					@JsonProperty("as") int as,
					@JsonProperty("c") int c,
					@JsonProperty("t") long t,
					@JsonProperty("z") int z) {
		super();
		this.ev = ev;
		this.sym = sym;
		this.bx = bx;
		this.bp = bp;
		this.bs = bs;
		this.ax = ax;
		this.ap = ap;
		this.as = as;
		this.c = c;
		this.t = t;
		this.z = z;
	}
	
	
}
