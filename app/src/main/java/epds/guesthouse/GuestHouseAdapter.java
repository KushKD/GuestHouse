package epds.guesthouse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kush Kumar Dhawan on 24-07-2015.
 */
public class GuestHouseAdapter extends ArrayAdapter<GuestHousePojo> {

    private Context context;
    private List<GuestHousePojo> guesthouselist;

    public GuestHouseAdapter(Context context, int resource, List<GuestHousePojo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.guesthouselist = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_flower, parent, false);

        //Display flower name in the TextView widget
        GuestHousePojo ghp = guesthouselist.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView1_room_no);
        TextView tv2 = (TextView)view.findViewById(R.id.textView2_floor_entrance);


        tv.setText(ghp.getRoomNo());
        tv2.setText(ghp.getFloorEntrance());

        return view;
    }


}
