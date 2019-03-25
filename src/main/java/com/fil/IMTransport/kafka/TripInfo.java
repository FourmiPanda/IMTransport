package com.fil.IMTransport.kafka;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class TripInfo {

	@JsonProperty("start_station")
	private String departure;

	@JsonProperty("end_station")
	private String arrival;

	@JsonProperty("nb_passengers")
	private int nbPassengers;

	@JsonProperty("start")
	private long timestamp;

	public TripInfo(String departure, String arrival, int nbPassengers, long timestamp) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.nbPassengers = nbPassengers;
		this.timestamp = timestamp;
	}

}
