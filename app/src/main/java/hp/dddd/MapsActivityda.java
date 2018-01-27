package hp.dddd;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class MapsActivityda extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mapsda);
        hsme(mMap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
     //   Toast.makeText(MainActivity.con, MainActivity.citytype, Toast.LENGTH_SHORT).show();
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        /**/
        Address add=adrees(MyLocationActivity.citytype);
        LatLng tt = new LatLng(add.getLatitude(),add.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tt, 17));
        mMap.addMarker(new MarkerOptions().position(tt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("lat"+add.getLatitude()+"lan"+add.getLongitude()+""));

//        LatLng ttt = new LatLng(add.getLatitude()+0.003000,add.getLongitude());
//        LatLng ttt1 = new LatLng(add.getLatitude()+0.006000,add.getLongitude());
//        mMap.addMarker(new MarkerOptions().position(ttt1).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("Marker in Sydney").draggable(true));
//
//        mMap.addMarker(new MarkerOptions().position(tt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("lat"+add.getLatitude()+"lan"+add.getLongitude()+""));
//        mMap.addMarker(new MarkerOptions().position(ttt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)).title("Marker in Sydney").draggable(true));

        //LatLng tt = new LatLng(add.getLatitude(),add.getLongitude());

    }

    public void hsme(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            JSONArray jsonArray = new JSONArray(MyLocationActivity.data);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject object = jsonArray.getJSONObject(i);
                double lat = object.getInt(String.valueOf("lat"));
                double lon =  object.getInt(String.valueOf("lat"));
              //  LatLng ttt = new LatLng(lat,lon);
              //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ttt, 3));
//                mMap.addMarker(new MarkerOptions().position(ttt).icon(BitmapDescriptorFactory.fromResource(R.drawable.markkk)));
                Toast.makeText( MapsActivityda.this, lat+""+lon +"", Toast.LENGTH_LONG).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
