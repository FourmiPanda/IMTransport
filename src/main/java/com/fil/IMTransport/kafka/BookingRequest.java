package com.fil.IMTransport.kafka;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fil.IMTransport.object.Station;

public class BookingRequest {

	protected class BookingLine {

		public BookingLine(Date departureDate, Station start, Station end) {
			super();
			this.departureDate = departureDate;
			this.start = start;
			this.end = end;
		}

		private Date departureDate;
		private Station start;
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

	private List<BookingLine> lines = new ArrayList<>();
	private boolean stops;

	public BookingRequest(boolean stops) {
		this.stops = stops;
	}

	public void addLine(Date departureDate, Station start, Station end) {
		lines.add(new BookingLine(departureDate, start, end));
	}

	public List<BookingLine> getLines() {
		return this.lines;
	}

	public boolean stops() {
		return this.stops;
	}

}
