package hp.dddd;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //Toast.makeText(MainActivity.con, MainActivity.city, Toast.LENGTH_SHORT).show();
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        ;
        Address add=adrees(MainActivity.city);
        LatLng tt = new LatLng(add.getLatitude(),add.getLongitude());
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
