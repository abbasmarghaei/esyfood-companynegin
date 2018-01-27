package hp.dddd;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by hosein on 11/15/2017.
 */
public class AcyncTackConnect extends AsyncTask {
    public  String link="";
    public String email;
    public String pass;

    public AcyncTackConnect(String link, String email, String pass) {
        this.link = link;
        this.email = email;
        this.pass = pass;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        try {
            String data= URLEncoder.encode("email","UTF8")+"="+URLEncoder.encode(email,"UTF8");
            data+="&"+URLEncoder.encode("pass","UTF8")+"="+ URLEncoder.encode(pass, "UTF8");
            URL urll=new URL(link);
            URLConnection urlConnectiou=urll.openConnection();
            urlConnectiou .setDoOutput(true);
            OutputStreamWriter os =new OutputStreamWriter(urlConnectiou.getOutputStream());
            os.write(data);
            os.flush();
            BufferedReader    buffer  =new BufferedReader(new InputStreamReader(urlConnectiou.getInputStream()));
            StringBuilder st_bul=new StringBuilder();
            String line=null;
            while ((line=buffer.readLine())!=null)
            {

                st_bul.append(line);
            }
            Activity_user_sign_in.data=buffer.toString();
            ActivitySingin.data_s=buffer.toString();
SplAS.timer=buffer.toString();
            ActivitySingin.data_s_sabt=buffer.toString();
            //data_s_sabt


        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }
}
