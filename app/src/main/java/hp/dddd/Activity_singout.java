package hp.dddd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_singout extends AppCompatActivity {
    TextView sing_outt,sing_out,sabt;
    EditText pass,user,pass_tk;
    public static String data="";
    DrawerLayout drawrel;
    ImageView icon;
    LinearLayout sabtt;
    ArrayList<ProductMenuList> item;
    ArrayList<ByctMenuList> item_by;
    ArrayList<StingMenuList> item_seting;
    ListView listPorococt,listby,listset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.navigition_view_sabt);
        //**************************************************
        sing_outt = (TextView) findViewById(R.id.ozv);
        sing_out = (TextView) findViewById(R.id.txt_sing_out);
        sabt = (TextView) findViewById(R.id.sabt);
        sabtt = (LinearLayout) findViewById(R.id.sabttt);
        //****************9*9**************************9
        pass = (EditText) findViewById(R.id.edit_txt_mailevoo);
        pass_tk = (EditText) findViewById(R.id.edit_txt_mailevoo1);
        user = (EditText) findViewById(R.id.edit_txt_passvootk);
        //*****************************************************
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout);
        listPorococt = (ListView) findViewById(R.id.prodoct_list);
        listset = (ListView) findViewById(R.id.seting_list);
        listby = (ListView) findViewById(R.id.by_list);
//*/**********************************************************6
        drawrel = (DrawerLayout) findViewById(R.id.drawerlayout_sabt);
        icon = (ImageView) findViewById(R.id.icon_tool);
        //***************************************************************
        Typeface batnvis =Typeface.createFromAsset(getAssets(),"font/za.ttf");
        Typeface ka =Typeface.createFromAsset(getAssets(),"font/ka.ttf");
        Typeface da =Typeface.createFromAsset(getAssets(),"font/da.otf");

        //***************************************************************
        sing_outt.setTypeface(da);
        sing_out.setTypeface(da);
        sabt.setTypeface(da);
        pass.setTypeface(da);
        user.setTypeface(da);
        //**************************************************************
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawrel.openDrawer(Gravity.LEFT);

            }
        });
        //*****************************************************************
        sabtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();
             String us=user.getText().toString();
                String ps=pass.getText().toString();
                String tkps=pass_tk.getText().toString();
                if (tkps.length()<3)
                {
                    Toast.makeText(getApplicationContext(),"نام کاربری شما باید بیشتراز 3حرف باشد", Toast.LENGTH_SHORT).show();

                }
                else
                {


                if (ps.length()<3)
                {
                    Toast.makeText(getApplicationContext(),"پس وورد  باید بیتراز 4 حرف باشد", Toast.LENGTH_SHORT).show();

                }
                else
                {


                if (us.equals(ps)) {
                    new AsyncTaskInsertUp("http://hpph12.cloudsite.ir/dgkala/inse.php", tkps, ps).execute();
                    //***************************************************************************
                    final ProgressDialog dialog=new ProgressDialog(Activity_singout.this);
                    dialog.setMessage("لطفا منتظر بمانید...");
                    dialog.show();

                    final Timer timer=new Timer();
                    //*************************
                    //  /*
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (!data.equals("")){
                                        if (data.equals("no")) {
                                            Toast.makeText(MainActivity.con, "ایمیل شما قبلا ثبت شده است", Toast.LENGTH_SHORT).show();
                                        }
                                        else if (data.equals("not")) {
                                            Toast.makeText(MainActivity.con, "اینترنت شما قط شده", Toast.LENGTH_SHORT).show();
                                        }

                                        else
                                        {



                                            Intent i = new Intent(Activity_singout.this, ActivitySingin.class);
                                            //  i.putExtra("email", data);
                                            startActivity(i);
                                            timer.cancel();

                                        }
                                    }
                                    else {

                                        // Toast.makeText(MainActivity.con,"gjj",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    },1,1000);
                    //*****************************************************************************
                }
                else {


                    Toast.makeText(getApplicationContext(),"تگرار پس غلطه", Toast.LENGTH_SHORT).show();

                }
                }
                }
//*************************************************************************************

// ****************************************************************************************
            }


        });
        //*****************************************************************
//*******************************************************************************

        item=new ArrayList<>();
        item.add(new ProductMenuList("پیشنهاد ویره دیجی کالا"));
        item.add(new ProductMenuList("پرفوش ترین ها"));
        item.add(new ProductMenuList("جدیدترین ها"));
        item.add(new ProductMenuList("پربازدید ترینها"));
        listPorococt.setAdapter(new ProductMenuAdapter(Activity_singout.this, R.layout.procuct_menu_list, item));
        //*******************************
        item_by=new ArrayList<>();
        item_by.add(new ByctMenuList(R.drawable.hoss, "خانه"));
        item_by.add(new ByctMenuList(R.drawable.list,"لیست دسته بندی محصولات"));
        item_by.add(new ByctMenuList(R.drawable.sa_d, "سبد کالا"));
        listby.setAdapter(new ByMenuAdapter(Activity_singout.this, R.layout.bay_menu_list, item_by));

        //*******************************
        item_seting=new ArrayList<>();
        item_seting.add(new StingMenuList( "تنظیمات"));
        item_seting.add(new StingMenuList( "درباره ما"));
        item_seting.add(new StingMenuList( "سوالات متداول"));

        listset.setAdapter(new StingMenuAdapter(Activity_singout.this, R.layout.seting_menu_list,item_seting));


// ***********************************************************************///
    }
}
