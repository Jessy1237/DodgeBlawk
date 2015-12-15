package com.JC.DodgeBlawk.Util;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Animations {

	public static Animation engineSmoke;
	public static Animation Asteroid;
	public static Animation power3anim;
	public static Animation power2anim;
	public static Animation power1anim;
	public int[] duration3 = { 150, 150, 150 };
	public int[] powertimer = { 500, 500};
	public int WallDur = 150;

	public Animations() {
		try {
			Image[] power3animArray = {new Image("assets/textures/power3.png"), new Image("assets/textures/smallpowerup3.png") };
			Image[] power2animArray = {new Image("assets/textures/power2.png"), new Image("assets/textures/smallpowerup2.png") };
			Image[] power1animArray = {new Image("assets/textures/power1.png"), new Image("assets/textures/smallpowerup1.png") };
			Image[] engineSmokeArray = { new Image("assets/textures/engineSmoke1.png"), new Image("assets/textures/engineSmoke2.png"), new Image("assets/textures/engineSmoke3.png") };
			Image[] Wall = {new Image("assets/textures/Wall1.png") };

			power3anim = new Animation(power3animArray, powertimer, true);
			power2anim = new Animation(power2animArray, powertimer, true);
			power1anim = new Animation(power1animArray, powertimer, true);
			engineSmoke = new Animation(engineSmokeArray, duration3, true);
			Asteroid = new Animation(Wall, WallDur, true);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}