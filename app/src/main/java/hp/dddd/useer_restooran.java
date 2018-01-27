package hp.dddd;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class useer_restooran extends AppCompatActivity {
    DrawerLayout drawrel;
    ImageView icon, tstr;
    LinearLayout m_sabtr, m_sabtv, m_sabte, m_sabtd;
    EditText serch_h;
    Button menu, etl, nazar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigition_view_user_restooran);
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayoutUserR);
        icon = (ImageView) findViewById(R.id.icon_toolUs);
        m_sabtr = (LinearLayout) findViewById(R.id.m_sabtr);
        //  TextView   menu = (EditText) findViewById(R.id.menuu);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawrel.openDrawer(Gravity.RIGHT);
                serch_h = (EditText) findViewById(R.id.serch_ed);
                Button ser = (Button) findViewById(R.id.serch_b);
                //*************

            }
        });
        //*************************************menu*****************
        m_sabtr = (LinearLayout) findViewById(R.id.m_sabtr);
        m_sabte = (LinearLayout) findViewById(R.id.m_sabte);
        m_sabtv = (LinearLayout) findViewById(R.id.m_sabtv);
        m_sabtd = (LinearLayout) findViewById(R.id.m_sabtd);
        //****************************************

                menu = (Button) findViewById(R.id.menuu);

        etl = (Button) findViewById(R.id.etlu);
        nazar = (Button) findViewById(R.id.nazau);
//****************************************************

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menu.setTextColor(Color.rgb(255, 8, 6));
                etl.setTextColor(Color.rgb(255, 255, 255));
                nazar.setTextColor(Color.rgb(255, 255, 255));

            }
        });
        etl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etl.setTextColor(Color.rgb(255, 8, 6));
                menu.setTextColor(Color.rgb(255, 255, 255));
                nazar.setTextColor(Color.rgb(255, 255, 255));
            }
        });
        nazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nazar.setTextColor(Color.rgb(255, 8, 6));
                etl.setTextColor(Color.rgb(255, 255, 255));
                menu.setTextColor(Color.rgb(255, 255, 255));
            }
        });

        //***************************************************
        m_sabtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_sabtr.setBackgroundColor(Color.rgb(255, 8, 6));

                Intent intent = new Intent(useer_restooran.this, user_reetooran1.class);
                startActivity(intent);
            }
        });
        m_sabte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_sabte.setBackgroundColor(Color.rgb(255, 8, 6));

            }
        });
        m_sabtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_sabtd.setBackgroundColor(Color.rgb(255, 8, 6));

            }
        });
        m_sabtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_sabtv.setBackgroundColor(Color.rgb(255, 8, 6));
                Intent intent = new Intent(useer_restooran.this, log_in.class);
                startActivity(intent);

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "useer_restooran Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://hp.dddd/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "useer_restooran Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://hp.dddd/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
