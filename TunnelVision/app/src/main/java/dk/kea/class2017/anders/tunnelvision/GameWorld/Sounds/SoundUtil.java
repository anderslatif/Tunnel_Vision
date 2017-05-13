package dk.kea.class2017.anders.tunnelvision.GameWorld.Sounds;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.File;
import java.io.IOException;

import dk.kea.class2017.anders.tunnelvision.R;

public class SoundUtil {

    public static Context context;
    public static SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

    // my sound id board
    public static int soundIdGameStart;
    public static int vibraphone75;
    public static int vibraphone76;
    public static int vibraphone77;
    public static int vibraphone78;
    public static int vibraphone79;
    public static int vibraphone80;
    public static int vibraphone81;
    public static int vibraphone82;
    public static int vibraphone83;
    public static int vibraphone84;
    public static int vibraphone85;
    public static int vibraphone86;
    public static int vibraphone87;
    public static int vibraphone88;
    public static int vibraphone89;



    // since soundpool.load is asynchronous I preload them instead of implementing CompletableFuture
    public static void loadSounds() {
        soundIdGameStart = soundPool.load(context, R.raw.gamestart, 1);
        vibraphone75 = soundPool.load(context, R.raw.vibraphone75, 1);
        vibraphone76 = soundPool.load(context, R.raw.vibraphone76, 1);
        vibraphone77 = soundPool.load(context, R.raw.vibraphone77, 1);
        vibraphone78 = soundPool.load(context, R.raw.vibraphone78, 1);
        vibraphone79 = soundPool.load(context, R.raw.vibraphone79, 1);
        vibraphone80 = soundPool.load(context, R.raw.vibraphone80, 1);
        vibraphone81 = soundPool.load(context, R.raw.vibraphone81, 1);
        vibraphone82 = soundPool.load(context, R.raw.vibraphone82, 1);
        vibraphone83 = soundPool.load(context, R.raw.vibraphone83, 1);
        vibraphone84 = soundPool.load(context, R.raw.vibraphone84, 1);
        vibraphone85 = soundPool.load(context, R.raw.vibraphone85, 1);
        vibraphone86 = soundPool.load(context, R.raw.vibraphone86, 1);
        vibraphone87 = soundPool.load(context, R.raw.vibraphone87, 1);
        vibraphone88 = soundPool.load(context, R.raw.vibraphone88, 1);
        vibraphone89 = soundPool.load(context, R.raw.vibraphone89, 1);
    }

    public static void playGameStart() {
        soundPool.play(soundIdGameStart, 1, 1, 0, 0, 1);
    }

    public static void playNote(int soundFileNumber) {

        switch (soundFileNumber) {
            case 75:
                soundPool.play(vibraphone75, 1, 1, 0, 0, 1);
                break;
            case 76:
                soundPool.play(vibraphone76, 1, 1, 0, 0, 1);
                break;
            case 77:
                soundPool.play(vibraphone77, 1, 1, 0, 0, 1);
                break;
            case 78:
                soundPool.play(vibraphone78, 1, 1, 0, 0, 1);
                break;
            case 79:
                soundPool.play(vibraphone79, 1, 1, 0, 0, 1);
                break;
            case 80:
                soundPool.play(vibraphone80, 1, 1, 0, 0, 1);
                break;
            case 81:
                soundPool.play(vibraphone81, 1, 1, 0, 0, 1);
                break;
            case 82:
                soundPool.play(vibraphone82, 1, 1, 0, 0, 1);
                break;
            case 83:
                soundPool.play(vibraphone83, 1, 1, 0, 0, 1);
                break;
            case 84:
                soundPool.play(vibraphone84, 1, 1, 0, 0, 1);
                break;
            case 85:
                soundPool.play(vibraphone85, 1, 1, 0, 0, 1);
                break;
            case 86:
                soundPool.play(vibraphone86, 1, 1, 0, 0, 1);
                break;
            case 87:
                soundPool.play(vibraphone87, 1, 1, 0, 0, 1);
                break;
            case 89:
                soundPool.play(vibraphone88, 1, 1, 0, 0, 1);
                break;
            default:
                System.out.println("Unspecified sound file");
        }

    }

    public static void dispose(int soundId) {
        soundPool.unload(soundId);
    }


}
