package epds.guesthouse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Search extends Activity {

    Boolean Initialize_Flag = false;
    private Spinner spinner_guest_house;
    private Button search_guest_house, view_guest_house;
    private Button check_in_guest_house, check_out_guest_house;
    private String [] guest_houses = {"Circuit","Dhauladhar","Surajtal","Kailash"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Initialize_Flag = initialize_controls();// Animation
        if (Initialize_Flag) {
            //animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
            // animBounceLR = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncelefttoright);
            // animBounce.setAnimationListener(this);
            // animBounceLR.setAnimationListener(this);
            // startanimation();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,guest_houses);
            spinner_guest_house.setAdapter(adapter);


        }


        view_guest_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Search.this , activity_guesthouse_select.class);
                startActivity(i);
            }
        });

        check_in_guest_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_calender = new Intent(Search.this , Activity_Calender.class);
                startActivityForResult(i_calender, 10);
            }
        });

        check_out_guest_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_check_out_calender = new Intent(Search.this,Activity_Calender.class);
                startActivityForResult(i_check_out_calender,11);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                //Use Data to get string
                String string = data.getStringExtra("RESULT_STRING");
                Log.d("String is", string);
                check_in_guest_house.setText(string);
            }else{
                Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
            }

        }

        if (requestCode == 11) {
            if (resultCode == RESULT_OK) {
                //Use Data to get string
                String string = data.getStringExtra("RESULT_STRING");
                Log.d("String is", string);
                check_out_guest_house.setText(string);
            }else{
                Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
            }

        }

    }

    boolean initialize_controls() {

        try {
            spinner_guest_house = (Spinner) findViewById(R.id.spinner_guest_house_search);
            search_guest_house = (Button) findViewById(R.id.search_guest_house_search);
            view_guest_house = (Button) findViewById(R.id.view_guest_house_search);
            check_in_guest_house = (Button) findViewById(R.id.check_in_guest_house_search);
            check_out_guest_house = (Button) findViewById(R.id.check_out_guest_house_search);

            return true;

        } catch (Exception e) {
            return false;
        }


    }
}
