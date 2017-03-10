package dk.kea.class2017.anders.tunnelvision;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dk.kea.class2017.anders.tunnelvision.Graphics.GameGLSurfaceView;

public class GameActivity extends AppCompatActivity {

    private GameGLSurfaceView surfaceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game); // todo when I am sure that I don't need this then delete the xml file too


        surfaceView = new GameGLSurfaceView(this);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + surfaceView);
        setContentView(surfaceView);


    }


/*    public void onPause() {
        super.onPause();
        surfaceView.onPause();
    }

    public void onResume() {
        super.onResume();
        surfaceView.onResume();
    }*/





}
