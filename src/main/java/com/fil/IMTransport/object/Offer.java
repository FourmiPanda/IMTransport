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

	@JsonProperty("nb_passengers")
	private int nbPassengers;

	public Offer() {
		super();
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

	public void setStartHour(Timestamp startHour) {
		this.startHour = startHour;
	}

	public Timestamp getEndHour() {
		return endHour;
	}

	public void setEndHour(Timestamp endHour) {
		this.endHour = endHour;
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
