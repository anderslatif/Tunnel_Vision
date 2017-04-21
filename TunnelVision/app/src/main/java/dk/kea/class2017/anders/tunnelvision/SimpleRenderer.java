package dk.kea.class2017.anders.tunnelvision;


import android.opengl.GLSurfaceView.Renderer;

import java.util.Random;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.Discarded.NewTest.ColoredTriangleTest;
import dk.kea.class2017.anders.tunnelvision.Discarded.NewTest.Square;
import dk.kea.class2017.anders.tunnelvision.Discarded.BasicShapes.Rectangle3d;
import dk.kea.class2017.anders.tunnelvision.Discarded.Calculations.PaddleCalculations;

public class SimpleRenderer implements Renderer {

    private long startTime = System.nanoTime();

    Random rand = new Random();
    ColoredTriangleTest triangle;
    Square square;
    Rectangle3d rectangle3D;
    float[] accelerometer;

    public SimpleRenderer(float[] accelerometer) {
        this.accelerometer = accelerometer;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        triangle = new ColoredTriangleTest();
        square = new Square();
        rectangle3D = new Rectangle3d(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }



    @Override
    public void onDrawFrame(GL10 gl) {

        float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
        startTime = System.nanoTime();

        float[] position = PaddleCalculations.nextPaddlePosition(accelerometer, deltaTime);
        rectangle3D.present(gl, position);

    }



}