package com.JC.DodgeBlawk;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.JC.DodgeBlawk.Audio.Sound;
import com.JC.DodgeBlawk.Audio.SoundManager;
import com.JC.DodgeBlawk.Entities.Player;
import com.JC.DodgeBlawk.Graphics.IconLoader;
import com.JC.DodgeBlawk.Util.Console;
import com.JC.DodgeBlawk.Util.DataManager;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class DodgeBlawk extends StateBasedGame {

	public static boolean debug = false;
	public static Player player;
	public static Console c = new Console();
	public static boolean regen = false;
	public static int width = 1000, height = 550;
	public static float SMultiplier = 0.35f;
	private static DataManager datamanager = new DataManager();
	public static Random random = new Random();
	public static int i;
	public static long shotLimit = 250;
	public static String gamename = "DodgeBlawk ";
	public static final int menu = 0;
	public static final int Game = 1;
	public static final int help = 2;
	public static final int difficulty = 3;
	public static final int load = 4;
	public static int mainversion = 2, subversion = 0;
	public static String version = "v" + mainversion + "." + subversion;
	public static String userHome = System.getProperty("user.home");

	public static final int[] states = { 0, 1, 2, 3, 4 };

	public static SoundManager s = new SoundManager() {

		public void initSounds() {
			sounds.add(new Sound("explosion", Sound.getURL("explosion.wav")));
			sounds.add(new Sound("badpowerup", Sound.getURL("badpowerup.wav")));
			sounds.add(new Sound("select", Sound.getURL("Select.wav")));
			sounds.add(new Sound("newround", Sound.getURL("NewRound.wav")));
			sounds.add(new Sound("powerup", Sound.getURL("powerup.wav")));
			sounds.add(new Sound("shoot", Sound.getURL("shoot.wav")));
			sounds.add(new Sound("hurt", Sound.getURL("hurt.wav")));
		}
	};

	public static void main(String[] args) {
		/*
		 * System.setProperty("org.lwjgl.librarypath", getWorkDir() +
		 * "natives");
		 */

		gamename = gamename + version;
		if (debug == true)
			gamename = gamename + ", DEBUG";

		AppGameContainer appgc;
		try {

			appgc = new AppGameContainer(new DodgeBlawk(gamename));
			appgc.setDisplayMode(width, height, false);
			appgc.setSmoothDeltas(true);
			appgc.setShowFPS(true);
			appgc.setMouseGrabbed(true);
			appgc.setTargetFrameRate(60);
			Display.setIcon(IconLoader.loadIcon("assets/images/blawk.png"));
			appgc.start();

			width = Display.getWidth();
			height = Display.getHeight();

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static void initSounds() {
		SoundManager.sounds.add(new Sound("music", Sound.getURL("res/sound/Click.wav")));
	}

	public DodgeBlawk(String gamename) {
		super(gamename);

		this.addState(new Menu(states[0]));
		this.addState(new Play(states[1]));
		this.addState(new Help(states[2]));
		this.addState(new Difficulty(states[3]));
		this.addState(new Load(states[4]));
	}

	public static DataManager getDataManager() {
		return datamanager;
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(Game).init(gc, this);
		this.getState(help).init(gc, this);
		this.getState(difficulty).init(gc, this);
		this.getState(load).init(gc,  this);
		this.enterState(menu);
	}

	public static String getWorkDir() {
		String osName = System.getProperty("os.name").toLowerCase();
		String dir = null;
		if (osName.contains("win")) {
			dir = userHome + "/DodgeBlawk/";
		} else if (osName.contains("mac")) {
			dir = userHome + "/DodgeBlawk/";
		}
		return dir;
	}
}