package dk.kea.class2017.anders.tunnelvision.NewTest;


import android.opengl.GLSurfaceView;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SimpleRenderer implements GLSurfaceView.Renderer {

    Random rand = new Random();
    TriangleTest triangle;
    Square square;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        triangle = new TriangleTest();
        square = new Square();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        triangle.draw(gl);
        //square.draw(gl);
    }



}
