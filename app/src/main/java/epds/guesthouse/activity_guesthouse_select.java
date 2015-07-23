package epds.guesthouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.marcohc.robotocalendar.test;


public class activity_guesthouse_select extends test implements Animation.AnimationListener {

    Boolean Initialize_Flag = false;

    LinearLayout GH1 , GH2, GH3, GH4;
    Constants App_Constants = new Constants();

    // Animation
    Animation animBounce , animBounceLR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_guesthouse_select);

        Initialize_Flag =  initialize_controls();// Animation

        if(Initialize_Flag) {
            animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
            animBounceLR = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncelefttoright);
            animBounce.setAnimationListener(this);
            animBounceLR.setAnimationListener(this);
            startanimation();
        }

        GH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 01/07/15
                Intent i = new Intent(activity_guesthouse_select.this , List_Rooms_Activity.class);
                i.putExtra("id", App_Constants.GuestHouseID_Circuit);
                startActivity(i);

            }
        });

        GH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 01/07/15
                Intent i = new Intent(activity_guesthouse_select.this , List_Rooms_Activity.class);
                i.putExtra("id", App_Constants.GuestHouseID_Surajtal);
                startActivity(i);

            }
        });

        GH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 01/07/15
                Intent i = new Intent(activity_guesthouse_select.this , List_Rooms_Activity.class);
                i.putExtra("id", App_Constants.GuestHouseID_Kailash);
                startActivity(i);

            }
        });

        GH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 01/07/15

                Intent i = new Intent(activity_guesthouse_select.this , List_Rooms_Activity.class);
                i.putExtra("id", App_Constants.GuestHouseID_Dhauldhar);
                startActivity(i);
            }
        });




    }



  boolean  initialize_controls(){

      try{
          GH1 = (LinearLayout)findViewById(R.id.button_guesthouseone);
          GH2 = (LinearLayout)findViewById(R.id.button_guesthousetwo);
          GH3 = (LinearLayout)findViewById(R.id.button_guesthousethree);
          GH4 = (LinearLayout)findViewById(R.id.button_guesthousefour);
          return true;

      }catch(Exception e){
          return false;
      }

    }

   private void startanimation(){
       GH1.startAnimation(animBounce);
       GH2.startAnimation(animBounceLR);
       GH3.startAnimation(animBounce);
       GH4.startAnimation(animBounceLR);

    }


    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for zoom in animation
        if (animation == animBounce) {
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
}
