package com.JC.DodgeBlawk.Audio;

/*
 * Wyndcrest 2012
 * This game was made by Wyndcrest/JCProductions in the year 2012
 * We created this class as well as any sub classes, packages, other classes etc.
 * The sounds were created in a program called SFXR.
 * This project is open source, feel free to distribute, edit the code.
 * If you edit the code, then please give credit to Wyndcrest as the original creators of the source code before modification.
 */

import java.util.ArrayList;

/**
 *
 * @author Curtis1997
 */
public abstract class SoundManager {
    
    public static ArrayList<Sound> sounds = new ArrayList<Sound>();
    
    public SoundManager() {
     initSounds();
    }
    
    public abstract void initSounds();
    
    public void addSound(Sound sound) {
        sounds.add(sound);
    }
    
    public void removeSound(Sound sound) {
        sounds.remove(sound);
    }
    
    public static void playSound(String name) {
        
        for (Sound s : sounds) {
            if (s.name.equals(name)) {
                s.play();
            }
        }
    }

    public static void loopSound(String name) {
        for (Sound s : sounds) {
            if (s.name.equals(name)) {
                s.loop();
            }
        }
    }

    public void stopSound(String name) {
        for (Sound s : sounds) {
            if (s.name.equals(name)) {
                s.stop();
            }
        }
    }

    public void stopAllSounds() {
        for (Sound s : sounds) {
            s.stop();
        }
    }
}
