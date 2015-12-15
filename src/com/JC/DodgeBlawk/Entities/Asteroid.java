package com.JC.DodgeBlawk.Entities;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Management.Location;
import com.JC.DodgeBlawk.Management.Size;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Asteroid extends Entity {
	private static final long serialVersionUID = -1398744317369516322L;
	private float SMultiplier;

	public Asteroid(Location l, int id, Size s, float SMultiplier) {
		super(l, id, s);
		this.SMultiplier = SMultiplier;
	}

	//Gets the Speed Multiplier
	public float getSMultiplier(){
		return this.SMultiplier;
	}
	
	//Sets the Speed Multiplier
	public void setSMultiplier(float SMultiplier){
		this.SMultiplier = SMultiplier;
	}
	
	//Gets the Entity of this Asteroid
	public Entity getEntity() {
		return DodgeBlawk.getDataManager().getEntity(getId());
	}

	//Gets the values of the Asteroid and makes them into a string
	public String toString() {
		String blawk = "X: " + getLocation().getX() + ", Y: " + getLocation().getY() + ", Id: " + getId();
		return blawk;
	}
}