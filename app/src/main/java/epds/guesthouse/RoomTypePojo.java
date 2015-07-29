package epds.guesthouse;

/**
 * Created by KD on 7/29/2015.
 */
public class RoomTypePojo {
    public int getRt_SrNo() {
        return rt_SrNo;
    }

    public void setRt_SrNo(int rt_SrNo) {
        this.rt_SrNo = rt_SrNo;
    }

    public int getRt_Id() {
        return rt_Id;
    }

    public void setRt_Id(int rt_Id) {
        this.rt_Id = rt_Id;
    }

    public String getRt_text() {
        return rt_text;
    }

    public void setRt_text(String rt_text) {
        this.rt_text = rt_text;
    }

    private int rt_SrNo ;
    private int rt_Id;
    private String rt_text;

}
