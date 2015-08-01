package epds.guesthouse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GuestHouseSearchDetails extends Activity {

    TextView SrNo_Search;
    TextView Hostel_Search;
    TextView RoomNo_Search;
    TextView Floor_Entrance_Search;
    TextView Orientation_Search;
    TextView TypeRooom_Search;
    TextView BathFacility_Search;
    TextView TVFacility_Search;
    TextView RoomCondition_Search;
   TextView BedCapacity_Search;
   TextView RoomBook_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_house_search_details);

        SrNo_Search = (TextView)findViewById(R.id.tv1_roomDetailsSearch);
        Hostel_Search = (TextView)findViewById(R.id.tv2_roomDetailsSearch);
        RoomNo_Search = (TextView)findViewById(R.id.tv3_roomDetailsSearch);
        Floor_Entrance_Search = (TextView)findViewById(R.id.tv4_roomDetailsSearch);
        Orientation_Search = (TextView)findViewById(R.id.tv5_roomDetailsSearch);
        TypeRooom_Search = (TextView)findViewById(R.id.tv6_roomDetailsSearch);
        BathFacility_Search = (TextView)findViewById(R.id.tv7_roomDetailsSearch);
        TVFacility_Search = (TextView)findViewById(R.id.tv8_roomDetailsSearch);
        RoomCondition_Search = (TextView)findViewById(R.id.tv9_roomDetailsSearch);
        BedCapacity_Search = (TextView)findViewById(R.id.tv10_roomDetailsSearch);
        RoomBook_Search = (TextView)findViewById(R.id.tv11_roomDetailsSearch);



        Intent getRoomDetailsIntent = getIntent();
        GuestHouseSearchPojo guestHousesearchDetails =    (GuestHouseSearchPojo) getRoomDetailsIntent.getSerializableExtra("Details");


        SrNo_Search.setText(Integer.toString(guestHousesearchDetails.getSrNo_Search()));
        Hostel_Search.setText(guestHousesearchDetails.getHostel_Search());
        RoomNo_Search.setText(guestHousesearchDetails.getRoomNo_Search());
        Floor_Entrance_Search.setText(guestHousesearchDetails.getFloor_Entrance_Search());
        Orientation_Search.setText(guestHousesearchDetails.getOrientation_Search());
        TypeRooom_Search.setText(guestHousesearchDetails.getTypeRooom_Search());
        BathFacility_Search.setText(guestHousesearchDetails.getBathFacility_Search());
        TVFacility_Search.setText(guestHousesearchDetails.getTVFacility_Search());
        RoomCondition_Search.setText(guestHousesearchDetails.getRoomCondition_Search());
        BedCapacity_Search.setText(Integer.toString(guestHousesearchDetails.getBedCapacity_Search()));
        RoomBook_Search.setText(Integer.toString(guestHousesearchDetails.getRoomBook_Search()));


    }

}
