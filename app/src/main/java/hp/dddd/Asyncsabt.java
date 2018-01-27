package hp.dddd;


import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Asyncsabt extends AsyncTask {
    public String link="";
    public String nam;
    public String namk;
    public double latt;
    public double lon;
    public static String lat;
    public String tel;

    ;

    public Asyncsabt(String link, String nam, String namkk,String tell,double lat,double lan){

        this.link=link;
        this.nam=nam;
        this.namk=namkk;
        this.tel=tell;
        this.latt=lat;
        this.lon=lan;

    }
    public Asyncsabt(String link, String nam, String namkk,String tell,String lott){

        this.link=link;
        this.nam=nam;
        this.namk=namkk;
        this.tel=tell;
        this.lat=lott;
    }
    public Asyncsabt(String link, String nam, String namkk,String tell){

        this.link=link;
        this.nam=nam;
        this.namk=namkk;
        this.tel=tell;

    }



    @Override
    protected Object doInBackground(Object[] params) {


        try{

            String data= URLEncoder.encode("email","UTF8")+"="+URLEncoder.encode(nam,"UTF8");
            data+="&"+URLEncoder.encode("pass","UTF8")+"="+URLEncoder.encode(namk,"UTF8");
            data+="&"+URLEncoder.encode("tell","UTF8")+"="+URLEncoder.encode(tel,"UTF8");
            data+="&"+URLEncoder.encode("lat","UTF8")+"="+URLEncoder.encode(String.valueOf(latt),"UTF8");
            data+="&"+URLEncoder.encode("lan","UTF8")+"="+URLEncoder.encode(String.valueOf(lon),"UTF8");


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
            Activity_singout.data=builder.toString();


            sabt_ratooran_b_n.data=builder.toString();

        }catch (IOException e){
            e.printStackTrace();
        }

        return "";

    }
}
