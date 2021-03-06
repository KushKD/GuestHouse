package epds.guesthouse;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class List_Rooms_Activity extends Activity {

    /**
     * Kush Kumar Dhawan
     */

    TextView output;
    ProgressBar  pb;
    List<MyTask> tasks;
    public String Guest_House_ID;
    ListView LV;

    List<GuestHousePojo> guestHouseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__rooms_);

        LV = (ListView)findViewById(R.id.list);
      //  output = (TextView) findViewById(R.id.textView);
       // output.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Guest_House_ID = bundle.getString("id");


        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        tasks = new ArrayList<>();


        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub

                GuestHousePojo guestHouseDetails = (GuestHousePojo)	parent.getItemAtPosition(position);

                Intent roomDetails = new Intent();
                roomDetails.putExtra(Constants.Room_DETAILS_TO_PASS, guestHouseDetails);
                roomDetails.setClass(List_Rooms_Activity.this, GuestHouseDetails.class);

                // update database for my favorite member
              //  memberDetailsDBAdapter.updateFavrouiteList(searchMemberDetails);
                startActivity(roomDetails);
               // finish();

            }
        });

    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    protected void updateDisplay() {

//        if (guestHouseList != null) {
//            for (GuestHousePojo guesthouse : guestHouseList) {
//                output.append(guesthouse.getRoomNo() +"\t" + guesthouse.getOrientation() +"\t"+ guesthouse.getType_Of_Room() + "\n");
//            }
//        }

        GuestHouseAdapter adapter = new GuestHouseAdapter(this, R.layout.item_flower, guestHouseList);
        LV.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list__rooms_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_get_data) {
            if (isOnline()) {
              
                requestData(""+Guest_House_ID);



            } else {
                Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
            }
        }
        return false;
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

            guestHouseList = GuestHouseJsonParser.parseFeed(result);
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
