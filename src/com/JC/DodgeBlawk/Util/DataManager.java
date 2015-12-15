package com.JC.DodgeBlawk.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Entities.Blawk;
import com.JC.DodgeBlawk.Entities.Bullet;
import com.JC.DodgeBlawk.Entities.Asteroid;
import com.JC.DodgeBlawk.Entities.Entity;
import com.JC.DodgeBlawk.Entities.Player;
import com.JC.DodgeBlawk.Entities.PowerUp;
import com.JC.DodgeBlawk.Management.Collision;
import com.JC.DodgeBlawk.Management.PowerChecker;
import com.JC.DodgeBlawk.Management.Score;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class DataManager {

	public ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public ArrayList<Blawk> blawks = new ArrayList<Blawk>();
	public ArrayList<Collision> collisions = new ArrayList<Collision>();
	public ArrayList<PowerChecker> powerchecker = new ArrayList<PowerChecker>();
	public ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	public ArrayList<Score> highscore = new ArrayList<Score>();

	public String userHome = System.getProperty("user.home");

	public void addPlayer(Player player) {
		players.add(players.size(), player);
		addEntity((Entity) player);
	}

	public void addAsteroid(Asteroid asteroid) {
		asteroids.add(asteroids.size(), asteroid);
		addEntity((Entity) asteroid);
	}

	public void addEntity(Entity entity) {
		entities.add(entities.size(), entity);
	}

	public void addBullet(Bullet bullet) {
		bullets.add(bullets.size(), bullet);
		addEntity((Entity) bullet);
	}

	public void addBlawk(Blawk blawk) {
		blawks.add(blawks.size(), blawk);
		addEntity((Entity) blawk);
	}

	public void addCollision(Collision collision) {
		collisions.add(collisions.size(), collision);
	}

	public void addPowerChecker(PowerChecker pc) {
		powerchecker.add(powerchecker.size(), pc);
	}

	public void addPowerUp(PowerUp powerup) {
		powerups.add(powerups.size(), powerup);
		addEntity((Entity) powerup);
	}

	public void addHighScore(Score hs) {
		highscore.add(hs);
	}

	public void replaceHighScore(Score hs) {
		Score sc = null;
		for (Score s : highscore) {
			if (s != null) {
				if (s.getDifficulty().equalsIgnoreCase(hs.getDifficulty())) {
					sc = s;
				}
			}
		}

		highscore.remove(sc);
		highscore.add(hs);
	}

	public void removePlayer(Player player) {
		players.remove(player);
		removeEntity((Entity) player);
	}

	public void removeAsteroid(Asteroid asteroid) {
		asteroids.remove(asteroid);
		removeEntity((Entity) asteroid);
	}

	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}

	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		removeEntity((Entity) bullet);
	}

	public void removeBlawk(Blawk blawk) {
		blawks.remove(blawk);
		removeEntity(blawk);
	}

	public void removeCollision(Entity entity) {
		collisions.remove(entity);
	}

	public void removePowerUp(PowerUp powerup) {
		powerups.remove(powerup);
		removeEntity((Entity) powerup);
	}

	public Player getPlayer(float id) {
		Player player = null;

		for (Player p : players) {
			if (p != null) {
				if (p.getId() == id) {
					return p;
				}
			}
		}
		return player;
	}

	public Asteroid getAsteroid(float id) {
		Asteroid asteroid = null;

		for (Asteroid bl : asteroids) {
			if (bl != null) {
				if (bl.getId() == id) {
					return bl;
				}
			}
		}
		return asteroid;
	}

	public Entity getEntity(float id) {
		Entity entity = null;

		for (Entity en : entities) {
			if (en != null) {
				if (en.getId() == id) {
					return en;
				}
			}
		}
		return entity;
	}

	public Bullet getBullet(float id) {
		Bullet bullet = null;

		for (Bullet bu : bullets) {
			if (bu != null) {
				if (bu.getId() == id) {
					return bu;
				}
			}
		}
		return bullet;
	}

	public Blawk getBlawk(float id) {
		Blawk blawk = null;

		for (Blawk bl : blawks) {
			if (bl != null) {
				if (bl.getId() == id) {
					return bl;
				}
			}
		}
		return blawk;
	}

	public PowerUp getPowerUp(float id) {
		PowerUp powerup = null;

		for (PowerUp pu : powerups) {
			if (pu != null) {
				if (pu.getId() == id) {
					return pu;
				}
			}
		}
		return powerup;
	}

	public Score getHighScore(String diff) {
		Score sc = null;

		for (Score s : highscore) {
			if (s != null) {
				if (s.getDifficulty().equalsIgnoreCase(diff)) {
					sc = s;
				}
			}
		}
		return sc;
	}
	
	public boolean isCollided(Entity e){
		
		for(Collision c : collisions){
			if(c != null){
				if(e == c.getVictim() || e == c.getCollider()){
					return true;
				}
			}
		}
		return false;
	}

	public void saveArrayLists() throws IOException {
		if (!(new File(userHome + "/DodgeBlawk").exists()))
			new File(userHome + "/DodgeBlawk").mkdir();

		if (!(new File(userHome + "/DodgeBlawk/Save").exists()))
			new File(userHome + "/DodgeBlawk/Save").mkdir();

		if (!(new File(userHome + "/DodgeBlawk/Save/Asteroids.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/Asteroids.db").createNewFile();

		if (!(new File(userHome + "/DodgeBlawk/Save/Players.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/Players.db").createNewFile();

		if (!(new File(userHome + "/DodgeBlawk/Save/Bullets.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/Bullets.db").createNewFile();

		if (!(new File(userHome + "/DodgeBlawk/Save/Blawks.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/Blawks.db").createNewFile();

		if (!(new File(userHome + "/DodgeBlawk/Save/PowerUps.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/PowerUps.db").createNewFile();

		if (!(new File(userHome + "/DodgeBlawk/Save/HighScore.db").exists()))
			new File(userHome + "/DodgeBlawk/Save/HighScore.db").createNewFile();

		FileOutputStream out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/Asteroids.db"));
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(asteroids.clone());
		oos.flush();
		oos.close();

		out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/Players.db"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(players.clone());
		oos.flush();
		oos.close();

		out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/Bullets.db"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(bullets.clone());
		oos.flush();
		oos.close();

		out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/Blawks.db"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(blawks.clone());
		oos.flush();
		oos.close();

		out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/PowerUps.db"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(powerups.clone());
		oos.flush();
		oos.close();

		out = new FileOutputStream(new File(userHome + "/DodgeBlawk/Save/HighScore.db"));
		oos = new ObjectOutputStream(out);
		oos.writeObject(highscore.clone());
		oos.flush();
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public void loadArrayLists() throws IOException, ClassNotFoundException {

		if (!(new File(userHome + "/DodgeBlawk").exists())) {
			new File(userHome + "/DodgeBlawk").mkdir();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save").exists())) {
			new File(userHome + "/DodgeBlawk/Save").mkdir();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/Asteroids.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/Asteroids.db").createNewFile();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/Players.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/Players.db").createNewFile();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/Bullets.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/Bullets.db").createNewFile();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/Blawks.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/Blawks.db").createNewFile();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/PowerUps.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/PowerUps.db").createNewFile();
			return;
		}

		if (!(new File(userHome + "/DodgeBlawk/Save/HighScore.db").exists())) {
			new File(userHome + "/DodgeBlawk/Save/HighScore.db").createNewFile();
			addHighScore(new Score("easy", 0));
			addHighScore(new Score("normal", 0));
			addHighScore(new Score("hard", 0));
			return;
		}

		entities.clear();
		asteroids.clear();
		players.clear();
		bullets.clear();
		powerups.clear();

		FileInputStream f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/Asteroids.db"));
		ObjectInputStream in = new ObjectInputStream(f);
		ArrayList<Asteroid> asteroid = (ArrayList<Asteroid>) in.readObject();
		for (Asteroid a : asteroid) {
			if (a != null) {
				addAsteroid(a);
			}
		}
		in.close();

		f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/Bullets.db"));
		in = new ObjectInputStream(f);
		ArrayList<Bullet> bullet = (ArrayList<Bullet>) in.readObject();
		for (Bullet b : bullet) {
			if (b != null) {
				addBullet(b);
			}
		}
		in.close();

		f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/Blawks.db"));
		in = new ObjectInputStream(f);
		ArrayList<Blawk> blawk = (ArrayList<Blawk>) in.readObject();
		for (Blawk bl : blawk) {
			if (bl != null) {
				addBlawk(bl);
			}
		}
		in.close();

		f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/HighScore.db"));
		in = new ObjectInputStream(f);
		ArrayList<Score> highscore = (ArrayList<Score>) in.readObject();
		for (Score hs : highscore) {
			if (hs != null) {
				if (this.highscore.isEmpty()) {
					addHighScore(hs);
				} else {
					replaceHighScore(hs);
				}
			}
		}

		f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/PowerUps.db"));
		in = new ObjectInputStream(f);
		ArrayList<PowerUp> pus = (ArrayList<PowerUp>) in.readObject();
		for (PowerUp pu : pus) {
			if (pu != null) {
				addPowerUp(pu);
			}
		}
		in.close();

		f = new FileInputStream(new File(userHome + "/DodgeBlawk/Save/Players.db"));
		in = new ObjectInputStream(f);
		ArrayList<Player> player = (ArrayList<Player>) in.readObject();
		for (Player p : player) {
			if (p != null) {
				addPlayer(p);
			}
		}
		in.close();

		for (Player p : players) {
			if (p != null) {
				DodgeBlawk.player = p;
			}
		}
	}

	//Clears all the ArrayLists except highscores
	public void clearArrayLists() {
		entities.clear();
		asteroids.clear();
		players.clear();
		bullets.clear();
		powerups.clear();
		collisions.clear();
		blawks.clear();
		powerchecker.clear();
	}
}
