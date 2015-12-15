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

public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -240786975687149363L;
	private String diff;
	private float score;
	
	public Score(String diff, float score){
		this.diff = diff;
		this.score = score;
	}
	
	// Gets the Score
	public float getScore() {
		return this.score;
	}

	// Sets the score
	public void setScore(float score) {
		this.score = score;
	}

	// Gets the Difficulty
	public String getDifficulty() {
		return this.diff;
	}
}
