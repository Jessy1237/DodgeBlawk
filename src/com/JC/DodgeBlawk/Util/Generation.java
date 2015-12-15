package com.JC.DodgeBlawk.Util;

import java.io.IOException;
import java.util.Random;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Entities.Entity;
import com.JC.DodgeBlawk.Entities.Asteroid;
import com.JC.DodgeBlawk.Entities.PowerUp;
import com.JC.DodgeBlawk.Management.Collision;
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

public class Generation {

	public static boolean generate = true;

	@SuppressWarnings("static-access")
	public static void genAsteroid(int num) {
		if (generate) {
			if (DodgeBlawk.regen == true) {

				LoadEntities.GenerationDensity *= 2;
				
				// Cleans the entities ArrayList of the old Blawks
				for (Asteroid b : DodgeBlawk.getDataManager().asteroids) {
					DodgeBlawk.getDataManager().removeEntity(b);
				}

				// Clears the blawks ArrayList of the old Blawks
				DodgeBlawk.getDataManager().asteroids.clear();
			}

			double increment = 1 + (DodgeBlawk.player.getIncrement() / (10 - (DodgeBlawk.player.getDifficulty() - 10)));

			for (int i = 0; i < num; i++) {

				// Algorithm for generating location
				float x = DodgeBlawk.random.nextInt(DodgeBlawk.width - 32) + DodgeBlawk.width, y = DodgeBlawk.random
						.nextInt((DodgeBlawk.height - 32) - 65);

				// Creates new Aesteroid
				Asteroid asteroid = new Asteroid(new Location(x, y), DodgeBlawk.getDataManager().entities.size(), new Size(32, 32),
						(float) (0.15f * increment));
				DodgeBlawk.getDataManager().addAsteroid(asteroid);

			}
			DodgeBlawk.s.playSound("newround");
			try {
				DodgeBlawk.getDataManager().saveArrayLists();
				DodgeBlawk.getDataManager().loadArrayLists();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			for (Entity e : DodgeBlawk.getDataManager().entities) {
				if (e != null) {
					if (e instanceof Asteroid) {
						e.isCollided();
					}
				}
			}

			for (Collision c : DodgeBlawk.getDataManager().collisions) {
				if (c != null) {
					if (c.getCollider() instanceof Asteroid) {
						DodgeBlawk.getDataManager().removeAsteroid((Asteroid) c.getCollider());
					}
				}
			}
		}
	}

	public static void generatePowerUp(Location l) {
		Random random = new Random();
		int dropPowerUp = random.nextInt((int) (10 + (DodgeBlawk.player.getDifficulty() - 10)));
		if (dropPowerUp == 1) {
			int powerUpType = random.nextInt(50);
			PowerUp pu = null;
			if (powerUpType >= 0 && powerUpType < 25) {
				pu = new PowerUp(l, DodgeBlawk.getDataManager().entities.size(), new Size(32, 32), new Power(1, 8, 1, 0, 0), 1, 10, System.currentTimeMillis());
			} else if (powerUpType >= 25 && powerUpType < 35) {
				pu = new PowerUp(l, DodgeBlawk.getDataManager().entities.size(), new Size(32, 32), new Power(2, 3, 1, 0, 0), 2, 10, System.currentTimeMillis());
			} else if (powerUpType >= 35 && powerUpType <= 50) {
				pu = new PowerUp(l, DodgeBlawk.getDataManager().entities.size(), new Size(32, 32), new Power(3, 0, 0, 0, 0), 3, 10, System.currentTimeMillis());
			}
			DodgeBlawk.getDataManager().addPowerUp(pu);
		}
	}
}
