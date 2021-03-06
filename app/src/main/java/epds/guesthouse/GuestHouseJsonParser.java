package epds.guesthouse;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HPZ231 on 23-07-2015.
 */
public class GuestHouseJsonParser {

    public static List<GuestHousePojo> parseFeed(String content) {

        try {

            /**
             * Check weather the string is json object or array
             */
            String g_Table = null;
            Object json = new JSONTokener(content).nextValue();
            if (json instanceof JSONObject){

                Log.d("Json ", "Object");
               // JSONArray arr = new JSONArray(content);
               // JSONObject jObj = arr.getJSONObject(0);
               // JSONArray ar = jObj.getJSONArray("Table");
               // Log.d("Table===",ar.toString());

                JSONObject obj = new JSONObject(content);
                 g_Table = obj.optString("Table");
                Log.d("Table===",g_Table);

            }
            //you have an object
            else if (json instanceof JSONArray){

                Log.d("Json ", "Array");
            }


            JSONArray ar = new JSONArray(g_Table);
            List<GuestHousePojo> guestHouseList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {

                JSONObject obj = ar.getJSONObject(i);
                GuestHousePojo guestHouse = new GuestHousePojo();

                guestHouse.setRoomNo(obj.getString("RoomNo"));
                guestHouse.setFloorEntrance(obj.getString("FloorEntrance"));
                guestHouse.setOrientation(obj.getString("Orientation"));
                guestHouse.setType_Of_Room(obj.getString("Type Of Room"));
                guestHouse.setBath_Facility(obj.getString("Bath Facility"));
                guestHouse.setTV_Facility(obj.getString("TV Facility"));
                guestHouse.setRoom_Condition(obj.getString("Room Condition"));
                guestHouse.setBed_Capacity(obj.getString("BedCapacity"));


                guestHouseList.add(guestHouse);
            }

            return guestHouseList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * Getting the Room Type
     */

    public static List<RoomTypePojo> parseFeedRoom(String content) {

        try {

            /**
             * Check weather the string is json object or array
             */
            String g_Table = null;
            Object json = new JSONTokener(content).nextValue();
            if (json instanceof JSONObject){

                Log.d("Json ", "Object");
                // JSONArray arr = new JSONArray(content);
                // JSONObject jObj = arr.getJSONObject(0);
                // JSONArray ar = jObj.getJSONArray("Table");
                // Log.d("Table===",ar.toString());

                JSONObject obj = new JSONObject(content);
                g_Table = obj.optString("Table");
                Log.d("Table===",g_Table);

            }
            //you have an object
            else if (json instanceof JSONArray){

                Log.d("Json ", "Array");
            }


            JSONArray ar = new JSONArray(g_Table);
            List<RoomTypePojo> roomType = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {

                JSONObject obj = ar.getJSONObject(i);
                RoomTypePojo RoomType = new RoomTypePojo();

                RoomType.setRt_SrNo(obj.getInt("SrNo"));
                RoomType.setRt_Id(obj.getInt("Id"));
                RoomType.setRt_text(obj.getString("Text"));


                roomType.add(RoomType);
            }

            return roomType;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Getting the Search Result
     */

    public static List<GuestHouseSearchPojo> parseFeedSearch(String content){
        try {

            Log.d("Json ", "Object");
            Log.d("String ", content);
            /**
             * Check weather the string is json object or array
             */
            String g_Table = null;
            Object json = new JSONTokener(content).nextValue();
            if (json instanceof JSONObject){

                Log.d("Json ", "Object");
                //JSONArray arr = new JSONArray(content);
                // JSONObject jObj = arr.getJSONObject(0);
                // JSONArray ar = jObj.getJSONArray("Table");
                // Log.d("Table===",ar.toString());

                JSONObject obj = new JSONObject(content);
                g_Table = obj.optString("Table");
                Log.d("Table===",g_Table);

            }
            //you have an object
            else if (json instanceof JSONArray){

                Log.d("Json ", "Array");
            }


            JSONArray ar = new JSONArray(g_Table);
            List<GuestHouseSearchPojo> guestHouseListsearch = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {

                JSONObject obj = ar.getJSONObject(i);
                GuestHouseSearchPojo guestHousesearch = new GuestHouseSearchPojo();

                guestHousesearch.setSrNo_Search(obj.getInt("SrNo"));
                guestHousesearch.setHostel_Search(obj.getString("Hostel"));
                guestHousesearch.setRoomNo_Search(obj.getString("RoomNo"));
                guestHousesearch.setFloor_Entrance_Search(obj.getString("Floor Entrance"));
                guestHousesearch.setOrientation_Search(obj.getString("Orientation"));
                guestHousesearch.setTypeRooom_Search(obj.getString("Type Of Room"));
                guestHousesearch.setBathFacility_Search(obj.getString("Bath Facility"));
                guestHousesearch.setTVFacility_Search(obj.getString("TV Facility"));
                guestHousesearch.setRoomCondition_Search(obj.getString("Room Condition"));
                guestHousesearch.setBedCapacity_Search(obj.getInt("Bed Capacity"));
                guestHousesearch.setRoomBook_Search(obj.getInt("Book Room"));


                guestHouseListsearch.add(guestHousesearch);
            }

            return guestHouseListsearch;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
