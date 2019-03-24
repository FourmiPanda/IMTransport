package com.fil.IMTransport.kafka;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class TripInfo {

	@JsonProperty("departure")
	private String departure;

	@JsonProperty("arrival")
	private String arrival;

	@JsonProperty("nbPassengers")
	private int nbPassengers;

	@JsonProperty("timestamp")
	private long timestamp;

	public TripInfo(String departure, String arrival, int nbPassengers, long timestamp) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.nbPassengers = nbPassengers;
		this.timestamp = timestamp;
	}

}
