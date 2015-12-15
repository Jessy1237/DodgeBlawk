package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;

import org.newdawn.slick.Image;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Graphics.Images;
import com.JC.DodgeBlawk.Management.Collision;
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

public class Bullet extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8691332729067819043L;
	private Direction direction;
	private float SMultiplier;
	private LivingEntity owner;
	private int texNum;

	public Bullet(Location l, int id, Size s, Direction direction, float SMultiplier, LivingEntity owner, int texNum) {
		super(l, id, s);
		this.direction = direction;
		this.SMultiplier = SMultiplier;
		this.owner = owner;
		this.texNum = texNum;
	}

	//Gets the Direction
	public Direction getDirection() {
		return this.direction;
	}

	//Gets the Speed Multiplier
	public float getSMultiplier() {
		return this.SMultiplier;
	}

	//Sets the Direction
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	//Sets the Speed Multiplier
	public void setSMultiplier(int SMultiplier) {
		this.SMultiplier = SMultiplier;
	}

	//Gets the owner of this Entity
	public LivingEntity getOwner() {
		return this.owner;
	}

	//Gest the Texture (Image) by Texture Id
	public Image getTexture() {
		Image tex = null;
		if (this.texNum == 0) {
			tex = Images.Bullet;
		} else if (this.texNum == 1) {
			tex = Images.BulletLeft;
		} else if (this.texNum == 2) {
			tex = Images.BulletDown;
		} else if (this.texNum == 3) {
			tex = Images.BulletUp;
		}
		return tex;
	}
	
	//Checks to see if the entity has collided with any other entity
		public boolean isCollided() {
			for (Entity e : DodgeBlawk.getDataManager().entities) {
				if (e != null && !DodgeBlawk.getDataManager().isCollided(e)) {
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
}
