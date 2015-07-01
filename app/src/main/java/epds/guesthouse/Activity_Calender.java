package epds.guesthouse;



    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.marcohc.robotocalendar.RobotoCalendarView;
    import com.marcohc.robotocalendar.RobotoCalendarView.RobotoCalendarListener;

    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.Locale;
    import java.util.Random;

    import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

    /**
     * Sample Activity
     *
     * @author Marco Hernaiz Cao
     */
    public class Activity_Calender extends Activity implements RobotoCalendarListener {

        private RobotoCalendarView robotoCalendarView;
        private int currentMonthIndex;
        private Calendar currentCalendar;
        private TextView t;
        private Button bt;

        DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_calender);

            t = (TextView)findViewById(R.id.tv);
            bt = (Button)findViewById(R.id.bt);

            // Gets the calendar from the view
            robotoCalendarView = (RobotoCalendarView) findViewById(R.id.robotoCalendarPicker);

            // Set listener, in this case, the same activity
            robotoCalendarView.setRobotoCalendarListener(this);

            // Initialize the RobotoCalendarPicker with the current index and date
            currentMonthIndex = 0;
            currentCalendar = Calendar.getInstance(Locale.getDefault());

            // Mark current day
            robotoCalendarView.markDayAsCurrentDay(currentCalendar.getTime());

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(t.getText().length() !=0) {
                       // Toast.makeText(getApplicationContext(),t.getText().toString().trim(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.putExtra("RESULT_STRING", t.getText().toString().trim());
                        setResult(RESULT_OK, intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Select Date" , Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

        @Override
        protected void attachBaseContext(Context newBase) {
            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }

        @Override
        public void onDateSelected(Date date) {

            // Mark calendar day
            robotoCalendarView.markDayAsSelectedDay(date);

            // Mark that day with random colors
            final Random random = new Random(System.currentTimeMillis());
            final int style = random.nextInt(3);
            switch (style) {
                case 0:
                    robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.BLUE_COLOR, date);
                    // Toast.makeText(getApplicationContext(),date.toString(),Toast.LENGTH_SHORT).show();
                    formattedDate = targetFormat.format(date);
                    t.setText(formattedDate);
                    break;
                case 1:
                    robotoCalendarView.markSecondUnderlineWithStyle(RobotoCalendarView.GREEN_COLOR, date);
                    formattedDate = targetFormat.format(date);
                    t.setText(formattedDate);
                    break;
                case 2:
                    robotoCalendarView.markFirstUnderlineWithStyle(RobotoCalendarView.RED_COLOR, date);
                    formattedDate = targetFormat.format(date);
                    t.setText(formattedDate);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onRightButtonClick() {
            currentMonthIndex++;
            updateCalendar();
        }

        @Override
        public void onLeftButtonClick() {
            currentMonthIndex--;
            updateCalendar();
        }

        private void updateCalendar() {
            currentCalendar = Calendar.getInstance(Locale.getDefault());
            currentCalendar.add(Calendar.MONTH, currentMonthIndex);
            robotoCalendarView.initializeCalendar(currentCalendar);
        }
    }




