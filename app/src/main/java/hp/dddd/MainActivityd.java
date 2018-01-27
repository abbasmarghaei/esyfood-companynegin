package hp.dddd;

import android.app.ActionBar;
import android.app.WallpaperManager;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
//*************************
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
//**************************
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivityd extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    ImageView icon;

    int hourTimer;
    int minTimer;
    int secTimer;
    public static int minn,secc,hourr;
    public static Handler handler1;
    public static String timer="";
    DrawerLayout drawrel;
    ArrayList <String> url;
    LinearLayout log_in_li,li_she;
    TextView log_in_txt,txt_exit,txt_shop,txt_log_in,txt_name,shegeft_txt;
    public static SharedPreferences preferences;
    kadr kadrr;
    LinearLayout.LayoutParams layoutParams;
    ArrayList <String> name;
    ListView listPorococt,listby,listset;
    ArrayList<ProductMenuList> item;
    ArrayList<ByctMenuList> item_by;
    ArrayList<StingMenuList> item_seting;
    TextView txthour, txtmin, txtsec;

    public static Context con;
//**************************/

//*******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigition_view);
        //******************************************
      log_in_li = (LinearLayout) findViewById(R.id.log_liiiii);

        //*******************************************
     log_in_txt = (TextView) findViewById(R.id.login_ttt);
        txt_exit = (TextView) findViewById(R.id.txt_exit);
        txt_shop = (TextView) findViewById(R.id.txtshop);
        txt_name = (TextView) findViewById(R.id.login_ttt1);
        //************************************************
        txt_log_in = (TextView) findViewById(R.id.txtshop);
        //************************************************
        //*****************************************
        icon = (ImageView) findViewById(R.id.icon_tool);
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout);

        con=getApplicationContext();
        url=new ArrayList<>();
        name=new ArrayList<>();

        url.add("http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url.add("http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url.add("http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url.add("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        name.add("fon");
        name.add("fam");
        name.add("nam");
        name.add("shoghl");
        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        for (int i=0;i<url.size();i++ )
        {
            TextSliderView textSliderView = new TextSliderView(this);
          //  TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            sliderShow.addSlider(textSliderView);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name.get(i));
          //  .setOnSliderClickListener(this);

        }
        drawrel.openDrawer(Gravity.LEFT);

    icon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            drawrel.openDrawer(Gravity.LEFT);

        }
    });
//**************************************************
        /*
        for (int i=0;i<5;i++ )
        {
            creatCadr();
        }
       */
            //******************************************
        //*******************************************************
}


    public void creatCadr()
    {
        kadrr =new kadr(con);
        layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        li_she.addView(kadrr);
    }
    //********************************************
    //*******************************************
    public void CreateProductAmazing(int id, String name, String price, String pprice, String picurl) {

        kadrr = new kadr(con);
        kadrr.id=id;
        kadrr.name.setText(name);
        kadrr.price.setText(price);
        kadrr.pprice.setText(pprice);
        Picasso.with(this).load(picurl).into(kadr.pic);
       // Toast.makeText(getApplicationContext(), "id:" + id + "  url:" + picurl, Toast.LENGTH_LONG).show();

        //   Picasso.with(con).load("http://http://192.168.1.104/shop/img/h1.jpg").into(kadr.pic);1
        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        li_she.addView(kadrr);
      //  shegeft_txt.setText(picurl);

    }
    //*****************************************
    public void ShowAmazingProduct() {

        try {
            JSONArray jsonArray = new JSONArray(Splashh.kadrr);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt("id");
                String name = object.getString("nam");
                String price = String.valueOf(object.getInt("price") + " تومان");
                String pprice = String.valueOf(object.getInt("pprice") + " تومان");

                String pic = object.getString("pic");
                //String picc = object.getString("picc");
        String picurl = "http://192.168.1.104/shop/img/"+pic;//"http://192.168.1.104/shop/golryy.php"
                String picur2 = "http://hpph12.cloudsite.ir/dgkala/img/"+pic;//"http://192.168.1.104/shop/golryy.php"


//                String picurl = "http://192.168.1.33/shop/"+pic;//"http://192.168.1.104/shop/golryy.php"


                CreateProductAmazing(id, name, price, pprice, picur2);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //****************************************
    @Override
    public void onSliderClick(BaseSliderView slider) {
       // Toast.makeText(MainActivity.con,"dfg");
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
