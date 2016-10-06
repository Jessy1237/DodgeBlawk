package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Management.Collision;
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

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2736329497015617273L;
	private int id;
	private Location location;
	private Size size;

	public Entity(Location l, int id, Size s) {
		this.id = id;
		this.location = l;
		this.size = s;
	}

	//Gets the ID of the Entity, way of recognition
	public int getId() {
		return this.id;
	}

	//Gets the Location
	public Location getLocation() {
		return this.location;
	}

	//Gets the Size
	public Size getSize() {
		return this.size;
	}

	//Sets the Location
	public void setLocation(Location l) {
		this.location = l;
	}

	//Sets the Size
	public void setSize(Size s) {
		this.size = s;
	}

	//Checks to see if the entity has collided with any other entity
	public boolean isCollided() {
		for (Entity e : DodgeBlawk.getDataManager().entities) {
			if (e != null) {
				if (getLocation().getX() > e.getLocation().getX() && getLocation().getX() < (e.getLocation().getX() + e.getSize().getWidth()) && getLocation().getY() > e.getLocation().getY() && getLocation().getY() < (e.getLocation().getY() + e.getSize().getHeight())) {
					DodgeBlawk.getDataManager().addCollision(new Collision(this, e));
					return true;
				} else if (getLocation().getX() + getSize().getWidth() > e.getLocation().getX() && getLocation().getX() + getSize().getWidth() < (e.getLocation().getX() + e.getSize().getWidth()) && getLocation().getY() > e.getLocation().getY()
						&& getLocation().getY() < (e.getLocation().getY() + e.getSize().getHeight())) {
					DodgeBlawk.getDataManager().addCollision(new Collision(this, e));
					return true;
				} else if (getLocation().getX() + getSize().getWidth() > e.getLocation().getX() && getLocation().getX() + getSize().getWidth() < (e.getLocation().getX() + e.getSize().getWidth()) && getLocation().getY() + getSize().getHeight() > e.getLocation().getY()
						&& getLocation().getY() + getSize().getHeight() < (e.getLocation().getY() + e.getSize().getHeight())) {
					DodgeBlawk.getDataManager().addCollision(new Collision(this, e));
					return true;
				} else if (getLocation().getX() > e.getLocation().getX() && getLocation().getX() < (e.getLocation().getX() + e.getSize().getWidth()) && getLocation().getY() + getSize().getHeight() > e.getLocation().getY()
						&& getLocation().getY() + getSize().getHeight() < (e.getLocation().getY() + e.getSize().getHeight())) {
					DodgeBlawk.getDataManager().addCollision(new Collision(this, e));
					return true;
				}
			}
		}
		return false;
	}

	//General checks for values
	public boolean equals(Entity e) {
		if (this.id == e.getId()) {
			return true;
		}
		return false;
	}
}