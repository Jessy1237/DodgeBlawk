package com.JC.DodgeBlawk.Management;

import com.JC.DodgeBlawk.Management.Power;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class PowerChecker {

	private Power p;
	private boolean removeable;
	private long currentTime;

	public PowerChecker(Power p, boolean removeable, long currentTime) {
		this.p = p;
		this.removeable = removeable;
		this.currentTime = currentTime;
	}

	//Gets the power
	public Power getPower(){
		return this.p;
	}
	
	//Checks to see if the Power is removeable
	public boolean isRemoveable(){
		return this.removeable;
	}
	
	//Gets the currentTime
	public long getCurrentTime(){
		return this.currentTime;
	}
}
