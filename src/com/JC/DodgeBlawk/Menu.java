package com.JC.DodgeBlawk;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Menu extends BasicGameState {

	static Image DodgeBlawkBanner;
	Image ButtonPlay;
	Image ButtonExit;
	static Image Background;
	Image ButtonPlayHover;
	Image ButtonExitHover;
	Image ButtonPlayStatic;
	Image ButtonExitStatic;
	Image ButtonHelp;
	Image ButtonHelpHover;
	Image ButtonHelpStatic;
	static TrueTypeFont RenderFont;
	public static boolean wait = false;

	public Menu(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		DodgeBlawkBanner = new Image("assets/images/DodgeBlawkBanner.png");
		ButtonPlay = new Image("assets/textures/ButtonDodgeBlawk.png");
		ButtonExit = new Image("assets/textures/ButtonDodgeExit.png");
		ButtonHelp = new Image("assets/textures/ButtonHelp.png");
		ButtonHelpHover = new Image("assets/textures/ButtonHelpHover.png");
		ButtonPlayStatic = new Image("assets/textures/ButtonDodgeBlawk.png");
		ButtonExitStatic = new Image("assets/textures/ButtonDodgeExit.png");
		Background = new Image("assets/images/MenuBackground.png");
		ButtonPlayHover = new Image("assets/textures/ButtonDodgeBlawkHover.png");
		ButtonExitHover = new Image("assets/textures/ButtonDodgeExitHover.png");
		ButtonHelpStatic = new Image("assets/textures/ButtonHelp.png");
		InputStream inputStream = ResourceLoader.getResourceAsStream("assets/fonts/Font.TTF");
		try {
			Font rawRenderFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			rawRenderFont = rawRenderFont.deriveFont(30f);
			RenderFont = new TrueTypeFont(rawRenderFont, true);
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("static-access")
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		gc.setMouseGrabbed(false);
		int MouseX = Mouse.getX(), MouseY = gc.getHeight() - Mouse.getY();
		if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 180 && MouseY < 230)) {

			ButtonPlay = ButtonPlayHover;
			if (Mouse.isButtonDown(0)) {
				DodgeBlawk.s.playSound("select");
				Menu.wait = true;
				sbg.enterState(4);
			}
			ButtonExit = ButtonExitStatic;
			ButtonHelp = ButtonHelpStatic;
		} else if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 240 && MouseY < 290)) {

			ButtonHelp = ButtonHelpHover;
			if (Mouse.isButtonDown(0)) {
				DodgeBlawk.s.playSound("select");
				sbg.enterState(2);
			}
			ButtonPlay = ButtonPlayStatic;
			ButtonExit = ButtonExitStatic;
		}
		else if ((MouseX > gc.getWidth() / 2 - (450 / 2) && MouseX < gc.getWidth() / 2 - (450 / 2) + 450) && (MouseY > 300 && MouseY < 350)) {

			ButtonExit = ButtonExitHover;
			if (Mouse.isButtonDown(0)) {
				DodgeBlawk.s.playSound("select");
				Display.destroy();
				AL.destroy();
				System.exit(0);
			}
			ButtonPlay = ButtonPlayStatic;
			ButtonHelp = ButtonHelpStatic;
		} else {
			ButtonPlay = ButtonPlayStatic;
			ButtonExit = ButtonExitStatic;
			ButtonHelp = ButtonHelpStatic;
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(Background, 0, 0);
		g.drawImage(DodgeBlawkBanner, gc.getWidth() / 2 - 300, 30);
		RenderFont.drawString(10, 515, "DodgeBlawk " + DodgeBlawk.version + ", Developed by Wyndcrest.", Color.green);
		g.drawImage(ButtonPlay, gc.getWidth() / 2 - (450 / 2), 180);
		g.drawImage(ButtonHelp, gc.getWidth() / 2 - (450 / 2), 240);
		g.drawImage(ButtonExit, gc.getWidth() / 2 - (450 / 2), 300);
	}

	public int getID() {
		return 0;
	}
}