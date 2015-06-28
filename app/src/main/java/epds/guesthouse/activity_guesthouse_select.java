package epds.guesthouse;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class activity_guesthouse_select extends AppCompatActivity implements Animation.AnimationListener {

    Boolean Initialize_Flag = false;

    LinearLayout GH1 , GH2, GH3, GH4;

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
                //GH1.setBackgroundColor(Color.GREEN);
                Toast.makeText(activity_guesthouse_select.this,"First Guest House",Toast.LENGTH_SHORT).show();
            }
        });

        GH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GH1.setBackgroundColor(Color.GREEN);
                Toast.makeText(activity_guesthouse_select.this,"Second Guest House",Toast.LENGTH_SHORT).show();
            }
        });

        GH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GH1.setBackgroundColor(Color.GREEN);
                Toast.makeText(activity_guesthouse_select.this,"Third Guest House",Toast.LENGTH_SHORT).show();
            }
        });

        GH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GH1.setBackgroundColor(Color.GREEN);
                Toast.makeText(activity_guesthouse_select.this,"Fourth Guest House",Toast.LENGTH_SHORT).show();
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
