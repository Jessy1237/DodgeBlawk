package com.JC.DodgeBlawk;

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

public class Difficulty extends BasicGameState {

	Image DodgeBlawkBanner;
	Image Background;
	Image BackButton;
	Image BackButtonHover;
	Image BackButtonStatic;
	Image ButtonEasy;
	Image ButtonEasyStatic;
	Image ButtonEasyHover;
	Image ButtonNormal;
	Image ButtonNormalStatic;
	Image ButtonNormalHover;
	Image ButtonHard;
	Image ButtonHardStatic;
	Image ButtonHardHover;

	public Difficulty(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		DodgeBlawkBanner = new Image("assets/images/DodgeBlawkBanner.png");
		Background = new Image("assets/images/MenuBackground.png");
		BackButton = new Image("assets/textures/Back.png");
		BackButtonStatic = new Image("assets/textures/Back.png");
		BackButtonHover = new Image("assets/textures/BackHover.png");
		ButtonEasy = new Image("assets/textures/ButtonEasy.png");
		ButtonEasyStatic = new Image("assets/textures/ButtonEasy.png");
		ButtonEasyHover = new Image("assets/textures/ButtonEasyHover.png");
		ButtonNormal = new Image("assets/textures/ButtonNormal.png");
		ButtonNormalStatic = new Image("assets/textures/ButtonNormal.png");
		ButtonNormalHover = new Image("assets/textures/ButtonNormalHover.png");
		ButtonHard = new Image("assets/textures/ButtonHard.png");
		ButtonHardStatic = new Image("assets/textures/ButtonHard.png");
		ButtonHardHover = new Image("assets/textures/ButtonHardHover.png");
	}

	@SuppressWarnings("static-access")
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		gc.setMouseGrabbed(false);
		int MouseX = Mouse.getX(), MouseY = gc.getHeight() - Mouse.getY();
		if (Menu.wait) {
			if (Mouse.isButtonDown(0)) {

			} else {
				Menu.wait = false;
			}
		} else if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 180 && MouseY < 230)) {
			ButtonEasy = ButtonEasyHover;
			if (Mouse.isButtonDown(0)) {
				new LoadEntities();
				DodgeBlawk.player.setDifficulty("easy");
				DodgeBlawk.s.playSound("select");
				sbg.enterState(1);
			}
			BackButton = BackButtonStatic;
			ButtonNormal = ButtonNormalStatic;
			ButtonHard = ButtonHardStatic;

		} else if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 240 && MouseY < 290)) {
			ButtonNormal = ButtonNormalHover;
			if (Mouse.isButtonDown(0)) {
				new LoadEntities();
				DodgeBlawk.player.setDifficulty("normal");
				DodgeBlawk.s.playSound("select");
				sbg.enterState(1);
			}
			BackButton = BackButtonStatic;
			ButtonEasy = ButtonEasyStatic;
			ButtonHard = ButtonHardStatic;
		} else if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 300 && MouseY < 350)) {
			ButtonHard = ButtonHardHover;
			if (Mouse.isButtonDown(0)) {
				new LoadEntities();
				DodgeBlawk.player.setDifficulty("hard");
				DodgeBlawk.s.playSound("select");
				sbg.enterState(1);
			}
			BackButton = BackButtonStatic;
			ButtonEasy = ButtonEasyStatic;
			ButtonNormal = ButtonNormalStatic;
		} else if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			DodgeBlawk.s.playSound("select");
			sbg.enterState(0);
		} else if (Mouse.getX() > gc.getWidth() / 2 - (450 / 2) && Mouse.getX() < gc.getWidth() / 2 + (450 / 2) && Mouse.getY() > 40 && Mouse.getY() < 90) {
			BackButton = BackButtonHover;
			if (Mouse.isButtonDown(0)) {
				DodgeBlawk.s.playSound("select");
				sbg.enterState(0);
			}
			ButtonEasy = ButtonEasyStatic;
			ButtonNormal = ButtonNormalStatic;
			ButtonHard = ButtonHardStatic;
		} else {
			BackButton = BackButtonStatic;
			ButtonEasy = ButtonEasyStatic;
			ButtonNormal = ButtonNormalStatic;
			ButtonHard = ButtonHardStatic;
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(Background, 0, 0);
		g.drawImage(DodgeBlawkBanner, gc.getWidth() / 2 - 300, 30);
		g.drawImage(ButtonEasy, gc.getWidth() / 2 - (450 / 2), 180);
		g.drawImage(ButtonNormal, gc.getWidth() / 2 - (450 / 2), 240);
		g.drawImage(ButtonHard, gc.getWidth() / 2 - (450 / 2), 300);
		g.drawImage(BackButton, gc.getWidth() / 2 - (450 / 2), 480);
	}

	public int getID() {
		return 3;
	}
}