package com.fil.IMTransport.object;

/**
 * Classe représentant une gare
 * 
 * @author Océane
 *
 */
public class Station {

	/**
	 * @param name String - Nom de la gare
	 */
	private String name;

	public Station() {
		super();
	}
	
	public Station(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
