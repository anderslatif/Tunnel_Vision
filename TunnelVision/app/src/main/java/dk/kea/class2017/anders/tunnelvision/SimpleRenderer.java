package dk.kea.class2017.anders.tunnelvision;


import android.opengl.GLSurfaceView.Renderer;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.NewTest.ColoredTriangleTest;
import dk.kea.class2017.anders.tunnelvision.NewTest.Square;
import dk.kea.class2017.anders.tunnelvision.ThreeD.Square3d;

public class SimpleRenderer implements Renderer {

    Random rand = new Random();
    ColoredTriangleTest triangle;
    Square square;
    Square3d drawable;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        triangle = new ColoredTriangleTest();
        square = new Square();
        drawable = new Square3d(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }



    @Override
    public void onDrawFrame(GL10 gl) {




        drawable.present(gl);

    }



}