package hp.dddd;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hosein on 11/8/2017.
 */
public class ByMenuAdapter extends ArrayAdapter{
    public int resource;
    Activity context;
    ArrayList<ByctMenuList> object;


    public ByMenuAdapter(Activity context, int resource, ArrayList object) {
        super(context, resource,object);
        this.context=context;
        this.resource=resource;
        this.object=object;


    }

    @Nullable
    @Override
    public View getView(int position,@Nullable View convertView,@Nullable ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);
     TextView by_tatle_procuct_list = (TextView)view. findViewById(R.id.bu_tatle_procuct_list);
        ImageView by_img = (ImageView)view. findViewById(R.id.by_img);

        ByctMenuList  productMenuListt=object.get(position);
        by_tatle_procuct_list.setText(productMenuListt.tatle);
        by_img.setImageResource(productMenuListt.img);

        return (view);
    }
}
