package dk.kea.class2017.anders.tunnelvision;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import dk.kea.class2017.anders.tunnelvision.GameWorld.OpenGLView;

public class GameActivity extends AppCompatActivity implements SensorEventListener {

    private OpenGLView gameGLSurfaceView;
    private float[] accelerometer = new float[3];  // contains values x, y, z



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor accSensor =  manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_GAME);
        }

        gameGLSurfaceView = new OpenGLView(this, accelerometer);
//        gameGLSurfaceView.setBackgroundResource(R.drawable.tunnel);
//        gameGLSurfaceView.setZOrderOnTop(false);
        setContentView(gameGLSurfaceView);

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









}
