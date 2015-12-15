package com.JC.DodgeBlawk.Management;

import java.io.Serializable;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Direction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6689830880087626997L;
	private String direction;

	public Direction(String direction) {
		this.direction = direction;
	}
	
	//Gets the Directions Name
	public String toString() {
		return this.direction;
	}
}
