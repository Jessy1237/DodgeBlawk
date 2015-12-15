package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;

import com.JC.DodgeBlawk.Management.Direction;
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

public class Blawk extends LivingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8211186053217746945L;

	public Blawk(int id, Location l, int HP, Size s, int SMultiplier, Direction direction, long lastShot) {
		super(l, id, HP, s, SMultiplier, direction, lastShot);
	}
}
