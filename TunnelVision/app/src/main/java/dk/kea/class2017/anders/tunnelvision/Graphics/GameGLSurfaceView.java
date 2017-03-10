package dk.kea.class2017.anders.tunnelvision.Graphics;


import android.content.Context;
import android.opengl.GLSurfaceView;

public class GameGLSurfaceView extends GLSurfaceView {

    private final GameRenderer renderer;

    public GameGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer = new GameRenderer();
        // Set the GameRenderer for drawing on the GLSurfaceView
        setRenderer(renderer);

    }



}
