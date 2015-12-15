package com.JC.DodgeBlawk.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Entities.Player;
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

public class LoadEntities {

	public static int GenerationDensity = 20;

	public LoadEntities() {
		if ((new File(DodgeBlawk.getDataManager().userHome + "/DodgeBlawk/Save").exists()) && (new File(DodgeBlawk.getDataManager().userHome + "/DodgeBlawk/Save/Blawks.db").exists()) && (new File(DodgeBlawk.getDataManager().userHome + "/DodgeBlawk/Save/Players.db").exists())
				&& (new File(DodgeBlawk.getDataManager().userHome + "/DodgeBlawk/Save/Bullets.db").exists()) && (new File(DodgeBlawk.getDataManager().userHome + "/DodgeBlawk/Save/PowerUps.db").exists())) {
			try {
				DodgeBlawk.getDataManager().loadArrayLists();
				if (DodgeBlawk.getDataManager().players.isEmpty()) {
					DodgeBlawk.player = new Player(new Location((100 / 2) - 32, (100 / 2) - 32), 0, new ArrayList<Power>(), 200, new Size(32, 32), DodgeBlawk.SMultiplier, new Direction("none"), 0, System.currentTimeMillis(), 0, 0);
					DodgeBlawk.getDataManager().addPlayer(DodgeBlawk.player);
					DodgeBlawk.player.setIncrement(DodgeBlawk.player.getIncrement() + 1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			int GenerationValue = 0;
			DodgeBlawk.player = new Player(new Location((100 / 2) - 32, (100 / 2) - 32), 0, new ArrayList<Power>(), 200, new Size(32, 32), DodgeBlawk.SMultiplier, new Direction("none"), 0, System.currentTimeMillis(), 0, 0);
			GenerationValue = (DodgeBlawk.i = DodgeBlawk.random.nextInt(GenerationDensity) + 20);
			Generation.genAsteroid(GenerationValue);
			DodgeBlawk.getDataManager().addPlayer(DodgeBlawk.player);
			DodgeBlawk.player.setIncrement(DodgeBlawk.player.getIncrement() + 1);

		}
	}
}
