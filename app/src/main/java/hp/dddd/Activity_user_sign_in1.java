package hp.dddd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_user_sign_in1 extends AppCompatActivity {
    public static String data="";
    CheckBox  check_pass;
    public static SharedPreferences preferences;

    EditText pass,user;
    DrawerLayout drawrel;
    TextView sing_out,fa,vo;
    ImageView icon;
    ListView listPorococt,listby,listset;
    ArrayList<ProductMenuList> item;
    ArrayList<ByctMenuList> item_by;
    ArrayList<StingMenuList> item_seting;
    LinearLayout go_ti_sing_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigition_view_vo);
        //*********************************************************
        pass = (EditText) findViewById(R.id.edit_txt_passv);
        user = (EditText) findViewById(R.id.edit_txt_passvootk);
        sing_out = (TextView) findViewById(R.id.txt_sing_out);
        fa = (TextView) findViewById(R.id.far_v);
        vo = (TextView) findViewById(R.id.txt_vorood);
        //************************************************
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout_vo);
        icon = (ImageView) findViewById(R.id.icon_tool);
        go_ti_sing_in = (LinearLayout) findViewById(R.id.go_to_sing_in);
        listPorococt = (ListView) findViewById(R.id.prodoct_list);
        listset = (ListView) findViewById(R.id.seting_list);
        listby = (ListView) findViewById(R.id.by_list);
        //*************************************************
        check_pass = (CheckBox) findViewById(R.id.check_pass);
        //**************************************************
        check_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_pass.isChecked())
                {
                    pass.setRawInputType(InputType.TYPE_CLASS_TEXT);
                     Toast.makeText(getApplicationContext(), pass.getText(), Toast.LENGTH_SHORT).show();

                }

else {
                   pass.setRawInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        //*************************************************
        sing_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_user_sign_in1.this,Activity_singout.class);
                startActivity(intent);
            }
        });
        //***********************************************************************************
        go_ti_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getpass = pass.getText().toString();
                String getemail = user.getText().toString();
                new AsyncTaskConnectt("http://192.168.1.104/shop/vorood.php",getemail,getpass).execute();
             //   Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                final ProgressDialog dialog=new ProgressDialog(Activity_user_sign_in1.this);
                dialog.setMessage("لطفا منتظر بمانید...");
                dialog.show();

                final Timer timer=new Timer();
                //*************************

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (!data.equals("")){

                                    dialog.cancel();
                                    Toast.makeText(MainActivity.con,data,Toast.LENGTH_SHORT).show();
                                    if (data.equals("not exist")){
                                        Toast.makeText(MainActivity.con,"پست الکترونیکی یا کلمه عبور نادرست است",Toast.LENGTH_SHORT).show();
                                        timer.cancel();

                                    }else {

                                        Intent i = new Intent(Activity_user_sign_in1.this, Activity_singout.class);
                                        startActivity(i);
                                        timer.cancel();
                                        finish();
                                    }
                                }
                            }
                        });
                    }
                },1,1000);
            }
        });
        //**************font*****************************
        Typeface da =Typeface.createFromAsset(getAssets(),"font/da.otf");
        fa.setTypeface(da);
        pass.setTypeface(da);
        user.setTypeface(da);
        sing_out.setTypeface(da);
        vo.setTypeface(da);

        ///********************************************menu*****************
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawrel.openDrawer(Gravity.LEFT);
            }
        });
        //*******************************************************************************

        item=new ArrayList<>();
        item.add(new ProductMenuList("پیشنهاد ویره دیجی کالا"));
        item.add(new ProductMenuList("پرفوش ترین ها"));
        item.add(new ProductMenuList("جدیدترین ها"));
        item.add(new ProductMenuList("پربازدید ترینها"));
        listPorococt.setAdapter(new ProductMenuAdapter(Activity_user_sign_in1.this, R.layout.procuct_menu_list, item));
        //*******************************
        item_by=new ArrayList<>();
        item_by.add(new ByctMenuList(R.drawable.hoss, "خانه"));
        item_by.add(new ByctMenuList(R.drawable.list,"لیست دسته بندی محصولات"));
        item_by.add(new ByctMenuList(R.drawable.sa_d, "سبد کالا"));
        listby.setAdapter(new ByMenuAdapter(Activity_user_sign_in1.this, R.layout.bay_menu_list, item_by));

        //*******************************
        item_seting=new ArrayList<>();
        item_seting.add(new StingMenuList( "تنظیمات"));
        item_seting.add(new StingMenuList( "درباره ما"));
        item_seting.add(new StingMenuList( "سوالات متداول"));

        listset.setAdapter(new StingMenuAdapter(Activity_user_sign_in1.this, R.layout.seting_menu_list,item_seting));


// ***********************************************************************///

    }
}
