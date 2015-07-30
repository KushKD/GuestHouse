package epds.guesthouse;

import java.io.Serializable;

/**
 * Created by KD on 7/30/2015.
 */
public class GuestHouseSearchPojo implements Serializable {

   private int SrNo_Search;
    private String Hostel_Search;
    private  String RoomNo_Search;
    private  String Floor_Entrance_Search;
    private String Orientation_Search;
    private  String TypeRooom_Search;
    private  String BathFacility_Search;
    private  String TVFacility_Search;
    private String RoomCondition_Search;
    private  int BedCapacity_Search;
    private int RoomBook_Search;



    public String getTypeRooom_Search() {
        return TypeRooom_Search;
    }

    public void setTypeRooom_Search(String typeRooom_Search) {
        TypeRooom_Search = typeRooom_Search;
    }

    public int getRoomBook_Search() {
        return RoomBook_Search;
    }

    public void setRoomBook_Search(int roomBook_Search) {
        RoomBook_Search = roomBook_Search;
    }

    public int getBedCapacity_Search() {
        return BedCapacity_Search;
    }

    public void setBedCapacity_Search(int bedCapacity_Search) {
        BedCapacity_Search = bedCapacity_Search;
    }

    public String getRoomCondition_Search() {
        return RoomCondition_Search;
    }

    public void setRoomCondition_Search(String roomCondition_Search) {
        RoomCondition_Search = roomCondition_Search;
    }

    public String getTVFacility_Search() {
        return TVFacility_Search;
    }

    public void setTVFacility_Search(String TVFacility_Search) {
        this.TVFacility_Search = TVFacility_Search;
    }

    public String getBathFacility_Search() {
        return BathFacility_Search;
    }

    public void setBathFacility_Search(String bathFacility_Search) {
        BathFacility_Search = bathFacility_Search;
    }

    public String getOrientation_Search() {
        return Orientation_Search;
    }

    public void setOrientation_Search(String orientation_Search) {
        Orientation_Search = orientation_Search;
    }

    public String getFloor_Entrance_Search() {
        return Floor_Entrance_Search;
    }

    public void setFloor_Entrance_Search(String floor_Entrance_Search) {
        Floor_Entrance_Search = floor_Entrance_Search;
    }

    public String getRoomNo_Search() {
        return RoomNo_Search;
    }

    public void setRoomNo_Search(String roomNo_Search) {
        RoomNo_Search = roomNo_Search;
    }

    public String getHostel_Search() {
        return Hostel_Search;
    }

    public void setHostel_Search(String hostel_Search) {
        Hostel_Search = hostel_Search;
    }

    public int getSrNo_Search() {
        return SrNo_Search;
    }

    public void setSrNo_Search(int srNo_Search) {
        SrNo_Search = srNo_Search;
    }



}
