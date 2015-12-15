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

public class Power implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 67046761679413440L;
	private int p, length, time, ticks;
	private long lastTime;
	
	public Power(int p, int length, int time, long lastTime, int ticks){
		this.p = p;
		this.length = length;
		this.time = time;
		this.ticks = ticks;
	}
	
	//gets the Power's Name.
	public String getName(){
		String power = null;
		if (p == 1) {
			power = "Regen Health";
		} else if (p == 2) {
			power = "Degen Health";
		} else if (p == 3){
			power = "Instant Health";
		} else if (p == 0) {
			power = "None";
		}

		return power;
	}
	
	//gets the power id
	public int getTypeId(){
		return this.p;
	}
	
	//Sets the power
	public void setTypeId(){
		
	}
	
	//Gets the length of time the power lasts
	public int getLength(){
		return this.length;
	}
	
	//Gets the interval of time that the power activates
	public int getTime(){
		return this.time;
	}
	
	//Gets the last time the power was activated in milliseconds
	public long getLastTime(){
		return this.lastTime;
	}
	
	//Sets the last time the power was activated in milliseconds
	public void setLastTime(long lastTime){
		this.lastTime = lastTime;
	}
	
	//Gets the amount of ticks
	public int getTicks(){
		return this.ticks;
	}
	
	//Sets the amount of ticks
	public void setTicks(int ticks){
		this.ticks = ticks;
	}
}
