package dk.kea.class2017.anders.tunnelvision;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import static dk.kea.class2017.anders.tunnelvision.R.id.btn_menu_play;
import static dk.kea.class2017.anders.tunnelvision.R.id.btn_menu_settings;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);*/



        // todo for testing we go directly to the game instead of the main menu this should be removed some time in the future
        callGameActivityTest(savedInstanceState);
    }

    public void callGameActivityTest(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = new Intent(this, GameActivity.class);
        this.startActivity(intent);
    }

    public void callGameActivity(View view) {
        setContentView(R.layout.activity_game);

        Intent intent = new Intent(this, GameActivity.class);
        this.startActivity(intent);
    }

    public void callSettingsActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        this.startActivity(intent);
    }

    public void quitApp(View view) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
