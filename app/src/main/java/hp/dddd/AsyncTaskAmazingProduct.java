package hp.dddd;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by MOHAMMAD on 9/24/2017.
 */

public class AsyncTaskAmazingProduct extends AsyncTask {


    public String link="";


    public AsyncTaskAmazingProduct(String link){

        this.link=link;


    }



    @Override
    protected Object doInBackground(Object[] params) {


        try{



            URL url=new URL(link);
            URLConnection connection=url.openConnection();


            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder=new StringBuilder();

            String line=null;

            while ((line=br.readLine())!=null){
                builder.append(line);
            }

            Splashh.kadrr=builder.toString();

        }catch (IOException e){
            e.printStackTrace();
        }

        return "";

    }
}
