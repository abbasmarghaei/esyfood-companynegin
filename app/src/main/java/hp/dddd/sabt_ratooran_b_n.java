package hp.dddd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

public class sabt_ratooran_b_n extends AppCompatActivity {
    EditText tel,nam,name_k;
    String namee,nameek,tell;
    public static String data="";
    public static String lat;
    public static double latt;
    public static double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_ratooran_b_n);
        tel = (EditText) findViewById(R.id.tels);
        nam = (EditText) findViewById(R.id.names);
        name_k = (EditText) findViewById(R.id.name_kars);
        //***********************************************
        Button ser = (Button) findViewById(R.id.btn_sabts);
        //***********************************************
        Toast.makeText(sabt_ratooran_b_n.this, user_reetooran1.lat.latitude+"" , Toast.LENGTH_LONG).show();

//https://sarina.dnswebhost.com:2083/cpsess6523508789/frontend/paper_lantern/filemanager/iex.html
        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//sabt_restooorannd

                namee = nam.getText().toString();
                nameek = name_k.getText().toString();
                tell = tel.getText().toString();
               // new AsyncTaskInsertUp("https://sarina.dnswebhost.com:2083/cpsess6523508789/download?skipencode=1&file=%2fhome2%2fcompany1%2fpublic_html%2fasanfood%2finse.php", namee, nameek).execute();
                LatLng latt;
             //   new Asyncsabt("http://asanfood.companynegin.com/insert.php", namee, nameek,tell).execute();
            sabt_ratooran_b_n.latt= user_reetooran1.lat.latitude;
                sabt_ratooran_b_n.lon= user_reetooran1.lat.longitude;
                new Asyncsabt("http://mivefarangi.companynegin.com/inserta_sabtr.php", namee, nameek,tell,  sabt_ratooran_b_n.latt,lon).execute();
               // new Asyncsabt("https://companynegin.com/asanfood/inse.php", namee, nameek,tell).execute();
                final Timer timer=new Timer();
                //*************************

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(sabt_ratooran_b_n.this, data , Toast.LENGTH_LONG).show();

timer.cancel();
                            }
                        });
                    }
                }, 1, 1000);

            }
        });

    }
}
