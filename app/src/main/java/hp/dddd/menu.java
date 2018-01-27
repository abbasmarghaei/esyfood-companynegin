package hp.dddd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {
    LinearLayout log_in_li;
    TextView log_in_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigtion_heder);
        //*********************************************************
        log_in_li = (LinearLayout) findViewById(R.id.login_li);
        log_in_txt = (TextView) findViewById(R.id.login_ttt);
        //************************************************************
        log_in_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in =new Intent(MainActivity.con ,Activity_user_sign_in.class);
//                startActivity(in);
                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
