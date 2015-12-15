package com.JC.DodgeBlawk.Graphics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TexturepackLoader {

	String userHome = System.getProperty("user.home");

	public TexturepackLoader() {
		try {
			BufferedReader TexturePackNameReader = new BufferedReader(new FileReader(userHome + "/DodgeBlawk/Texturepack.txt"));
			String TexturepackName = TexturePackNameReader.readLine();
			if (new File(userHome + "/DodgeBlawk/TexuturePacks/" + TexturepackName).exists()){
				reloadTextures();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void reloadTextures(){
		
	}
}
