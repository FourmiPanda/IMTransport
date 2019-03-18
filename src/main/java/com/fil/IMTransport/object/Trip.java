package com.fil.IMTransport.object;

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
	 * @param offer Offer - Offre à laquelle répond la course
	 * @param stops List<Stop> - Liste des arrêts de la course
	 * @param lines List<Line> - Lignes utilisées par la course
	 * @param       int nbTrain - Nombre d'attelages de la course
	 */
	private Offer offer;
	private List<Stop> stops;
	private List<Line> lines;
	private int nbTrain;

	public Trip() {
		super();
	}

	public Trip(Offer offer, List<Stop> stops, List<Line> lines) {
		super();
		this.offer = offer;
		this.stops = stops;
		this.lines = lines;
		this.nbTrain = 1;
	}

	public Trip(Offer offer, List<Stop> stops, List<Line> lines, int nbTrain) {
		super();
		this.offer = offer;
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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
