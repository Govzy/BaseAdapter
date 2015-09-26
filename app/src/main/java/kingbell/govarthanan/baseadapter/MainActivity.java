package kingbell.govarthanan.baseadapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {


    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new CustAdapter(this));

    }


}
class SingleRow
{
    String  title1;
    String description1;
    int image1;
    SingleRow(String title, String description, int image)
    {
        this.title1 = title;
        this.description1=description;
        this.image1 = image;

    }
}

class CustAdapter extends BaseAdapter
{
    ArrayList<SingleRow> list;
    Context context;
    CustAdapter(Context c)
    {
        context =c;
        list = new ArrayList<SingleRow>();
        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.title);
        String[] descriptions = res.getStringArray(R.array.description);
        int [] images ={
                R.drawable.awe,
                R.drawable.eng,
                R.drawable.fb,
                R.drawable.hang,
                R.drawable.home,
                R.drawable.html,
                R.drawable.life,
                R.drawable.light,
                R.drawable.mil,
                R.drawable.pim,
                R.drawable.pop,
                R.drawable.sett,
                R.drawable.smil,
                R.drawable.some,
                R.drawable.wind};
        for (int i =0; i<15;i++)
        {
            list.add(new SingleRow(titles[i],descriptions[i],images[i]));
        }

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.singlerow,parent,false);

        TextView title = (TextView) row.findViewById(R.id.textView);
        TextView description = (TextView) row.findViewById(R.id.textView2);
        ImageView image = (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp = list.get(position);

        title.setText(temp.title1);
        description.setText(temp.description1);
        image.setImageResource(temp.image1);
        return row;
    }
}