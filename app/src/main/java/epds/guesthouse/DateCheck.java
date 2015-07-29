package epds.guesthouse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KD on 7/29/2015.
 */
public class DateCheck {

    public static Boolean Check_Date(String checkin_date,String checkout_date){
        String checkin = checkin_date;
        String checkout = checkout_date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = new Date();
        Date convertedDate2 = new Date();
        try {
            convertedDate = dateFormat.parse(checkin);
            convertedDate2 = dateFormat.parse(checkout);
            if (convertedDate2.after(convertedDate)) {
               return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
