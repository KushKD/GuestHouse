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
 * Created by KD on 7/30/2015.
 */
public class GuestHouseAdapterSearch extends ArrayAdapter<GuestHouseSearchPojo> {

    private Context context;
    private List<GuestHouseSearchPojo> guesthouselistsearch;

    public GuestHouseAdapterSearch(Context context, int resource, List<GuestHouseSearchPojo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.guesthouselistsearch = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_flower, parent, false);

        //Display flower name in the TextView widget
        GuestHouseSearchPojo ghp = guesthouselistsearch.get(position);
        TextView tv = (TextView) view.findViewById(R.id.textView1_room_no);
        TextView tv2 = (TextView)view.findViewById(R.id.textView2_floor_entrance);


        tv.setText(Integer.toString(ghp.getRoomBook_Search()));
        tv2.setText(ghp.getHostel_Search());

        return view;
    }

}
