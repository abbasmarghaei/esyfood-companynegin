package hp.dddd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Splashh extends AppCompatActivity {
    TextView sing_outt,sing_out,sabt;
    EditText pass,user,pass_tk;
    public static String data="";
    public static String kadrr="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

     //   new AsyncTaskAmazingProduct("http://hpph12.cloudsite.ir/dgkala/golryy.php").execute();
       // new AsyncTaskAmazingProduct("http://192.168.1.33/shop/golryy.php").execute();

        //*****************************************************************
       // new AsyncTasktimrt("http://192.168.1.104/shop/androidsettimer.php").execute();
       // new AsyncTasktimrt("http://hpph12.cloudsite.ir/dgkala/androidsettimer.php").execute();

     //   new AsyncTasktimrt("http://192.168.1.33/shop/androidsettimer.php").execute();   "http://hpph12.cloudsite.ir/likee5.php";
        //***************************************************************************
        final ProgressDialog dialog=new ProgressDialog(Splashh.this);
        dialog.setMessage("لطفا منتظر بمانید...");
        dialog.show();

        final Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(Splashh.this, MainActivity.class);
                        //  i.putExtra("email", data);
                        if (data.equals("")) {
                         //   Toast.makeText(getApplicationContext(),data+" fasele "+kadrr, Toast.LENGTH_SHORT).show();

                            startActivity(i);
                            timer.cancel();
                        }
                        else {
                       //     Toast.makeText(getApplicationContext(), data+kadrr, Toast.LENGTH_SHORT).show();


                        }
                    }
                });
            }
        },1,1000);
//*******************************************************************************


// ***********************************************************************///
    }
}
