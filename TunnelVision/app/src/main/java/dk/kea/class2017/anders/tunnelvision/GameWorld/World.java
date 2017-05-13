package dk.kea.class2017.anders.tunnelvision.GameWorld;


import android.media.MediaPlayer;

import dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations.Ball;
import dk.kea.class2017.anders.tunnelvision.GameWorld.Calculations.BallCalculations;
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

    public static void calculateProximity() {
        int newSound = 0;

        int proximityConstant = 40;
        proximity = (float) Math.sqrt(Math.pow(2, Ball.x - goalX) + Math.pow(2, Ball.y - goalY))*proximityConstant;  //todo remember to get the numeric positive value
        System.out.println("##################" + proximity);

        if (proximity > 100) {
            newSound = 82 - 7; // 82 is the base note: C
            isBallOutOfBounds = true;
        } else if (proximity > 90) {
            newSound = 82 - 6;
        } else if (proximity > 80) {
            newSound = 82 - 5;
        } else if (proximity > 75) {
            newSound = 82 - 4;
        } else if (proximity > 70) {
            newSound = 82 - 3;
        } else if (proximity > 65) {
            newSound = 82 - 2;
        } else if (proximity > 60) {
            newSound = 82 - 1;
        } else if (proximity > 55) {
            newSound = 82;
        } else if (proximity > 50) {
            newSound = 82 + 1;
        } else if (proximity > 46) {
            newSound = 82 + 2;
        } else if (proximity > 44) {
            newSound = 82 + 3;
        } else if (proximity > 40) {
            newSound = 82 + 4;
        } else if (proximity > 38) {
            newSound = 82 + 5;
        } else if (proximity > 37) {
            newSound = 82 + 6;
        } else if (proximity < 37) {
            newSound = 82 + 7;
            nextLevel();
            BallCalculations.setNewBallPosition(World.level);
        }

        System.out.println("################" + Ball.x + " : " + Ball.y);

        if (newSound != sound) {
            sound = newSound;
            SoundUtil.playNote(sound);
        }




    }

}
