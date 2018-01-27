package hp.dddd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyLocationActivity extends RuntimePermissionsActivity implements OnMapReadyCallback
{
    public static String data="";
    public static String citytype="";
    EditText serch_h;
    DrawerLayout drawrel;
    ArrayList<StingMenuList> item_seting;
    ListView listPorococt,listby,listset;
    ImageView icon,tstr;
    LinearLayout m_sabtr,m_sabtv,m_sabte,m_sabtd;
    ArrayList<ProductMenuList> item;
    ArrayList<ByctMenuList> item_by;
    Boolean se;
    ArrayList<String> url,name;
ImageView logg;
    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//******************************************************************
            setContentView(R.layout.navigition_view);
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapmain);
           mapFragment.getMapAsync(this);
        //*****************************************************slider
        url=new ArrayList<>();
        icon = (ImageView) findViewById(R.id.icon_tool);
        tstr = (ImageView) findViewById(R.id.tstr);
        name=new ArrayList<>();
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout);
        url.add("https://companynegin.com/banner1.jpg");
        url.add("https://companynegin.com/banner2.jpg");
        url.add("https://companynegin.com/banner2.jpg");
        name.add("fon");
        name.add("fam");
        name.add("nam");
        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        for (int i=0;i<url.size();i++ )
        {
            TextSliderView textSliderView = new TextSliderView(this);
            //  TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
               //     .setOnSliderClickListener(this);
            sliderShow.addSlider(textSliderView);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name.get(i));
            //  .setOnSliderClickListener(this);

        }
        //*********************************************************serch
        serch_h = (EditText) findViewById(R.id.serch_ed);
      Button  ser = (Button) findViewById(R.id.serch_b);
        //***********************************************

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawrel.openDrawer(Gravity.RIGHT);

            }
        });
        ser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                citytype=serch_h.getText().toString();
//                Intent intent=new Intent(MyLocationActivity.this,MapsActivityda.class);
//                startActivity(intent);
//**************************************************************************************
                new AsyncTasktimrt("http://mivefarangi.companynegin.com/lat.php").execute();

                final Timer timer=new Timer();
                Toast.makeText( MyLocationActivity.this, data, Toast.LENGTH_LONG).show();


        //***********************************************************************

            }

    });
        tstr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MyLocationActivity.this,useer_restooran.class);
                startActivity(intent);


            }

        });
        //*************************************menu*****************
        m_sabtr = (LinearLayout) findViewById(R.id.m_sabtr);
        m_sabte = (LinearLayout) findViewById(R.id.m_sabte);
        m_sabtv = (LinearLayout) findViewById(R.id.m_sabtv);
        m_sabtd = (LinearLayout) findViewById(R.id.m_sabtd);
        //***************************************************
        m_sabtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_sabtr.setBackgroundColor(Color.rgb(255, 8, 6));

                Intent intent = new Intent(MyLocationActivity.this, user_reetooran1.class);
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
    Intent intent = new Intent(MyLocationActivity.this, log_in.class);
    startActivity(intent);

        }
        });
        //**********************************************************
        ImageView  log = (ImageView) findViewById(R.id.re_ba);

        log.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {

        Intent intent = new Intent(MyLocationActivity.this, user_reetooran1.class);
        startActivity(intent);


        }

        });
        }

@Override
public void onPermissionsGranted(int requestCode)
        {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return;
        }
        mMap.setMyLocationEnabled(true);
        }

@Override
public void onPermissionsDeny(int requestCode)
        {
        finish();
        }

/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
@Override
public void onMapReady(GoogleMap googleMap)
        {
        mMap = googleMap;
//32.699119, 51.507156


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(32.698799, 51.507501);
        LatLng sydney1 = new LatLng(32.698701, 51.509268);
        mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//*********************************************************
        mMap.addMarker(new MarkerOptions().position(sydney1).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
        MyLocationActivity.super.requestAppPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
    }
}
