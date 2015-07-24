package epds.guesthouse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GuestHouseDetails extends Activity {

    String  RoomNo = null;
    String FloorEntrance = null;
    String  Orientation = null;
    String Type_Of_Room = null;
    String  Bath_Facility = null;
    String TV_Facility = null;
    String  Room_Condition = null;
    String BedCapacity = null;

   TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_house_details);

        tv = (TextView)findViewById(R.id.tv1);

        Intent getRoomDetailsIntent = getIntent();
        GuestHousePojo guestHouseDetails =	(GuestHousePojo) getRoomDetailsIntent.getSerializableExtra(Constants.Room_DETAILS_TO_PASS);

        RoomNo = guestHouseDetails.getRoomNo();
        tv.setText(RoomNo);





    }


}
