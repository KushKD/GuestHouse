package epds.guesthouse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class List_Rooms_search extends Activity {

    ProgressBar pb;
    List<MyTask> tasks;
    ListView LV;
    String url = null;
    List<GuestHouseSearchPojo> guestHouseList_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__rooms_search);
        LV = (ListView)findViewById(R.id.list);

        tasks = new ArrayList<>();

        //Just Get The URL
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        url = bundle.getString("url");

        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        if (isOnline()) {

            requestData(url);
            Toast.makeText(getApplication(),url,Toast.LENGTH_LONG).show();



        } else {
            Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
        }



        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
              /*  GuestHousePojo guestHouseDetails = (GuestHousePojo)	parent.getItemAtPosition(position);

                Intent roomDetails = new Intent();
                roomDetails.putExtra(Constants.Room_DETAILS_TO_PASS, guestHouseDetails);
                roomDetails.setClass(List_Rooms_Activity.this, GuestHouseDetails.class);

                // update database for my favorite member
                //  memberDetailsDBAdapter.updateFavrouiteList(searchMemberDetails);
                startActivity(roomDetails);
                // finish();*/
            }
        });
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

        GuestHouseAdapterSearch adapter = new GuestHouseAdapterSearch(this, R.layout.item_flower, guestHouseList_Search);
        LV.setAdapter(adapter);

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

            Log.d("######", params[0]);
            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String result) {

            guestHouseList_Search = GuestHouseJsonParser.parseFeedSearch(result);
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
