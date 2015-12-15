package com.JC.DodgeBlawk;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.JC.DodgeBlawk.Util.LoadEntities;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Load extends BasicGameState {

	private Image NewGame;
	private Image NewGameStatic;
	private Image NewGameHover;
	private Image LoadGame;
	private Image LoadGameStatic;
	private Image LoadGameHover;
	private Image DodgeBlawkBanner;
	private Image Background;
	private Image BackButton;
	private Image BackButtonHover;
	private Image BackButtonStatic;

	public Load(int state) {

	}

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		DodgeBlawkBanner = new Image("assets/images/DodgeBlawkBanner.png");
		Background = new Image("assets/images/MenuBackground.png");

		String dir = "assets/textures/";
		NewGame = new Image(dir + "ButtonNewGame.png");
		NewGameStatic = new Image(dir + "ButtonNewGame.png");
		NewGameHover = new Image(dir + "ButtonNewGameHover.png");

		LoadGame = new Image(dir + "ButtonLoadGame.png");
		LoadGameStatic = new Image(dir + "ButtonLoadGame.png");
		LoadGameHover = new Image(dir + "ButtonLoadGameHover.png");

		BackButton = new Image("assets/textures/Back.png");
		BackButtonStatic = new Image("assets/textures/Back.png");
		BackButtonHover = new Image("assets/textures/BackHover.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (DodgeBlawk.getDataManager().players.isEmpty()) {
			LoadGame = LoadGameHover;
		} else {
			LoadGame = LoadGameStatic;
		}
		
		int x = gc.getWidth() / 2 - (450 / 2);
		g.drawImage(Background, 0, 0);
		g.drawImage(DodgeBlawkBanner, gc.getWidth() / 2 - 300, 30);
		g.drawImage(NewGame, x, 180);
		g.drawImage(LoadGame, x, 240);
		g.drawImage(BackButton, x, 480);
	}

	@SuppressWarnings("static-access")
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		gc.setMouseGrabbed(false);
		Input input = gc.getInput();
		
		if (DodgeBlawk.getDataManager().players.isEmpty()) {
			LoadGame = LoadGameHover;
		} else {
			LoadGame = LoadGameStatic;
		}
		
		int x = gc.getWidth() / 2 - (450 / 2);
		int MouseX = Mouse.getX(), MouseY = gc.getHeight() - Mouse.getY();
		if (Menu.wait) {
			if (Mouse.isButtonDown(0)) {

			} else {
				Menu.wait = false;
			}
		} else if (MouseX > x && MouseX < x + 450 && MouseY > 180 && MouseY < 230) {
			NewGame = NewGameHover;
			BackButton = BackButtonStatic;
			if (DodgeBlawk.getDataManager().players.isEmpty()) {
				LoadGame = LoadGameHover;
			} else {
				LoadGame = LoadGameStatic;
			}
			if (Mouse.isButtonDown(0)) {

				try {
					DodgeBlawk.getDataManager().clearArrayLists();
					DodgeBlawk.getDataManager().saveArrayLists();
					DodgeBlawk.getDataManager().loadArrayLists();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				Menu.wait = true;
				sbg.enterState(3);
				DodgeBlawk.s.playSound("select");

			}
		} else if (MouseX > x && MouseX < x + 450 && MouseY > 240 && MouseY < 290) {
			BackButton = BackButtonHover;
			BackButton = BackButtonStatic;
			NewGame = NewGameStatic;
			if (Mouse.isButtonDown(0)) {
				try {
					DodgeBlawk.getDataManager().loadArrayLists();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if (!DodgeBlawk.getDataManager().players.isEmpty()) {
					new LoadEntities();
					sbg.enterState(1);
				} else {
					LoadGame = LoadGameHover;
					Menu.wait = true;
					DodgeBlawk.s.playSound("badpowerup");
				}
			}
		} else if ((Mouse.getX() > gc.getWidth() / 2 - (450 / 2) && Mouse.getX() < gc.getWidth() / 2 + (450 / 2) && Mouse.getY() > 40 && Mouse.getY() < 90) || input.isButton1Pressed(Input.KEY_ESCAPE)) {
			BackButton = BackButtonHover;
			if (DodgeBlawk.getDataManager().players.isEmpty()) {
				LoadGame = LoadGameHover;
			} else {
				LoadGame = LoadGameStatic;
			}
			NewGame = NewGameStatic;
			if (Mouse.isButtonDown(0)) {
				DodgeBlawk.s.playSound("select");
				sbg.enterState(0);
			}
		} else {
			if (DodgeBlawk.getDataManager().players.isEmpty()) {
				LoadGame = LoadGameHover;
			} else {
				LoadGame = LoadGameStatic;
			}
			BackButton = BackButtonStatic;
			NewGame = NewGameStatic;
		}
	}

	public int getID() {
		return 4;
	}

}
