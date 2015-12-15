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

public class Size implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5209654136675024709L;
	private int W, H;

	public Size(int W, int H) {
		this.W = W;
		this.H = H;
	}

	//Gets the Width
	public int getWidth() {
		return this.W;
	}

	//Gets the Height
	public int getHeight() {
		return this.H;
	}

	//Sets the Width
	public void setWidth(int W) {
		this.W = W;
	}

	//Sets the Height
	public void setHeight(int H) {
		this.H = H;
	}
	
	public String toString(){
		return "" + getWidth() + "x" + getHeight();
	}
}
