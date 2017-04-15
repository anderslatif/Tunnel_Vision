package dk.kea.class2017.anders.tunnelvision;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import dk.kea.class2017.anders.tunnelvision.GameWorld.BallPhysicsCalculations;
import dk.kea.class2017.anders.tunnelvision.GameWorld.GraphicalElements.Ball;
import dk.kea.class2017.anders.tunnelvision.GameWorld.GraphicalElements.BasicShapes.Sphere;
import dk.kea.class2017.anders.tunnelvision.GameWorld.GraphicalElements.BasicShapes.Square3d;

public class GameRenderer implements Renderer {

    private long startTime = System.nanoTime();
    private float[] accelerometer;

    // Ambient light
    private final float[] mat_ambient = { 0.2f, 0.3f, 0.4f, 1.0f };
    private FloatBuffer mat_ambient_buf;
    // Parallel incident light
    private final float[] mat_diffuse = { 0.4f, 0.6f, 0.8f, 1.0f };
    private FloatBuffer mat_diffuse_buf;
    // The highlighted area
    private final float[] mat_specular = { 0.2f * 0.4f, 0.2f * 0.6f, 0.2f * 0.8f, 1.0f };
    private FloatBuffer mat_specular_buf;

    private Sphere sphere;
    private Ball ball;
    private BallPhysicsCalculations ballPhysicsCalculations;
    private float[] ballCalculations;

    public volatile float mLightX = 10f;
    public volatile float mLightY = 10f;
    public volatile float mLightZ = 10f;

    Square3d paddle;


    public GameRenderer(float[] accelerometer) {

        this.accelerometer = accelerometer;
        sphere = new Sphere();
        ball = new Ball(0.0f, 0.0f, -3.0f);
        ballPhysicsCalculations = new BallPhysicsCalculations(ball);
    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

        paddle = new Square3d(gl);

        // On the perspective correction
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        // Background: Black
        gl.glClearColor(0, 0.0f, 0.0f, 0.0f);
        // Start the smooth shading
        gl.glShadeModel(GL10.GL_SMOOTH);

        // Reset the depth buffer
        gl.glClearDepthf(1.0f);
        // Start the depth test
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // Type the depth test
        gl.glDepthFunc(GL10.GL_LEQUAL);

        initBuffers();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        // Set the output screen size
        gl.glViewport(0, 0, width, height);

        // Projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset the projection matrix
        gl.glLoadIdentity();
        // Set the viewport size
        // gl.glFrustumf(0, width, 0, height, 0.1f, 100.0f);

        GLU.gluPerspective(gl, 90.0f, (float) width / height, 0.1f, 50.0f);

        // Select the model view matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // Reset the modelview matrix
        gl.glLoadIdentity();

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
        startTime = System.nanoTime();

        // To clear the screen and the depth buffer
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // Reset the modelview matrix
        gl.glLoadIdentity();

        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);

        // Texture of material
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, mat_ambient_buf);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, mat_diffuse_buf);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, mat_specular_buf);
        // Specular exponent 0~128 less rough
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 96.0f);

        //The position of the light source
        float[] light_position = {mLightX, mLightY, mLightZ, 0.0f};
        ByteBuffer mpbb = ByteBuffer.allocateDirect(light_position.length*4);
        mpbb.order(ByteOrder.nativeOrder());
        FloatBuffer mat_posiBuf = mpbb.asFloatBuffer();
        mat_posiBuf.put(light_position);
        mat_posiBuf.position(0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, mat_posiBuf);


        ballCalculations = ballPhysicsCalculations.calculateNextMove(deltaTime);
        gl.glTranslatef(ballCalculations[0], ballCalculations[2], ballCalculations[4]);
        sphere.draw(gl);

        //paddle.present(gl, accelerometer);
    }



    private void initBuffers() {
        ByteBuffer bufTemp = ByteBuffer.allocateDirect(mat_ambient.length * 4);
        bufTemp.order(ByteOrder.nativeOrder());
        mat_ambient_buf = bufTemp.asFloatBuffer();
        mat_ambient_buf.put(mat_ambient);
        mat_ambient_buf.position(0);

        bufTemp = ByteBuffer.allocateDirect(mat_diffuse.length * 4);
        bufTemp.order(ByteOrder.nativeOrder());
        mat_diffuse_buf = bufTemp.asFloatBuffer();
        mat_diffuse_buf.put(mat_diffuse);
        mat_diffuse_buf.position(0);

        bufTemp = ByteBuffer.allocateDirect(mat_specular.length * 4);
        bufTemp.order(ByteOrder.nativeOrder());
        mat_specular_buf = bufTemp.asFloatBuffer();
        mat_specular_buf.put(mat_specular);
        mat_specular_buf.position(0);
    }

}