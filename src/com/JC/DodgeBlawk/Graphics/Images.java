package com.JC.DodgeBlawk.Graphics;

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

public class Images {

	public static Image AccessBar;
	public static Image Wall;
	public static Image SquareBlawk;
	public static Image SquareBlawkDown;
	public static Image SquareBlawkLeft;
	public static Image SquareBlawkLeftDown;
	public static Image SquareBlawkLeftUp;
	public static Image SquareBlawkUp;
	public static Image Bullet;
	public static Image BulletUp;
	public static Image sound;
	public static Image BulletDown;
	public static Image BulletLeft;
	public static Image Blank;
	public static Image Background;
	public static Image PowerUp1;
	public static Image PowerUp2;
	public static Image PowerUp3;
	public Images() {
		try {
			AccessBar = new Image("assets/textures/AccessBar.png");
			Wall = new Image("assets/textures/Wall.png");
			SquareBlawk = new Image("assets/textures/SquareBlawk.png");
			SquareBlawkDown = new Image("assets/textures/SquareBlawkDown.png");
			SquareBlawkLeft = new Image("assets/textures/SquareBlawkLeft.png");
			SquareBlawkLeftDown = new Image("assets/textures/SquareBlawkLeftDown.png");
			SquareBlawkLeftUp = new Image("assets/textures/SquareBlawkLeftUp.png");
			SquareBlawkUp = new Image("assets/textures/SquareBlawkUp.png");
			Bullet = new Image("assets/textures/BulletRight.png");
			BulletLeft = new Image("assets/textures/BulletLeft.png");
			BulletUp = new Image("assets/textures/BulletUp.png");
			BulletDown = new Image("assets/textures/BulletDown.png");
			Blank = new Image("assets/textures/Blank.png");
			Background = new Image("assets/images/Background.png");
			PowerUp1 = new Image("assets/textures/power1.png");
			PowerUp2 = new Image("assets/textures/power2.png");
			PowerUp3 = new Image("assets/textures/power3.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
