package hp.dddd;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by hosein on 11/15/2017.
 */
public class AcyncTacksplash extends AsyncTask {
    public  String link="";
    public String email;
    public String pass;

    public AcyncTacksplash(String link) {
        this.link = link;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        try {

            URL urll=new URL(link);
            URLConnection urlConnectiou=urll.openConnection();
            urlConnectiou .setDoOutput(true);
            OutputStreamWriter os =new OutputStreamWriter(urlConnectiou.getOutputStream());
            os.flush();
            BufferedReader    buffer  =new BufferedReader(new InputStreamReader(urlConnectiou.getInputStream()));
            StringBuilder st_bul=new StringBuilder();
            String line=null;
            while ((line=buffer.readLine())!=null)
            {

                st_bul.append(line);
            }
            SplAS.timer=buffer.toString();
            MainActivity.timer=buffer.toString();
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }
}
