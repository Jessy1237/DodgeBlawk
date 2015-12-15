package com.JC.DodgeBlawk.Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import org.newdawn.slick.util.ResourceLoader;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

public class Sound {

	@SuppressWarnings("unused")
	private static Sound staticSound = new Sound();
	public String name;
	public AudioClip sound;

	private Sound() {

	}

	public Sound(String name, URL url) {
		this.name = name;
		try {
			sound = Applet.newAudioClip(url);
		} catch (Exception e) {
		}

	}

	public void play() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (sound != null) {
					sound.play();
				}
			}
		}).start();

	}

	public void loop() {
		new Thread(new Runnable() {

			public void run() {
				if (sound != null) {
					sound.loop();
				}
			}
		}).start();
	}

	public void stop() {
		if (sound != null) {
			sound.stop();
		}
	}

	public static URL getURL(String string) {
		return ResourceLoader.getResource("assets/sound/" + string);
	}
}
