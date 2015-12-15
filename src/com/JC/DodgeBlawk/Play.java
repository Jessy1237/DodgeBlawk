package com.JC.DodgeBlawk;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import com.JC.DodgeBlawk.Graphics.Images;
import com.JC.DodgeBlawk.Graphics.Render;
import com.JC.DodgeBlawk.Management.Score;
import com.JC.DodgeBlawk.Util.Animations;
import com.JC.DodgeBlawk.Util.Input;
import com.JC.DodgeBlawk.Util.LoadEntities;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Play extends BasicGameState {

	public static int deltaTime;

	public TrueTypeFont DebugRenderFont;
	public TrueTypeFont RenderFont;
	public static boolean ShowInformation = false;

	public Play(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		gc.setClearEachFrame(true);
		
		if (ShowInformation == false && DodgeBlawk.debug == true)
			ShowInformation = true;
		
		if (DodgeBlawk.getDataManager().highscore.isEmpty()) {
			DodgeBlawk.getDataManager().addHighScore(new Score("easy", 0));
			DodgeBlawk.getDataManager().addHighScore(new Score("normal", 0));
			DodgeBlawk.getDataManager().addHighScore(new Score("hard", 0));
		}

		new LoadEntities();
		new Images();
		new Animations();
		initFont();
	}

	public void initFont() {
		InputStream inputStream = ResourceLoader.getResourceAsStream("assets/fonts/Font.TTF");
		try {
			Font rawRenderFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			rawRenderFont = rawRenderFont.deriveFont(20f);
			RenderFont = new TrueTypeFont(rawRenderFont, true);

			rawRenderFont = rawRenderFont.deriveFont(20f);
			DebugRenderFont = new TrueTypeFont(rawRenderFont, true);
		} catch (Exception e) {

		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		deltaTime = delta;
		new Input(this, gc, sbg);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		new Render(this, gc, sbg, g);
	}

	public int getID() {
		return 1;
	}
}