package com.shhridoy.brandablehunt.myAdapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shhridoy.brandablehunt.R;
import com.shhridoy.brandablehunt.SecondActivity;
import com.shhridoy.brandablehunt.myDataObject.Brand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code Land on 7/31/2017.
 */

public class GridViewAdapter extends BaseAdapter{

    Context mContext;
    LayoutInflater inflater;
    private List<Brand> itemList = null;
    private ArrayList<Brand> arraylist;

    public GridViewAdapter(Context context, List<Brand> universityList) {
        mContext = context;
        this.itemList = universityList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Brand>();
        this.arraylist.addAll(universityList);
    }

    public class ViewHolder {
        TextView name;
        RelativeLayout icon;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Brand getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.grid_item, null);
            holder.name = (TextView) view.findViewById(R.id.TVGridItem);
            holder.icon = (RelativeLayout) view.findViewById(R.id.RLGrid);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(itemList.get(position).getName());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.icon.setBackground(mContext.getResources().getDrawable(itemList.get(position).getIcon()));
        }

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Intent intent = new Intent(mContext, SecondActivity.class);
                // Pass all data rank
                //intent.putExtra("name", (itemList.get(position).getName()));
                //intent.putExtra("KEY", "1");
                // Pass all data flag
                //intent.putExtra("icon", (itemList.get(position).getIcon()));
                // Start SingleItemView Class
                //mContext.startActivity(intent);
                //Toast.makeText(mContext, itemList.get(position).getName(), Toast.LENGTH_LONG).show();
                showDialog(itemList.get(position).getName(), itemList.get(position).getIcon());
            }
        });
        return view;
    }

    private void showDialog(String text, int pic){
        final Dialog myDialog = new Dialog(mContext);
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myDialog.setContentView(R.layout.dialog_view);

        ImageView img = (ImageView) myDialog.findViewById(R.id.ImageViewDialog);
        TextView tv = (TextView) myDialog.findViewById(R.id.TVDialog);

        img.setImageResource(pic);
        tv.setText(text);

        myDialog.show();
    }

}
