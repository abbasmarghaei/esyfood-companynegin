package hp.dddd;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class AsyncTaskConnectt extends AsyncTask {
    public String link="";
    public String email;
    public String pass;

    public AsyncTaskConnectt(String link,String email,String pass){

        this.link=link;
        this.email=email;
        this.pass=pass;

    }



    @Override
    protected Object doInBackground(Object[] params) {


        try{

            String data= URLEncoder.encode("email","UTF8")+"="+URLEncoder.encode(email,"UTF8");
            data+="&"+URLEncoder.encode("pass","UTF8")+"="+URLEncoder.encode(pass,"UTF8");

            URL url=new URL(link);
            URLConnection connection=url.openConnection();

            connection.setDoOutput(true);
            OutputStreamWriter os=new OutputStreamWriter(connection.getOutputStream());
            os.write(data);
            os.flush();

            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder=new StringBuilder();

            String line=null;

            while ((line=br.readLine())!=null){
                builder.append(line);
            }

            Activity_user_sign_in.data=builder.toString();
            ActivitySingin.data_s=builder.toString();
SplAS.timer=builder.toString();
        }catch (IOException e){
            e.printStackTrace();
        }

          return "";

    }
}
