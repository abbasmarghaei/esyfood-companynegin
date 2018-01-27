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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
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
import java.util.List;
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

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    ImageView icon;
    Button se;

    public static String city="";
    public static String citytype="";

    List<String> lists = new ArrayList<String>();
    int tstt;
    public static  String[] items,itemciti,itemcitit,es;
    int minTimer;
    int secTimer;
    EditText serch_h;
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



    Spinner s3,s2;

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
     //   shegeft_txt = (TextView) findViewById(R.id.shegeft_txt);
        //************************************************
        txt_log_in = (TextView) findViewById(R.id.txtshop);
        //*****************************************
       // icon = (ImageView) findViewById(R.id.icon_tool);
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout);
       listPorococt = (ListView) findViewById(R.id.prodoct_list);
        listset = (ListView) findViewById(R.id.seting_list);
        listby = (ListView) findViewById(R.id.by_list);
        //*******************************************
//        s3 = (Spinner) findViewById(R.id.spinner3);
//        s2 = (Spinner) findViewById(R.id.cty);



        //*******************************************

        //*******************************************{
        item=new ArrayList<>();
        item.add(new ProductMenuList("پیشنهاد ویره دیجی کالا"));
        item.add(new ProductMenuList("پرفوش ترین ها"));
        item.add(new ProductMenuList("جدیدترین ها"));
        item.add(new ProductMenuList("پربازدید ترینها"));
        listPorococt.setAdapter(new ProductMenuAdapter(MainActivity.this, R.layout.procuct_menu_list, item));
        con=getApplicationContext();

//        se.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                citytype=serch_h.getText().toString();
//                Intent intent=new Intent(MainActivity.this,MapsActivityda.class);
//                startActivity(intent);
//
//            }
//
//        });
        //***********************************
     preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.con);
        String email=preferences.getString("email","ورود ثبت نام");
       log_in_txt.setText(email);

        //*******************************
        item_by=new ArrayList<>();
        item_by.add(new ByctMenuList(R.drawable.hoss, "خانه"));
        item_by.add(new ByctMenuList(R.drawable.list,"لیست دسته بندی محصولات"));
        item_by.add(new ByctMenuList(R.drawable.sa_d, "سبد کالا"));
        listby.setAdapter(new ByMenuAdapter(MainActivity.this, R.layout.bay_menu_list, item_by));

        //*******************************
        item_seting=new ArrayList<>();
        item_seting.add(new StingMenuList( "تنظیمات"));
        item_seting.add(new StingMenuList( "درباره ما"));
        item_seting.add(new StingMenuList("سوالات متداول"));

        listset.setAdapter(new StingMenuAdapter(MainActivity.this, R.layout.seting_menu_list,item_seting));


        con=getApplicationContext();
        url=new ArrayList<>();
        name=new ArrayList<>();

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
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            sliderShow.addSlider(textSliderView);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name.get(i));
          //  .setOnSliderClickListener(this);

        }
/*

    icon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            drawrel.openDrawer(Gravity.LEFT);

        }
    });
    */
//**************************************************
        /*
        for (int i=0;i<5;i++ )
        {
            creatCadr();
        }
       */
      //  ShowAmazingProduct();
            //*******************************************
        log_in_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.con, Activity_user_sign_in.class);
                startActivity(i);



                }


        });
        //*******************************************************
}
//*****************************************************توابع
public void onItemSelectedt(AdapterView<?> parent, View view, int pos,
                           long id) {
    Toast.makeText(parent.getContext(),
            //****************************

            "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
            Toast.LENGTH_SHORT).show();

}

    public void creatCadr()
    {
        kadrr =new kadr(con);
        layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        li_she.addView(kadrr);
    }
    //********************************************
    //*******************************************
    public void CreateProductAmazing( String picurl) {

        kadrr = new kadr(con);
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

                String pic = object.getString("pic");
                //String picc = object.getString("picc");
        String picurl = "http://192.168.1.104/shop/img/"+pic;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //****************************************
    @Override
    public void onSliderClick(BaseSliderView slider) {
       // Toast.makeText(MainActivity.con,"dfg");
      //  Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();

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
