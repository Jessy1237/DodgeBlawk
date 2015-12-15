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

public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467877653298191053L;
	private float X, Y;

	public Location(float x, float y) {
		this.X = x;
		this.Y = y;
	}

	//Gets the Y value of the Location
	public float getY() {
		return this.Y;
	}

	//Gets the X Value of the Location
	public float getX() {
		return this.X;
	}

	//Sets the X Value
	public void setX(float x) {
		this.X = x;
	}

	//Sets the Y Value
	public void setY(float y) {
		this.Y = y;
	}
	
	public String toString(){
		return "(" + getX() +", " + getY() + ")";
	}
}
