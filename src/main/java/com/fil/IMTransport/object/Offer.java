package com.fil.IMTransport.object;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Représente une offre donnée par l'autorité de transport
 * 
 * @author Océane
 *
 */
@XmlRootElement
@Entity
public class Offer {
	/**
	 * @param startHour    Timestamp - Heure de départ de l'offre
	 */
	@JsonProperty("start")
	private Timestamp startHour;
	
	/**
	 * @param endHour      Timestamp - Heure de fin de l'offre
	 */
	private Timestamp endHour;

	/**
	 * @param startStation Station - Station de départ de l'offre
	 */
	@ManyToOne
	@JsonProperty("start_station")
	private Station startStation;

	/**
	 * @param endStation   Station - Station d'arrivée de l'offre
	 */
	@ManyToOne
	@JsonProperty("end_station")
	private Station endStation;

	/**
	 * @param nbPassengers int - Nombre de personnes voyageant sur la ligne entre l'heure de début et de fin
	 */
	@JsonProperty("nb_passengers")
	private int nbPassengers;
	
	/**
	 * @param trips        List<Stroke> - Liste des courses répondant à l'offre
	 */
	@ManyToMany
	private List<Trip> trips;
	
	@Id
	/** identifiant de l'offre */
	private int id;

	public Offer() {
		super();
		trips = new ArrayList<Trip>();
	}

	public Offer(Timestamp startHour, Timestamp endHour, int nbPassengers) {
		super();
		this.startHour = startHour;
		this.endHour = endHour;
		this.nbPassengers = nbPassengers;
	}

	public Offer(Timestamp startHour, Timestamp endHour, Station startStation, Station endStation, int nbPassengers) {
		super();
		this.startHour = startHour;
		this.endHour = endHour;
		// Récupérer la ligne correspondant aux 2 arrêts
		this.startStation = startStation;
		this.endStation = endStation;
		this.nbPassengers = nbPassengers;
	}

	public Timestamp getStartHour() {
		return startHour;
	}

	public Station getStartStation() {
		return startStation;
	}
	public Station getEndStation() {
		return endStation;
	}

	public Timestamp getEndHour() {
		return endHour;
	}

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void addTrip(Trip trip) {
		if(! trips.contains(trip)) {
			this.trips.add(trip);
			trip.addOffer(this);
		}
	}
	
	/**
	 * Méthode permettant de parser une offre
	 * 
	 * @param url String - Url permettant de récupérer le Json de l'offre
	 * @return Offre sous forme d'un objet Java
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Offer parse(String url) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(url, new TypeReference<Offer>() {});
	}
}
