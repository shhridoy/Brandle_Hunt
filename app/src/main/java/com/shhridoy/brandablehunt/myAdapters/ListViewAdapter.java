package com.shhridoy.brandablehunt.myAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shhridoy.brandablehunt.R;
import com.shhridoy.brandablehunt.SecondActivity;
import com.shhridoy.brandablehunt.myDataObject.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Code Land on 7/30/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Brand> brandList = null;
    private ArrayList<Brand> arraylist;

    public ListViewAdapter(Context context, List<Brand> universityList) {
        mContext = context;
        this.brandList = universityList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Brand>();
        this.arraylist.addAll(universityList);
    }

    public class ViewHolder {
        TextView name;
        ImageView icon;
    }

    @Override
    public int getCount() {
        return brandList.size();
    }

    @Override
    public Brand getItem(int position) {
        return brandList.get(position);
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
            view = inflater.inflate(R.layout.list_item_main, null);
            holder.name = (TextView) view.findViewById(R.id.textViewList);
            holder.icon = (ImageView) view.findViewById(R.id.ImageViewList);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(brandList.get(position).getName());
        holder.icon.setImageResource(brandList.get(position).getIcon());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, SecondActivity.class);
                intent.putExtra("name", (brandList.get(position).getName()));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        brandList.clear();
        if (charText.length() == 0) {
            brandList.addAll(arraylist);
        }
        else {
            for (Brand wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    brandList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}

