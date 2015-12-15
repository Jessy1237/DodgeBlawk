package com.JC.DodgeBlawk.Util;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import com.JC.DodgeBlawk.DodgeBlawk;
import com.JC.DodgeBlawk.Play;
import com.JC.DodgeBlawk.Graphics.Render;
import com.JC.DodgeBlawk.Management.Direction;


/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Input {

	@SuppressWarnings("static-access")
	public Input(Play play, GameContainer gc, StateBasedGame sbg) {

		// Gets in the input from the GameContainer through slick
		org.newdawn.slick.Input Keyboard = gc.getInput();

		DodgeBlawk.getDataManager().getPlayer(0).setSMultiplier(DodgeBlawk.SMultiplier);
		Render.HyperSpaceMode = false;
		
		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_LSHIFT)){
			DodgeBlawk.getDataManager().getPlayer(0).setSMultiplier(DodgeBlawk.SMultiplier * 2);
			DodgeBlawk.getDataManager().getPlayer(0).setHP(DodgeBlawk.getDataManager().getPlayer(0).getHP() - 0.08);
			Render.HyperSpaceMode = true;
		}
		
		
		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_ESCAPE)) {
			try {
				DodgeBlawk.getDataManager().saveArrayLists();
			} catch (IOException e) {
				e.printStackTrace();
			}
			DodgeBlawk.s.playSound("select");
			sbg.enterState(0);
		}

		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_W) || Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_UP)) {
			DodgeBlawk.player.getLocation().setY((float) DodgeBlawk.player.getLocation().getY() - DodgeBlawk.player.getSMultiplier() * play.deltaTime);
			DodgeBlawk.player.setDirection(new Direction("Up"));
			if (DodgeBlawk.player.getTexNum() == 2 || DodgeBlawk.player.getTexNum() == 3 || DodgeBlawk.player.getTexNum() == 4) {
				DodgeBlawk.player.setTexture(4);
			} else {
				DodgeBlawk.player.setTexture(5);
			}
		}
		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_A) || Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_LEFT)) {
			DodgeBlawk.player.getLocation().setX((float) DodgeBlawk.player.getLocation().getX() - DodgeBlawk.player.getSMultiplier() * play.deltaTime);
			DodgeBlawk.player.setDirection(new Direction("Left"));
			DodgeBlawk.player.setTexture(2);
		}
		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_S) || Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_DOWN)) {
			DodgeBlawk.player.getLocation().setY((float) DodgeBlawk.player.getLocation().getY() + DodgeBlawk.player.getSMultiplier() * play.deltaTime);
			DodgeBlawk.player.setDirection(new Direction("Down"));
			if (DodgeBlawk.player.getTexNum() == 2 || DodgeBlawk.player.getTexNum() == 4 || DodgeBlawk.player.getTexNum() == 3) {
				DodgeBlawk.player.setTexture(3);
			} else {
				DodgeBlawk.player.setTexture(1);
			}
		}
		if (Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_D) || Keyboard.isKeyDown(org.newdawn.slick.Input.KEY_RIGHT)) {
			DodgeBlawk.player.getLocation().setX((float) DodgeBlawk.player.getLocation().getX() + DodgeBlawk.player.getSMultiplier() * play.deltaTime);
			DodgeBlawk.player.setDirection(new Direction("Right"));
			DodgeBlawk.player.setTexture(0);
		}
		if (Keyboard.isKeyPressed(org.newdawn.slick.Input.KEY_F2) && DodgeBlawk.debug == true) {
			System.out.println("Regenerating walls...");
			DodgeBlawk.regen = true;
			Generation.genAsteroid((DodgeBlawk.i = DodgeBlawk.random.nextInt(LoadEntities.GenerationDensity) + 2) * 2);
		}
		if (Keyboard.isKeyPressed(org.newdawn.slick.Input.KEY_F3) && DodgeBlawk.debug == true) {
			System.out.println("Displaying Debug: " + !play.ShowInformation);
			play.ShowInformation = !play.ShowInformation;
		}
		if (Keyboard.isKeyPressed(org.newdawn.slick.Input.KEY_SPACE) || Keyboard.isKeyPressed(org.newdawn.slick.Input.KEY_ENTER)) {
			DodgeBlawk.s.playSound("shoot");
			DodgeBlawk.player.shoot();
		}
	}
}
