package dk.kea.class2017.anders.tunnelvision;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.EGLConfig;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.microedition.khronos.opengles.GL10;

import dk.kea.class2017.anders.tunnelvision.GameEngine.GLUtil.GLGraphics;

public class GameActivity extends AppCompatActivity implements SensorEventListener, GLSurfaceView.Renderer {

    private OpenGLView gameGLSurfaceView;
    private float[] accelerometer = new float[3];  // contains values x, y, z
    private GLGraphics glGraphics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor accSensor =  manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_GAME);
        }

        gameGLSurfaceView = new OpenGLView(this, accelerometer);
        setContentView(gameGLSurfaceView);

        glGraphics = new GLGraphics(gameGLSurfaceView);
    }


    // the onPause and onResume calls methods in the GLSurfaceView
    @Override
    public void onPause() {
        super.onPause();

        ((SensorManager)getSystemService(Context.SENSOR_SERVICE)).unregisterListener(this);

        gameGLSurfaceView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor accSensor = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_GAME);
        }

        gameGLSurfaceView.onResume();
    }

    public float[] getAccelerometer() {
        return accelerometer;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        System.arraycopy(event.values, 0, accelerometer, 0, 3);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }




    // the three methods below are implementations from android.Renderer
    @Override
    public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {
        glGraphics = new GLGraphics(gameGLSurfaceView);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }


    public GLGraphics getGLGraphics() {
        return glGraphics;
    }


}
