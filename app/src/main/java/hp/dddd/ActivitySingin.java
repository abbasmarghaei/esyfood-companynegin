package hp.dddd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import java.util.ArrayList;

public class ActivitySingin extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{
    ImageView icon;
    public static String data_s="";
    public static String data_s_sabt="";
    DrawerLayout drawrel;
    ArrayList <String> url;
    LinearLayout log_in_li,li_sdop;
    TextView log_in_txtt,txt_exit,txt_shop,txt_log_in,txt_name;
    public static SharedPreferences preferences;

    ArrayList <String> name;
    ListView listPorococt,listby,listset;
    ArrayList<ProductMenuList> item;
    ArrayList<ByctMenuList> item_by;
    ArrayList<StingMenuList> item_seting;
    public static Context con;
//**************************/
//*******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigition_view_sing_in);
        //******************************************
      log_in_li = (LinearLayout) findViewById(R.id.log_liiiii);
        li_sdop = (LinearLayout) findViewById(R.id.li_shop);
        //*******************************************
     log_in_txtt = (TextView) findViewById(R.id.login_ttt_S);
        txt_exit = (TextView) findViewById(R.id.txt_exit);
        txt_shop = (TextView) findViewById(R.id.txtshop);
        txt_name = (TextView) findViewById(R.id.login_ttt1);
        //************************************************
        txt_log_in = (TextView) findViewById(R.id.txtshopS);
        //
        //*****************************************
        log_in_txtt.setText(data_s);
      //  log_in_txtt.setText(data_s_sabt);
        //******************************************
        icon = (ImageView) findViewById(R.id.icon_tool);
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout);
       listPorococt = (ListView) findViewById(R.id.prodoct_list);
        listset = (ListView) findViewById(R.id.seting_list);
        listby = (ListView) findViewById(R.id.by_list);
        item=new ArrayList<>();
        item.add(new ProductMenuList("پیشنهاد ویره دیجی کالا"));
        item.add(new ProductMenuList("پرفوش ترین ها"));
        item.add(new ProductMenuList("جدیدترین ها"));
        item.add(new ProductMenuList("پربازدید ترینها"));
        listPorococt.setAdapter(new ProductMenuAdapter(ActivitySingin.this, R.layout.procuct_menu_list, item));
        con=getApplicationContext();
        //*******************************
        //*******************************
        item_by=new ArrayList<>();
        item_by.add(new ByctMenuList(R.drawable.hoss, "خانه"));
        item_by.add(new ByctMenuList(R.drawable.list,"لیست دسته بندی محصولات"));
        item_by.add(new ByctMenuList(R.drawable.sa_d, "سبد کالا"));
        listby.setAdapter(new ByMenuAdapter(ActivitySingin.this, R.layout.bay_menu_list, item_by));

        //*******************************
        item_seting=new ArrayList<>();
        item_seting.add(new StingMenuList( "تنظیمات"));
        item_seting.add(new StingMenuList( "درباره ما"));
        item_seting.add(new StingMenuList( "سوالات متداول"));

        listset.setAdapter(new StingMenuAdapter(ActivitySingin.this, R.layout.seting_menu_list,item_seting));


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

    icon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            preferences = PreferenceManager.getDefaultSharedPreferences(ActivitySingin.con);
          //  String email = preferences.getString("email", "ورود/ثبت نام");
            String insertDone = preferences.getString("do", "");


            li_sdop.setVisibility(View.GONE);
            drawrel.openDrawer(Gravity.LEFT);

        }
    });
//**************************************************
        log_in_txtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(li_sdop.getVisibility()==View.VISIBLE)
                {
                    li_sdop.setVisibility(View.GONE);
                }
                else
                {
                    li_sdop.setVisibility(View.VISIBLE);

                }

            }
        });
        //********************************************************
        txt_exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.con);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("email", "ورود ثبت نام");
//                editor.commit();
                Intent i = new Intent(ActivitySingin.con, MainActivity.class);

              //  Intent i = new Intent(Activity_user_sign_in.this, ActivitySingin.class);
                //  i.putExtra("email", data);
                startActivity( i);

    drawrel.closeDrawer(Gravity.LEFT);
            }
        });
}



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
