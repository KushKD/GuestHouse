package epds.guesthouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class Activity_Splash extends Activity {

    /**
     * kushkumardhawan@gmail.com
     * Kush Kumar Dhawan
     */
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 *
			 * Kush New
			 */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity   //LoginActivity.class
                Intent i = new Intent(Activity_Splash.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

 
}
