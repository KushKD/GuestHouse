package epds.guesthouse;

import java.io.Serializable;

/**
 * Created by HPZ231 on 23-07-2015.
 */
public class GuestHousePojo implements Serializable {

    /**
     * kush kumar dhawan
     * kushkumardhawan@gmail.com
     */

    private String RoomNo;
    private String FloorEntrance;
    private String Orientation;
    private String Type_Of_Room;
    private String Bath_Facility;
    private String TV_Facility;
    private String Room_Condition;
    private String Bed_Capacity;



    public String getTV_Facility() {
        return TV_Facility;
    }

    public void setTV_Facility(String TV_Facility) {
        this.TV_Facility = TV_Facility;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getFloorEntrance() {
        return FloorEntrance;
    }

    public void setFloorEntrance(String floorEntrance) {
        FloorEntrance = floorEntrance;
    }

    public String getOrientation() {
        return Orientation;
    }

    public void setOrientation(String orientation) {
        Orientation = orientation;
    }

    public String getType_Of_Room() {
        return Type_Of_Room;
    }

    public void setType_Of_Room(String type_Of_Room) {
        Type_Of_Room = type_Of_Room;
    }

    public String getBath_Facility() {
        return Bath_Facility;
    }

    public void setBath_Facility(String bath_Facility) {
        Bath_Facility = bath_Facility;
    }

    public String getRoom_Condition() {
        return Room_Condition;
    }

    public void setRoom_Condition(String room_Condition) {
        Room_Condition = room_Condition;
    }

    public String getBed_Capacity() {
        return Bed_Capacity;
    }

    public void setBed_Capacity(String bed_Capacity) {
        Bed_Capacity = bed_Capacity;
    }


}
