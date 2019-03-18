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

/**
 * Représente une offre donnée par l'autorité de transport
 * 
 * @author Océane
 *
 */
@XmlRootElement
public class Offer {

	/**
	 * @param startHour    Timestamp - Heure de départ de l'offre
	 * @param endHour      Timestamp - Heure de fin de l'offre
	 * @param startStation Station - Station de départ de l'offre
	 * @param endStation   Station - Station d'arrivée de l'offre
	 * @param line         Line - Ligne ciblée par l'offre
	 * @param nbPassengers int - Nombre de personnes voyageant sur la ligne entre
	 *                     l'heure de début et de fin
	 * @param trips        List<Stroke> - Liste des courses répondant à l'offre
	 */
	@JsonProperty("start")
	private Timestamp startHour;
	private Timestamp endHour;
	@JsonProperty("start_station")
	private Station startStation;
	@JsonProperty("end_station")
	private Station endStation;
	private Line line;
	@JsonProperty("nb_passengers")
	private int nbPassengers;
	private List<Trip> trips;
	
	@Id
	/** identifiant de l'offre */
	private int id;

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

	public Offer(Timestamp startHour, Timestamp endHour, Station startStation, Station endStation, int nbPassengers) {
		super();
		this.startHour = startHour;
		this.endHour = endHour;
		// Récupérer la ligne correspondant aux 2 arrêts
		this.nbPassengers = nbPassengers;
		this.trips = new ArrayList<Trip>();
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

		return mapper.readValue(url, new TypeReference<Offer>() {
		});
	}
}
