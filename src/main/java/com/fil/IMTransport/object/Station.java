package com.fil.IMTransport.object;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe représentant une gare
 * 
 * @author Océane
 *
 */
@Entity
public class Station {

	/**
	 * @param name String - Nom de la gare
	 */
	private String name;
	
	@Id
	/** identifiant de la gare */
	private int id;
	
	public Station() {
		super();
	}
	
	public Station(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
