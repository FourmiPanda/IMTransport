package com.fil.IMTransport.object;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Classe représentant une course, qui a pour but de répondre à une offre. Si
 * les lignes A, B et C se suivent une course peut être A->C ou A->B->C par
 * exemple.
 * 
 * @author Océane
 *
 */
@Entity
public class Trip {
	/**
	 * @param offer List<Offer> - Offres à laquelle répond la course
	 */
	@ManyToMany
	private List<Offer> offers;
	
	/**
	 * @param stops List<Stop> - Liste des arrêts de la course
	 */
	@OneToMany
	private List<Stop> stops;
	
	/**
	 * @param lines List<Line> - Lignes utilisées par la course
	 */
	@ManyToMany
	private List<Line> lines;
	
	/**
	 * @param startHour    Timestamp - Heure de départ de l'offre
	 */
	private Timestamp startHour;
	
	/**
	 * @param endHour      Timestamp - Heure de fin de l'offre
	 */
	private Timestamp endHour;
	
	/**
	 * @param int nbTrain - Nombre d'attelages de la course
	 */
	private int nbTrain;
	
	@Id
	/** identifiant de la course */
	private int id;
	
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

	public void addLine(Line line) {
		if(! lines.contains(line)) {
			lines.add(line);
		}
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

	public void addStop(Stop stop) {
		if(! stops.contains(stop)) {
			stops.add(stop);
		}
	}
	
	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public void addOffer(Offer offer) {
		if(! offers.contains(offer)) {
			offers.add(offer);
			offer.addTrip(this);
		}
	}
	
	public Timestamp getTimeAtStation(Station s) {
		// TODO @Lucille : Voir où mettre cette méthode
		for (Stop stop : getStops()) {
			if (stop.getStation().equals(s)) {
				return stop.getDate();
			}
		}
		for (Line line : getLines()) {
			if (line.getEnd().equals(s)) {
				long date = getTimeAtStation(line.getStart()).getTime();
				long deltaT = (line.getDistance() / Global.SPEED_TRAIN) * Duration.ofHours(1).toMillis();
				return new Timestamp(date + deltaT);
			}
		}
		return null;
	}
}
