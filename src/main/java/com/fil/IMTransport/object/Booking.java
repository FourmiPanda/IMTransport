package com.fil.IMTransport.object;

import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Booking {

	public enum State {
		DRAFT, OK, PENDING;
	}

	@Id
	private int id;

	@ManyToOne
	private Line line;

	private Timestamp startDate;

	private State state;

	/**
	 * @param String
	 *            idBooking - identifiant de réservation
	 */
	private String idBooking;

	public Booking() {
		super();
	}

	public Booking(Line line, Timestamp startDate, String idBooking, State state) {
		super();
		this.line = line;
		this.startDate = startDate;
		this.idBooking = idBooking;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
		line.addBooking(this);
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(String idBooking) {
		this.idBooking = idBooking;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
