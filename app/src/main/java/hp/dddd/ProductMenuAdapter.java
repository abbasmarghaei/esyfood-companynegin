package hp.dddd;

        import android.app.Activity;
        import android.content.Context;
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
public class ProductMenuAdapter extends ArrayAdapter{
    public int resource;
    Activity context;
    ArrayList<ProductMenuList> object;
    public ProductMenuAdapter(Activity context, int resource,ArrayList object) {
        super(context, resource,object);
        this.context=context;
        this.resource=resource;
        this.object=object;


    }

    @Nullable
    @Override
    public View getView(int position,@Nullable View convertView,@Nullable ViewGroup parent) {
        View view=this.context.getLayoutInflater().inflate(this.resource,null);
        TextView tatle_procuct_list = (TextView)view. findViewById(R.id.tatle_procuct_list);
        ProductMenuList  productMenuList=object.get(position);
        tatle_procuct_list.setText(productMenuList.tatle);

        return (view);
    }
}
