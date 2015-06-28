package epds.guesthouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class activity_guesthouse_select extends AppCompatActivity implements Animation.AnimationListener {

    Boolean Initialize_Flag = false;

    LinearLayout GH1 , GH2, GH3, GH4;

    // Animation
    Animation animBounce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guesthouse_select);

        Initialize_Flag =  initialize_controls();// Animation

        if(Initialize_Flag) {
            animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
            animBounce.setAnimationListener(this);
            startanimation();
        }


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
       GH2.startAnimation(animBounce);
       GH3.startAnimation(animBounce);
       GH4.startAnimation(animBounce);

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
