package epds.guesthouse;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GuestHouseDetails extends Activity {

    /**
     * Kush Kumar Dhawan
     * kushkumardhawan@gmail.com
     */

    TextView RoomNo;
    TextView FloorEntrance;
    TextView Orientation;
    TextView Type_Of_Room;
    TextView Bath_Facility;
    TextView TV_Facility;
    TextView Room_Condition;
    TextView Bed_Capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_house_details);

        RoomNo = (TextView)findViewById(R.id.tv1_roomDetails);
        FloorEntrance = (TextView)findViewById(R.id.tv2_roomDetails);
        Type_Of_Room= (TextView)findViewById(R.id.tv3_roomDetails);
        Orientation= (TextView)findViewById(R.id.tv4_roomDetails);
        Bath_Facility= (TextView)findViewById(R.id.tv5_roomDetails);
        TV_Facility = (TextView)findViewById(R.id.tv6_roomDetails);
        Room_Condition= (TextView)findViewById(R.id.tv7_roomDetails);
        Bed_Capacity= (TextView)findViewById(R.id.tv8_roomDetails);


        Intent getRoomDetailsIntent = getIntent();
        GuestHousePojo guestHouseDetails =	(GuestHousePojo) getRoomDetailsIntent.getSerializableExtra(Constants.Room_DETAILS_TO_PASS);


        RoomNo.setText(guestHouseDetails.getRoomNo());
        FloorEntrance.setText(guestHouseDetails.getFloorEntrance());
        Type_Of_Room.setText(guestHouseDetails.getType_Of_Room());
        Orientation.setText(guestHouseDetails.getOrientation());
        Bath_Facility.setText(guestHouseDetails.getBath_Facility());
        TV_Facility.setText(guestHouseDetails.getTV_Facility());
        Room_Condition.setText(guestHouseDetails.getRoom_Condition());
        Bed_Capacity.setText(guestHouseDetails.getBed_Capacity());





    }


}
