package com.shhridoy.brandablehunt;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shhridoy.brandablehunt.myAdapters.ListViewAdapter;
import com.shhridoy.brandablehunt.myDataObject.Brand;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    ArrayList<Brand> arraylist = new ArrayList<Brand>();
    String[] name;
    Integer[] icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.ListViewMain);

        name = new String[]{
                "Aarong", "Catseye", "Richman", "Yellow", "Lubnan", "Ecstasy", "Infinity",
                "Artisti", "Vasavi", "Dorji Bari", "Zatra", "Westics", "Kay kraft"
        };

        icon = new Integer[] {
                R.drawable.aarong_logo, R.drawable.catseye_logo, R.drawable.richman_logg, R.drawable.yellow_logo, R.drawable.lubnan_logo,
                R.drawable.ecstasy_logo, R.drawable.infinity_logo, R.drawable.artisti_logo, R.drawable.vasavi_logo,
                R.drawable.dorji_bari_logo, R.drawable.jatra_logo, R.drawable.westics_logo, R.drawable.kaykraft_logo
        };

        for (int i=0; i<name.length; i++) {
            Brand bnd = new Brand(icon[i], name[i]);
            arraylist.add(bnd);
        }

        adapter = new ListViewAdapter(this, arraylist);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Dialog myDialog = new Dialog(this);
            myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            myDialog.setContentView(R.layout.dialog_about);
            TextView textView = (TextView) myDialog.findViewById(R.id.tvDevelperText2);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            myDialog.show();
            return true;
        }
        else if (id == R.id.menu_item_search){

            SearchView searchView = (SearchView) item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    adapter.filter(newText);
                    return false;
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
