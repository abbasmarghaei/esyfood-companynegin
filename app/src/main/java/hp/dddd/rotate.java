package hp.dddd;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;



public class rotate extends Activity {
    public MediaPlayer player;

    private ImageView img;
    private ImageView img1  ;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4,img5,img6,img7;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img = (ImageView) findViewById(R.id.farr);
        img2 = (ImageView) findViewById(R.id.mivee);





        //Toast.makeText(getApplicationContext(), 2f+"" , Toast.LENGTH_SHORT).show();
//*************************************
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(rotate.this, MainActivity.class);
                startActivity(intent);

            }
        }, 3500);
        ani(img);
        ani1(img2);
        //*******************************



// ************************************

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

//****************************************
    //****************************************

    private void bienteha(View v) {
        Animation anim = new RotateAnimation(0f,360f);
        anim.setFillAfter(true);
        anim.setRepeatCount(1000);
        anim.setDuration(3000);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void noto(View v) {
        Animation anim = new RotateAnimation(0f,360f);
        anim.setFillAfter(true);
        anim.setRepeatCount(1000);
        anim.setDuration(800);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void sare(View v) {
        Animation anim = new RotateAnimation(0f,60f);
        anim.setFillAfter(true);
        anim.setRepeatCount(1000);
        anim.setDuration(400);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void stope(View v) {
        Animation anim = new RotateAnimation(0f,0f);
        anim.setFillAfter(true);
        anim.setRepeatCount(0);
        anim.setDuration(0);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void ani(View v) {
        TranslateAnimation anim = new TranslateAnimation(-300,10, 0, 0);
        anim.setFillAfter(true);
        anim.setDuration(3000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void ani1(View v) {
        TranslateAnimation anim = new TranslateAnimation(220,-10, 0, 0);
        anim.setFillAfter(true);
        anim.setDuration(2000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void movarab_ptb(View v) {
        TranslateAnimation anim = new TranslateAnimation(250,-800, 400, -220);
        anim.setFillAfter(true);
        anim.setDuration(2000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void movarab_btp(View v) {
        TranslateAnimation anim = new TranslateAnimation(-800,350, 400, -220);
        anim.setFillAfter(true);
        anim.setDuration(5000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    private void movarab_btp_b(View v) {
        TranslateAnimation anim = new TranslateAnimation(-1400,300, -700, 590);
        anim.setFillAfter(true);
        anim.setDuration(5000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    //*********************************
    private void movarab_btp_r(View v) {
        TranslateAnimation anim = new TranslateAnimation(100,-900,-400, 680);
        anim.setFillAfter(true);
        anim.setDuration(5000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);

    }

    private void ef(View v) {
        Animation anim = new ScaleAnimation(0, 2f, 0, 2.5f);//در همان شکل باقی میماند
        anim.setDuration(1000);
        anim.setFillAfter(true);
        v.startAnimation(anim);
        circularAnim(img);
    }

    private void ef1(View v) {
        Animation anim = new ScaleAnimation(0, 2f, 0, 2.5f);
        //به حالت بوت رفت و برگششت سریع
        anim.setDuration(3000);
        //  anim.setFillAfter(true);
        anim.setInterpolator(new BounceInterpolator());
        // anim.setRepeatCount(Animation.INFINITE);
        // anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(0);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
        circularAnim(img);
    }
    void circularAnim(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = v.getWidth() / 2;
            int cy = v.getHeight() / 2;
            Animator anim = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, 2 * cx);
            anim.setDuration(250);
            anim.start();
        }
    }





}
