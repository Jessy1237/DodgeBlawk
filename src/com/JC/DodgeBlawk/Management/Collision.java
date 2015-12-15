package com.JC.DodgeBlawk.Management;

import java.io.Serializable;

import com.JC.DodgeBlawk.Entities.Entity;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Collision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6293445001414549982L;
	private Entity collider, victim;

	public Collision(Entity collider, Entity victim) {
		this.collider = collider;
		this.victim = victim;
	}

	//Gets the Entity that caused the Collision
	public Entity getCollider() {
		return this.collider;
	}

	//Gets the Entity that was the victim of the Collision
	public Entity getVictim() {
		return this.victim;
	}
}
