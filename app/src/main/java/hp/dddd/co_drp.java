package hp.dddd;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class co_drp   implements AdapterView.OnItemSelectedListener {
    public static String[] itemcitit,itemcitie ;
    public static String ttt;




    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {
        //Toast.makeText(parent.getContext(),MainActivity.items[1]+ parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
        if (parent.getItemAtPosition(pos).toString().equals(MainActivity.items[1]))
        {
            Toast.makeText(parent.getContext(), MainActivity.items[1] + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();


            itemcitit = new String[]{"تهران", "شهریار", "اسلامشهر","بهارستان", "ملارد","ری", "قدس",
                    "رباط کریم","ورامین", "پردیس","دماوند", "قرچک", "پیشوا","شمیرانات", "فیروزکوه"};

            ttt="t";
            Toast.makeText(parent.getContext(), "fff" + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
        }
        else if (parent.getItemAtPosition(pos).toString().equals(MainActivity.items[2]))
        {

            itemcitie =  new String[]{"اصفهان", "کاشان", "خمینی شهر ","نجف آباد", "شاهین شهر", "شهرضا ","شهرضا", "تیران",
                    "فولادشهر ","مبارکه", "بهارستان ","آران و بیدگل", "زرین شهر", "گلپایگان ","فریدون شهر", "درچه",
                    "چادگان ","فلاورجان", "دولت آباد", " قهدریجان","نایین", "سمیرم", "سمیرم","کلیشاد و سودرجان",
                    "گل دشت", "خورزوق","ابریشم","خوانسار", "گز", "نطنز ","باغ بهادران", "دامنه", "اصغرآباد"};
            ttt="s";

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
