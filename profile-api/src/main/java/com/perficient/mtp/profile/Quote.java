package com.perficient.mtp.profile;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Quote {
	
	private final LocalDate		date;
	private final double		price;
	private final int			volume;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Quote(@JsonProperty("date") LocalDate date, @JsonProperty("price") double price, @JsonProperty("volume") int volume) {
	    this.date = date;
	    this.price = price;
	    this.volume = volume;
	}
}
