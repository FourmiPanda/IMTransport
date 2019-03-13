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
	 * @param strokes List<Stroke> - Liste des courses répondant à l'offre
	 */
	private List<Stroke> strokes;

	public Offer() {
		super();
	}

	public List<Stroke> getStrokes() {
		return strokes;
	}

	public void setStrokes(List<Stroke> strokes) {
		this.strokes = strokes;
	}
}
