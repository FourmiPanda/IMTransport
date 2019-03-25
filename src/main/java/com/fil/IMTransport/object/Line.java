package com.fil.IMTransport.object;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private List<LineInaccessibility> inaccessibilities = new ArrayList<LineInaccessibility>();
	
	/**
	 * @param bookings          Map<Timestamp, State> - Date et état des
	 *                          réservations de la ligne
	 */
	@OneToMany
	private List<Booking> bookings = new ArrayList<Booking>();
	
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
	}

	public Line(Station start, Station end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	public List<LineInaccessibility> getInaccessibilities() {
		return inaccessibilities;
	}

	public void setInaccessibilities(List<LineInaccessibility> inaccessibilities) {
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
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
