package epds.guesthouse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Search extends Activity {

    List<MyTask> tasks;
    List<RoomTypePojo> RoomTypeList;
    ProgressBar pb;
    Boolean Initialize_Flag = false;
    private Spinner spinner_guest_house;
    private Button search_guest_house, view_guest_house;
    private Button check_in_guest_house, check_out_guest_house;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (isOnline()) {
            // requestData("http://services.hanselandpetal.com/feeds/flowers.json");
            //  requestData("http://10.0.2.2:8002/api/GuestHouse/"+Guest_House_ID);   //epds Lap
            requestData("http://10.0.2.2:8001/api/GuestHouse");



        } else {
            Toast.makeText(this, "Network isn't available . Please Connect To Internet", Toast.LENGTH_LONG).show();
        }

        /*Initialize_Flag = initialize_controls();// Animation
        if (Initialize_Flag) {
            //animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
            // animBounceLR = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncelefttoright);
            // animBounce.setAnimationListener(this);
            // animBounceLR.setAnimationListener(this);
            // startanimation();



        }*/


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

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
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

    protected void updateDisplay() {

        RoomTypePojo rtp = new RoomTypePojo();
        String [] guest_houses = new String[RoomTypeList.size()];

        for (int i=0;i<RoomTypeList.size();i++){
            guest_houses[i] = RoomTypeList.get(i).getRt_text();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,guest_houses);
        spinner_guest_house.setAdapter(adapter);
//        if (guestHouseList != null) {
//            for (GuestHousePojo guesthouse : guestHouseList) {
//                output.append(guesthouse.getRoomNo() +"\t" + guesthouse.getOrientation() +"\t"+ guesthouse.getType_Of_Room() + "\n");
//            }
//        }

       // GuestHouseAdapter adapter = new GuestHouseAdapter(this, R.layout.item_flower, guestHouseList);
       // LV.setAdapter(adapter);

    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
//			updateDisplay("Starting task");

            if (tasks.size() == 0) {
                pb.setVisibility(View.VISIBLE);
            }
            tasks.add(this);
        }

        @Override
        protected String doInBackground(String... params) {

            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String result) {

            RoomTypeList = GuestHouseJsonParser.parseFeedRoom(result);
            updateDisplay();

            tasks.remove(this);
            if (tasks.size() == 0) {
                pb.setVisibility(View.INVISIBLE);
                // output.setText(result);
            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
//			updateDisplay(values[0]);
        }

    }
}
