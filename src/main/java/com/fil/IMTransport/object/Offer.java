package com.fil.IMTransport.object;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une offre donnée par l'autorité de transport
 * 
 * @author Océane
 *
 */
public class Offer {

	/**
	 * @param startHour    Timestamp - Heure de départ de l'offre
	 * @param endHour      Timestamp - Heure de fin de l'offre
	 * @param line         Line - Ligne ciblée par l'offre
	 * @param nbPassengers int - Nombre de personnes voyageant sur la ligne entre
	 *                     l'heure de début et de fin
	 * @param trips        List<Stroke> - Liste des courses répondant à l'offre
	 */
	private Timestamp startHour;
	private Timestamp endHour;
	private Line line;
	private int nbPassengers;
	private List<Trip> trips;

	public Offer() {
		super();
		this.trips = new ArrayList<Trip>();
	}
	
	public Offer(Timestamp startHour, Timestamp endHour, Line line, int nbPassengers, List<Trip> trips) {
		super();
		this.startHour = startHour;
		this.endHour = endHour;
		this.line = line;
		this.nbPassengers = nbPassengers;
		this.trips = trips;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Timestamp getStartHour() {
		return startHour;
	}

	public void setStartHour(Timestamp startHour) {
		this.startHour = startHour;
	}

	public Timestamp getEndHour() {
		return endHour;
	}

	public void setEndHour(Timestamp endHour) {
		this.endHour = endHour;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void setNbPassengers(int nbPassengers) {
		this.nbPassengers = nbPassengers;
	}
}
