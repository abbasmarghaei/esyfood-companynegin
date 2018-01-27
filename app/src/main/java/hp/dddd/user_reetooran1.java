package hp.dddd;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class user_reetooran1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
int x;
    int y=0;
    EditText serch_h ;
    String citytype="ahvaz";
    public static LatLng lat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_restootan1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_adres1);
        mapFragment.getMapAsync(this);
        //**********************************
        serch_h = (EditText) findViewById(R.id.ostan_serch_etR);
        Button ser = (Button) findViewById(R.id.serch1);
        Button nex= (Button) findViewById(R.id.nexbtn);
        //**************************************

ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y=1;
                citytype = serch_h.getText().toString();
                s(mMap);



            }
        });
        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (y == 0) {
                    Toast.makeText(user_reetooran1.this, "مکان حود را ثبت کنید", Toast.LENGTH_SHORT).show();

                } else {
                    s(mMap);
                    Intent intent = new Intent(user_reetooran1.this, sabt_ratooran_b_n.class);
                    startActivity(intent);
                }

            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        citytype = serch_h.getText().toString();
        Address add = adrees(citytype);
        LatLng tt = new LatLng(34.126851, -118.349261);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tt, 15));


        //***************************************************
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                if (x < 1) {

                    mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    x++;


                }
            }
        });
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });


    }
    public void s(GoogleMap googleMap) {
        mMap = googleMap;
        citytype = serch_h.getText().toString();
        Address add = adrees(citytype);
        LatLng tt = new LatLng(add.getLatitude(), add.getLongitude());

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tt, 15));//***************************************************
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                if (x < 1) {


                    mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).draggable(true));
                    mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

                        @Override
                        public void onMarkerDragStart(Marker marker) {

                        }

                        @Override
                        public void onMarkerDrag(Marker marker) {

                        }


                        public void onMarkerDragEnd(Marker marker) {

                        }
                    });
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    x++;
                    lat = latLng;



                }
            }
        });


        mMap.addMarker(new MarkerOptions().position(tt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).draggable(true));
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });
        ;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tt));

//**********************************************

        //***************************************
    }

    public Address adrees(String adresss)
    {
        Geocoder ge=new Geocoder(this);
        List<Address> list=null;
        try {
            list=ge.getFromLocationName(adresss,1);
            if (list.size()>0)
            {
                Address add =list.get(0);
                return add;
            }
            else
                return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void addMarker(Address address) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(new LatLng(address.getLatitude(), address.getLongitude()))
                        //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk))
                .draggable(true)
                .rotation(90);
        mMap.addMarker(markerOptions);
    }
}
