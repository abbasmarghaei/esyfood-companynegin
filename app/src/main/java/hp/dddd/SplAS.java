package hp.dddd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplAS extends AppCompatActivity {
    private ImageView img;
    private ImageView img1  ;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4,img5,img6,img7;
public static String timer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img = (ImageView) findViewById(R.id.farr);
        img2 = (ImageView) findViewById(R.id.mivee);
        ani(img);
        ani1(img2);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplAS.this, MainActivity.class);
                startActivity(i);
            }
        }, 3500);
       // Toast.makeText(MainActivity.con, timer, Toast.LENGTH_SHORT).show();


    }
    private void ani(View v) {
        TranslateAnimation anim = new TranslateAnimation(-300,10, 0, 0);
        anim.setFillAfter(true);
        anim.setDuration(3000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
       // circularAnim(img);
    }
    private void ani1(View v) {
        TranslateAnimation anim = new TranslateAnimation(220,-10, 0, 0);
        anim.setFillAfter(true);
        anim.setDuration(2000);
        //  anim.setRepeatMode(Animation.REVERSE);
        v.startAnimation(anim);

        //v.animate().translationX(200).translationY(-200).rotationX(360).alpha(0.5f).setDuration(1000);
      //  circularAnim(img);
    }
}
