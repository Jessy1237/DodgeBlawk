package com.JC.DodgeBlawk;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
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

public class Help extends BasicGameState {
	
	static TrueTypeFont RenderFont;
	static Image BackButton;
	static Image BackButtonHover;
	static Image BackButtonStatic;
	
	public Help(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		BackButton = new Image("assets/textures/Back.png");
		BackButtonStatic = BackButton;
		BackButtonHover = new Image("assets/textures/BackHover.png");
		
		InputStream inputStream = ResourceLoader.getResourceAsStream("assets/fonts/Font.TTF");
		try {
			Font rawRenderFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			rawRenderFont = rawRenderFont.deriveFont(18f);
			RenderFont = new TrueTypeFont(rawRenderFont, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || Mouse.isButtonDown(4)){
			DodgeBlawk.s.playSound("select");
			sbg.enterState(0);
		}
		if (Mouse.getX() > gc.getWidth() / 2 - (450 / 2) && Mouse.getX() < gc.getWidth() / 2 + (450 / 2) && Mouse.getY() > 40 && Mouse.getY() < 90){
			BackButton = BackButtonHover;
			if (Mouse.isButtonDown(0)){
				DodgeBlawk.s.playSound("select");
				sbg.enterState(0);
			}
		}
		else {
			BackButton = BackButtonStatic;
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setFont(RenderFont);
		g.drawImage(Menu.Background,0,0);
		g.drawImage(Menu.DodgeBlawkBanner, gc.getWidth() / 2 - 300, 30);
		g.setColor(Color.green);
		g.drawString("Controls:", 10, 175);
		g.drawString("- Movement: W,A,S,D or Arrow keys", 10, 195);
		g.drawString("- Fire/Shoot: Spacebar or Enter", 10, 220);
		g.drawString("- General back button: ESCAPE", 10, 245);
		g.drawString("How to play:", 10, 275);
		g.drawString("- Each time you shoot you loose 4HP", 10, 295);
		g.drawString("- The more asteroids on screen when you kill one, the more points earned.", 10, 315);
		g.drawString("- Formula for points: (amount of asteroids / 3 x 0.75 + 1)", 10, 335);
		g.drawString("- Dodge the asteroids or kill them for points, asteroids do 20 damage on hard, 15 normal and 10 easy.", 10, 355);
		g.drawString("- Collect power ups in order to regain health AKA ammo, unless you get a fake power up!", 10, 375);
		g.drawString("- Have fun, try to stay alive for as long as possible and beat your highscore!", 10, 395);
		g.drawImage(BackButton, gc.getWidth() / 2 - (450 / 2), 480);
	}

	public int getID() {
		return 2;
	}
}