package com.fil.IMTransport.object;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe représentant un arrêt dans un trajet
 * 
 * @author Océane
 *
 */
@Entity
public class Stop {

	/**
	 * @param date    Timestamp - Date de l'arrêt
	 * @param station Station - Station de l'arrêt
	 */
	private Timestamp date;
	private Station station;
	private int nbTrain;
	
	@Id
	/** identifiant de l'arrêt */
	private int id;
	
	
	public Stop() {
		super();
	}

	public Stop(Timestamp date, Station station) {
		super();
		this.date = date;
		this.station = station;
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

	public int getNbTrain() {
		return nbTrain;
	}

	public void setNbTrain(int nbTrain) {
		this.nbTrain = nbTrain;
	}
}
