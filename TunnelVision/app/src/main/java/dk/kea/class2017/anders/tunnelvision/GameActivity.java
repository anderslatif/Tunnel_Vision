package dk.kea.class2017.anders.tunnelvision;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dk.kea.class2017.anders.tunnelvision.GameWorld.OpenGLView;

public class GameActivity extends AppCompatActivity {

    private OpenGLView gameGLSurfaceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game); // todo when I am sure that I don't need this then delete the xml file too


        gameGLSurfaceView = new OpenGLView(this);
        setContentView(gameGLSurfaceView);


    }

    // the onPause and onResume calls methods in the GLSurfaceView
    @Override
    public void onPause() {
        super.onPause();
        gameGLSurfaceView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        gameGLSurfaceView.onResume();
    }





}
