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



    // since soundpool.load is asynchronous I preload them instead of implementing CompletableFuture
    public static void loadSounds() {
        soundIdGameStart = soundPool.load(context, R.raw.gamestart, 1);
    }

    public static void playGameStart() {
        soundPool.play(soundIdGameStart, 1, 1, 0, 0, 1);
    }

    public static void dispose(int soundId) {
        soundPool.unload(soundId);
    }


}
