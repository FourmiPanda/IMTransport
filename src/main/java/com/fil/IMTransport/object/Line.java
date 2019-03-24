package com.fil.IMTransport.object;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe représentant une ligne de train
 * 
 * @author Océane
 *
 */
@Entity
public class Line {

	/**
	 * @param inaccessibilities Map<Timestamp, Inaccessibility> - Date et raison des
	 *                          inaccessibilités de la ligne
	 */
	@OneToMany
	private ArrayList<LineInaccessibility> inaccessibilities;
	
	/**
	 * @param bookings          Map<Timestamp, State> - Date et état des
	 *                          réservations de la ligne
	 */
	@OneToMany
	private ArrayList<Booking> bookings;
	
	/**
	 * @param start             Station - Station de départ de la ligne
	 */
	@ManyToOne
	private Station start;
	
	/**
	 * @param end               Station - Station de fin de ligne
	 */
	@ManyToOne
	private Station end;
	
	/**
	 * @param distance          int - Longueur (en km) de la ligne
	 */
	private int distance;
	
	@Id
	/** identifiant de la ligne */
	private int id;

	public Line() {
		super();
		this.inaccessibilities = new ArrayList<LineInaccessibility>();
		this.bookings = new ArrayList<Booking>();
	}

	public Line(Station start, Station end, int distance) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.inaccessibilities = new ArrayList<LineInaccessibility>();
		this.bookings = new ArrayList<Booking>();
	}

	public ArrayList<LineInaccessibility> getInaccessibilities() {
		return inaccessibilities;
	}

	public void setInaccessibilities(ArrayList<LineInaccessibility> inaccessibilities) {
		this.inaccessibilities = inaccessibilities;
	}
	
	public void addInnaccessibility(LineInaccessibility innaccessibility) {
		if(! inaccessibilities.contains(innaccessibility)) {
			innaccessibility.setLine(this);
			inaccessibilities.add(innaccessibility);
		}
	}

	public void removeInnaccessibility(LineInaccessibility innaccessibility) {
		if(inaccessibilities.contains(innaccessibility)) {
			innaccessibility.setLine(null); // TODO j'ai peur que ça génère un problem de not null en BDD
			inaccessibilities.remove(innaccessibility);
		}
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

	public int getId() {
		return id;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public void addBooking(Booking booking) {
		if(! bookings.contains(booking)) {
			booking.setLine(this);
			bookings.add(booking);
		}
	}
	
	public void removeBooking(Booking booking) {
		if(bookings.contains(booking)) {
			booking.setLine(null); // TODO j'ai peur que ça génère un problem de not null en BDD
			bookings.remove(booking);
		}
	}
}
