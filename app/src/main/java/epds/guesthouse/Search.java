package epds.guesthouse;

import android.app.Activity;
import android.app.ProgressDialog;
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


    List<RoomTypePojo> RoomTypeList;
    Boolean Initialize_Flag = false;
    private Spinner spinner_guest_house;
    private Button search_guest_house, view_guest_house;
    private Button check_in_guest_house, check_out_guest_house;
    String Room_Type = null;
    int roomt ;
    String roomType = null;
    String checkin_Date = null;
    String checkout_Date = null;


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
            if (isOnline()) {
                

                Toast.makeText(getApplication(),"Starting AsyNc Task",Toast.LENGTH_LONG).show();
                requestData("");



            } else {
                Toast.makeText(this, "Network isn't available . Please Connect To Internet", Toast.LENGTH_LONG).show();
            }



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
                Intent i_calender = new Intent(Search.this, Activity_Calender.class);
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

        search_guest_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });
    }

    private void getdata() {

      int  Room_Type_Position = spinner_guest_house.getSelectedItemPosition();

        if(Room_Type_Position<=0 || Room_Type_Position>0){
         roomt = RoomTypeList.get(Room_Type_Position).getRt_Id();
            Toast.makeText(getApplicationContext(),Integer.toString(Room_Type_Position)+"==="+ Integer.toString(roomt) , Toast.LENGTH_LONG).show();
            roomType = Integer.toString(roomt);

            if(roomType!=null && roomType.length()!= 0){

                checkin_Date = check_in_guest_house.getText().toString().trim();
                if(checkin_Date!=null && checkin_Date.length()!=0 ){

                    checkout_Date = check_out_guest_house.getText().toString().trim();
                    if (checkout_Date!=null &&  checkout_Date.length()!=0 ){

                        //Check Date Here
                        Boolean check_Date_Service = DateCheck.Check_Date(checkin_Date,checkout_Date);

                        if(check_Date_Service){
                            Toast.makeText(getApplication(),roomType + "==" + checkin_Date+ "=="+ checkout_Date,Toast.LENGTH_LONG).show();

                            //Async Task Start Here
                            if(isOnline()){

                                StringBuilder sb = new StringBuilder();
                               
                                sb.append("enter url");
                                sb.append("checkin_GH=");sb.append(checkin_Date+"&");
                                sb.append("checkout_GH=");sb.append(checkout_Date+"&");
                                sb.append("Typeid_gh=");sb.append(roomType);

                                String URL_Service = sb.toString();
                                Toast.makeText(getApplication(),URL_Service,Toast.LENGTH_LONG).show();

                                Intent i = new Intent(Search.this , List_Rooms_search.class);
                                i.putExtra("url", URL_Service);
                                startActivity(i);

                            }else{
                                Toast.makeText(getApplication(),"You are not connected to Internet. Please connect to Internet",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getApplication(), "Please Enter Valid Dates",Toast.LENGTH_LONG).show();
                        }



                    }else{
                        Toast.makeText(getApplicationContext(),"Check Out date cannot be empty" , Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Check In date cannot be empty" , Toast.LENGTH_LONG).show();
                }


            }else{
                Toast.makeText(getApplicationContext(),"Room type cannot be empty" , Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),Integer.toString(Room_Type_Position)+"==="+ "No Data" , Toast.LENGTH_LONG).show();
        }

     
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


    }

    private class MyTask extends AsyncTask<String, String, String> {

        private final ProgressDialog dialog = new ProgressDialog(Search.this);

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Getting Types Of Rooms");
            this.dialog.show();
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
            this.dialog.dismiss();



        }

        @Override
        protected void onProgressUpdate(String... values) {
//			updateDisplay(values[0]);
        }

    }
}
