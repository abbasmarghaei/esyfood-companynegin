package hp.dddd;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AsyncTasktimrt extends AsyncTask {
    public String link="";
    public AsyncTasktimrt(String link){

        this.link=link;


    }



    @Override
    protected Object doInBackground(Object[] params) {


        try{


            URL url=new URL(link);
            URLConnection connection=url.openConnection();

            connection.setDoOutput(true);
            OutputStreamWriter os=new OutputStreamWriter(connection.getOutputStream());
            os.flush();

            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder=new StringBuilder();

            String line=null;

            while ((line=br.readLine())!=null){
                builder.append(line);
            }
            Activity_singout.data=builder.toString();

            ActivitySingin.data_s_sabt=builder.toString();
            ActivitySingin.data_s_sabt=builder.toString();
            MyLocationActivity.data=builder.toString();

        }catch (IOException e){
            e.printStackTrace();
        }

        return "";

    }
}
