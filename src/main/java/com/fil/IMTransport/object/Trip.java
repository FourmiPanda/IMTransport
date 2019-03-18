package com.fil.IMTransport.object;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une course, qui a pour but de répondre à une offre. Si
 * les lignes A, B et C se suivent une course peut être A->C ou A->B->C par
 * exemple.
 * 
 * @author Océane
 *
 */
public class Trip {

	/**
	 * @param offer List<Offer> - Offres à laquelle répond la course
	 * @param stops List<Stop> - Liste des arrêts de la course
	 * @param lines List<Line> - Lignes utilisées par la course
	 * @param       int nbTrain - Nombre d'attelages de la course
	 */
	private List<Offer> offers;
	private List<Stop> stops;
	private List<Line> lines;
	private Timestamp startHour;
	private Timestamp endHour;
	private int nbTrain;

	public Trip() {
		super();
		this.offers = new ArrayList<Offer>();
		this.stops = new ArrayList<Stop>();
		this.lines = new ArrayList<Line>();
	}

	public Trip(List<Offer> offers, List<Stop> stops, List<Line> lines) {
		super();
		this.offers = offers;
		this.stops = stops;
		this.lines = lines;
		this.nbTrain = 1;
	}

	public Trip(List<Offer> offers, List<Stop> stops, List<Line> lines, int nbTrain) {
		super();
		this.offers = offers;
		this.stops = stops;
		this.lines = lines;
		this.nbTrain = nbTrain;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public int getNbTrain() {
		return nbTrain;
	}

	public void setNbTrain(int nbTrain) {
		this.nbTrain = nbTrain;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
