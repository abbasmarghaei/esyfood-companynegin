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
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity_sabt_restooran extends FragmentActivity implements OnMapReadyCallback {
int x=0;
    private GoogleMap mMap;
    EditText  serch_h ;
   String citytype="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_restootan);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_adres);

        //************************************************

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        
        }
    public void tst(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        citytype=serch_h.getText().toString();

        Address add=adrees(citytype);
        int yyt=5;
        //  Toast.makeText(MapsActivity_sabt_restooran.this,add.getLatitude()+"",Toast.LENGTH_SHORT).show();

   LatLng tt = new LatLng(-34, 151);

        mMap.addMarker(new MarkerOptions().position(tt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("Marker in Sydney"));
         mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tt, 15));

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
}
