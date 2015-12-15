package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;

import org.newdawn.slick.Image;

import com.JC.DodgeBlawk.Graphics.Images;
import com.JC.DodgeBlawk.Management.Location;
import com.JC.DodgeBlawk.Management.Power;
import com.JC.DodgeBlawk.Management.Size;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class PowerUp extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7669110135540487075L;
	private Power p;
	private int texNum, last;
	private long time;

	public PowerUp(Location l, int id, Size s, Power p, int texNum, int last, long time) {
		super(l, id, s);
		this.p = p;
		this.texNum = texNum;
		this.last = last;
		this.time = time;
	}

	// Gets the Power
	public Power getPower() {
		return this.p;
	}

	// Gets the Texture Number
	public int getTexNum() {
		return this.texNum;
	}

	// Gets the Texture
	public Image getTexture() {
		Image img = null;

		if (texNum == 1) {
			img = Images.PowerUp1;
		} else if (texNum == 2) {
			img = Images.PowerUp2;
		} else if (texNum == 3) {
			img = Images.PowerUp3;
		}
		return img;
	}

	// Gets the amount of time a powerup can survive on screen
	public int getLast() {
		return this.last;
	}

	// Gets the amount of time the powerup has been on screen
	public long getTime() {
		return this.time;
	}

	// Sets the amount of time the powerup has been on screen
	public void setTime(long time) {
		this.time = time;
	}

	public String toString() {
		return "Location: " + getLocation().toString() + ", ID: " + getId() + ", Size: " + getSize().toString() + ", Power: " + getPower().getName();
	}
}
