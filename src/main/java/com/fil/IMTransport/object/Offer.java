package com.fil.IMTransport.object;

import java.util.List;

/**
 * Représente une offre donnée par l'autorité de transport
 * 
 * @author Océane
 *
 */
public class Offer {

	/**
	 * @param trips List<Stroke> - Liste des courses répondant à l'offre
	 */
	private List<Trip> trips;

	public Offer() {
		super();
	}

	public Offer(List<Trip> trips) {
		super();
		this.trips = trips;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
}
