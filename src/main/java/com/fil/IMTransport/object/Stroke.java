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
public class Stroke {

	/**
	 * @param offer Offer - Offre à laquelle répond la course
	 * @param lines List<Line> - Lignes utilisées par la course
	 * @param       int nbTrain - Nombre d'attelages de la course
	 */
	private Offer offer;
	private List<Line> lines;
	private int nbTrain;

	public Stroke() {
		super();
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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
