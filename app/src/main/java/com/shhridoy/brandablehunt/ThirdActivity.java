package com.shhridoy.brandablehunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.shhridoy.brandablehunt.myAdapters.GridViewAdapter;
import com.shhridoy.brandablehunt.myAdapters.ListViewAdapter;
import com.shhridoy.brandablehunt.myDataObject.Brand;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;
    ArrayList<Brand> arraylist = new ArrayList<Brand>();
    String[] name;
    Integer[] icon;
    String tag, tag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tag = getIntent().getStringExtra("Tag");
        tag2 = getIntent().getStringExtra("Tag2");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(tag2+" - "+tag);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.GridViewThird);

        name = new String[]{
                getResources().getString(R.string.grid_value1), getResources().getString(R.string.grid_value2),
                getResources().getString(R.string.grid_value3), getResources().getString(R.string.grid_value4),
                getResources().getString(R.string.grid_value4), getResources().getString(R.string.grid_value6)
        };

        icon = new Integer[] {
                R.drawable.images, R.drawable.images1,
                R.drawable.images2, R.drawable.images3,
                R.drawable.images4, R.drawable.images5
        };

        for (int i=0; i<name.length; i++) {
            Brand bnd = new Brand(icon[i], name[i]);
            arraylist.add(bnd);
        }

        adapter = new GridViewAdapter(this, arraylist);
        gridView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling to the "+tag2, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            return true;
        }
        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
