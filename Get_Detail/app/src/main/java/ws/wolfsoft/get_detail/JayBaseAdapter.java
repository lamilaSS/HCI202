package ws.wolfsoft.get_detail;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class JayBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<Bean>bean;
    Typeface fonts1,fonts2;





    public JayBaseAdapter(Context context, ArrayList<Bean> bean) {


        this.context = context;
        this.bean = bean;
    }











    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/Lato-Light.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list,null);

            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.discription = (TextView)convertView.findViewById(R.id.description);
            viewHolder.date = (TextView)convertView.findViewById(R.id.date);




            viewHolder.title.setTypeface(fonts2);
            viewHolder.discription.setTypeface(fonts1);

            viewHolder.date.setTypeface(fonts2);

            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }







        Bean bean = (Bean)getItem(position);

        viewHolder.image.setImageResource(bean.getImage());
        viewHolder.title.setText(bean.getTitle());
        viewHolder.discription.setText(bean.getDiscription());
        viewHolder.date.setText(bean.getDate());








        return convertView;
    }

    private class ViewHolder{
        ImageView image;
        TextView title;
        TextView discription;
        TextView date;





    }
}




