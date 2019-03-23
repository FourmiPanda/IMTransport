package com.fil.IMTransport.kafka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fil.IMTransport.object.Station;

@XmlRootElement
public class BookingRequest {

	@XmlRootElement
	protected class BookingLine {

		public BookingLine(Date departureDate, Station start, Station end) {
			super();
			this.departureDate = departureDate;
			this.start = start;
			this.end = end;
		}

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

	@JsonProperty("lines")
	private List<BookingLine> lines = new ArrayList<>();

	public BookingRequest() {
	}

	public void addLine(Date departureDate, Station start, Station end) {
		lines.add(new BookingLine(departureDate, start, end));
	}

	public List<BookingLine> getLines() {
		return this.lines;
	}

}
