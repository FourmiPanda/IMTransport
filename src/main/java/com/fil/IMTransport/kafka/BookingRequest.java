package com.fil.IMTransport.kafka;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fil.IMTransport.object.Station;

@XmlRootElement
public class BookingRequest {

	public BookingRequest(String idRequest, Date departureDate, Station start, Station end) {
		this.departureDate = departureDate;
		this.start = start;
		this.end = end;
	}

	@JsonProperty("idRequest")
	private String idRequest;
	@JsonProperty("startTime")
	private Date departureDate;
	@JsonProperty("startStation")
	private Station start;
	@JsonProperty("endStation")
	private Station end;

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public Station getStart() {
		return this.start;
	}

	public Station getEnd() {
		return this.end;
	}

}
