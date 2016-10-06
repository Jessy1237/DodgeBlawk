package com.JC.DodgeBlawk.Entities;

import java.io.Serializable;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Management.Collision;
import com.JC.DodgeBlawk.Management.Direction;
import com.JC.DodgeBlawk.Management.Location;
import com.JC.DodgeBlawk.Management.Size;
import com.JC.DodgeBlawk.Util.Generation;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class LivingEntity extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8491506216720556156L;
	private double HP;
	private long lastShot;
	private float SMultiplier;
	private Direction direction;

	public LivingEntity(Location l, int id, int hp, Size s, float SMultiplier, Direction direction, long lastShot) {
		super(l, id, s);
		this.HP = hp;
		this.SMultiplier = SMultiplier;
		this.direction = direction;
	}

	// Gets the HP
	public double getHP() {
		return this.HP;
	}

	// Sets the HP
	public void setHP(double d) {
		this.HP = d;
	}

	// Gets the Speed Multiplier
	public float getSMultiplier() {
		return this.SMultiplier;
	}

	// Sets the Speed Multiplier
	public void setSMultiplier(float SMultiplier) {
		this.SMultiplier = SMultiplier;
	}

	// Gets the Direction
	public Direction getDirection() {
		return this.direction;
	}

	// Sets the Direction
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	// Gets the time of the Last Bullet Shot
	public long getLastShot() {
		return this.lastShot;
	}

	// Sets the time of the last bullet shot
	public void setLastShot(long lastShot) {
		this.lastShot = lastShot;
	}

	// Shoots a new bullet if enough time has been waited
	public void shoot() {
		long currentTime = System.currentTimeMillis();
		if ((currentTime - getLastShot()) < DodgeBlawk.shotLimit) {
			return;
		} else {
			setLastShot(currentTime);
			int negateValue = 4;
			if (DodgeBlawk.player.getTexNum() == 2 || DodgeBlawk.player.getTexNum() == 3 || DodgeBlawk.player.getTexNum() == 4) {
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX() - 10, (int) (getLocation().getY() + (getSize().getHeight() / 2))), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Left"), 1f, this, 1));
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX(), (int) (getLocation().getY())), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Left"), 1f, this, 1));
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX(), (int) (getLocation().getY() + (getSize().getHeight()))), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Left"), 1f, this, 1));
				DodgeBlawk.player.setHP(DodgeBlawk.player.getHP() - negateValue);
			} else if (DodgeBlawk.player.getTexNum() == 0 || DodgeBlawk.player.getTexNum() == 1 || DodgeBlawk.player.getTexNum() == 5) {
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX() + getSize().getWidth() + 10, (int) (getLocation().getY() + (getSize().getHeight() / 2))), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Right"), 1f, this, 0));
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX() + getSize().getWidth(), (int) (getLocation().getY())), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Right"), 1f, this, 0));
				DodgeBlawk.getDataManager().addBullet(new Bullet(new Location(getLocation().getX() + getSize().getWidth(), (int) (getLocation().getY() + (getSize().getHeight()))), DodgeBlawk.getDataManager().getLastID(), (new Size(18, 7)), new Direction("Right"), 1f, this, 0));
				if (Generation.generate){
				DodgeBlawk.player.setHP(DodgeBlawk.player.getHP() - negateValue);
				} 
			}
			if(DodgeBlawk.player.getHP() < 0 || DodgeBlawk.player.getHP() == 0){
				DodgeBlawk.getDataManager().addCollision(new Collision(DodgeBlawk.player,null));
			}
		}
	}

	public Entity getEntity() {
		return DodgeBlawk.getDataManager().getEntity(getId());
	}
}
