package com.fil.IMTransport.object;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Classe représentant une ligne de train
 * 
 * @author Océane
 *
 */
public class Line {

	/**
	 * @param inaccessibilities Map<Timestamp, Inaccessibility> - Date et raison des
	 *                          inaccessibilités de la ligne
	 * @param bookings          Map<Timestamp, State> - Date et état des
	 *                          réservations de la ligne
	 * @param start             Station - Station de départ de la ligne
	 * @param end               Station - Station de fin de ligne
	 * @param distance          int - Longueur (en km) de la ligne
	 */
	private Map<Timestamp, Inaccessibility> inaccessibilities;
	private Map<Timestamp, State> bookings;
	private Station start;
	private Station end;
	private int distance;

	public Line() {
		super();
	}

	public Line(Station start, Station end, int distance) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public Map<Timestamp, Inaccessibility> getInaccessibilities() {
		return inaccessibilities;
	}

	public void setInaccessibilities(Map<Timestamp, Inaccessibility> inaccessibilities) {
		this.inaccessibilities = inaccessibilities;
	}

	public Map<Timestamp, State> getBookings() {
		return bookings;
	}

	public void setBookings(Map<Timestamp, State> bookings) {
		this.bookings = bookings;
	}

	public Station getStart() {
		return start;
	}

	public void setStart(Station start) {
		this.start = start;
	}

	public Station getEnd() {
		return end;
	}

	public void setEnd(Station end) {
		this.end = end;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
