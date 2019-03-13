package com.fil.IMTransport.object;

import java.sql.Timestamp;

/**
 * Classe représentant un arrêt dans un trajet
 * 
 * @author Océane
 *
 */
public class Stop {

	/**
	 * @param date    Timestamp - Date de l'arrêt
	 * @param station Station - Station de l'arrêt
	 */
	private Timestamp date;
	private Station station;

	public Stop() {
		super();
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}
}
