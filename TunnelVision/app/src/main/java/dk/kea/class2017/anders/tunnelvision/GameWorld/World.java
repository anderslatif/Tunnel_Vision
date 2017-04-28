package dk.kea.class2017.anders.tunnelvision.GameWorld;


import android.media.MediaPlayer;

import dk.kea.class2017.anders.tunnelvision.GameWorld.Sounds.SoundUtil;

public class World {

    public static int level = 0;

    public static float proximity;

    public static boolean isBallOutOfBounds = false;

    public static int sound = 89;

    public static float goalX;
    public static float goalY;


    public static void nextLevel() {
        SoundUtil.playGameStart();
        level++;
    }

    public void calculateSound() {
        // based on the proximity a sound should play if the sound is not what it currently is
        // remember to set the new sound
    }

}
