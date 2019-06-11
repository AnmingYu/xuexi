package com.example.administrator.myapplication.uiWidgetTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter( Context context, int resource,List<Fruit> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
             view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
             viewHolder=new ViewHolder();
             viewHolder.fruitImage=view.findViewById(R.id.fruit_image);
             viewHolder.fruitName=view.findViewById(R.id.fruit_name);
             view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
