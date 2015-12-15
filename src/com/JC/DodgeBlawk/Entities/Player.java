package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;
import java.util.ArrayList;

import org.newdawn.slick.Image;

import com.JC.DodgeBlawk.Graphics.Images;
import com.JC.DodgeBlawk.Management.Direction;
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

public class Player extends LivingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321387990325836130L;
	private int texNum, increment;
	private float score, diff;
	private ArrayList<Power> power;

	public Player(Location l, int id, ArrayList<Power> power, int hp, Size s, float SMultiplier, Direction direction, int texNum, long lastShot, int increment, float score) {
		super(l, id, hp, s, SMultiplier, direction, lastShot);
		this.power = power;
		this.texNum = texNum;
		this.score = score;
		this.increment = increment;
		this.diff = 0.0f;
	}
	
	public Player(Location l, int id, ArrayList<Power> power, int hp, Size s, float SMultiplier, Direction direction, int texNum, long lastShot, int increment, float score, float diff) {
		super(l, id, hp, s, SMultiplier, direction, lastShot);
		this.power = power;
		this.texNum = texNum;
		this.score = score;
		this.increment = increment;
		this.diff = diff;
	}

	// Gets the Current Power List
	public ArrayList<Power> getPowerList() {
		return this.power;
	}

	// Adds a power to the Power List
	public void addPower(Power power) {
		this.power.add(power);
	}

	// Removes a power from the Power List
	public void removePower(Power power) {
		this.power.remove(power);
	}

	// Gets the Power
	public Power getPower(Power po1) {
		Power power1 = null;

		for (Power po : power) {
			if (po != null) {
				if (po == po1) {
					power1 = po;
				}
			}
		}
		return power1;
	}

	// Gets the Texture
	public Image getTexture() {
		Image tex = null;
		if (this.texNum == 0) {
			tex = Images.SquareBlawk;
		} else if (this.texNum == 1) {
			tex = Images.SquareBlawkDown;
		} else if (this.texNum == 2) {
			tex = Images.SquareBlawkLeft;
		} else if (this.texNum == 3) {
			tex = Images.SquareBlawkLeftDown;
		} else if (this.texNum == 4) {
			tex = Images.SquareBlawkLeftUp;
		} else if (this.texNum == 5) {
			tex = Images.SquareBlawkUp;
		}
		return tex;
	}

	// Gets the Texture Number
	public int getTexNum() {
		return this.texNum;
	}

	// Sets the texture by Ids
	public void setTexture(int texNum) {
		this.texNum = texNum;
	}

	// Gets the Increment
	public int getIncrement() {
		return this.increment;
	}

	// Sets the Increment
	public void setIncrement(int increment) {
		this.increment = increment;
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
	public float getDifficulty() {
		return this.diff;
	}
	
	//Gets the Difficulty as a string
	public String getDifficultyAsString(){
		String s = null;
		if(getDifficulty() == 15f){
			s = "hard";
		}else if(getDifficulty() == 10f){
			s = "normal";
		}else if(getDifficulty() == 5f){
			s = "easy";
		}
		return s;
	}
	
	//Sets the Difficulty
	public void setDifficulty(String diff){
		if(diff.equalsIgnoreCase("easy")){
			this.diff = 5f;
		}else if(diff.equalsIgnoreCase("normal")){
			this.diff = 10f;
		}else if(diff.equalsIgnoreCase("hard")){
			this.diff = 15f;
		}
	}

	// Gets all the player values as a string
	public String toString() {
		String blawk = "X: " + getLocation().getX() + ", Y: " + getLocation().getY() + ", Id: " + getId() + ", HP: " + getHP();
		return blawk;
	}
}