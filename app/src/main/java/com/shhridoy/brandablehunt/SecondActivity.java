package com.shhridoy.brandablehunt;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    String[] gentsItems, ladiesItems;
    ArrayAdapter<String> adapter;
    Button btnGents, btnLadies;
    Bundle bundle;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = getIntent().getStringExtra("name");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.ListViewSecond);
        btnGents = (Button) findViewById(R.id.btnGents);
        btnLadies = (Button) findViewById(R.id.btnLadies);

        switch (name)
        {
            case "Aarong":
                gentsItems = new String[]{"Shirts", "T-Shirts", "Fatua", "Panjabi"};
                ladiesItems = new String[]{"Sharee", "Kurta", "Kameez"};
                break;
            case "Catseye":
                gentsItems = new String[]{"Shirts", "T-Shirts", "Pants"};
                ladiesItems = new String[]{"Tops", "Western Tops"};
                break;
            case "Richman":
                gentsItems = new String[]{"Shirts", "T-Shirts", "Jeans"};
                ladiesItems = new String[]{"Tops", "Play Suits", "Ladies Jeans"};
                break;
            case "Yellow":
                gentsItems = new String[]{"Shirts", "T-Shirts", "Panjabi"};
                ladiesItems = new String[]{"Sharee", "Kameez", "Palazzo and Skirts"};
                break;
            case "Dorji Bari":
                gentsItems = new String[]{"Shirts", "Pants", "Panjabi and Koti"};
                ladiesItems = new String[]{};
                break;
            case "Lubnan":
                gentsItems = new String[]{"Panjabi", "Sherwani", "Koti", "Pagri"};
                ladiesItems = new String[]{};
                break;
            default:
                gentsItems = new String[]{
                        "Shirts", "T-Shirts", "Polo T-Shrit", "Jeans", "Panjabi", "Pants and Trousers"
                };

                ladiesItems = new String[]{
                        "Salwar Kameez", "Saree", "Kurtis and Tunics", "Hijab and Scarf", "Palazzo and Leggings", "T-Shirts"
                };
        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_catagories, R.id.TVGents, gentsItems);
        listView.setAdapter(adapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            btnGents.setBackground(getResources().getDrawable(R.drawable.list_item_main_background));
            btnLadies.setBackground(getResources().getDrawable(R.drawable.btn_unselected_bg));
        }

        btnGents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new ArrayAdapter<String>(SecondActivity.this, R.layout.list_item_catagories, R.id.TVGents, gentsItems);
                listView.setAdapter(adapter);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btnGents.setBackground(getResources().getDrawable(R.drawable.list_item_main_background));
                    btnLadies.setBackground(getResources().getDrawable(R.drawable.btn_unselected_bg));
                }

            }
        });

        btnLadies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new ArrayAdapter<String>(SecondActivity.this, R.layout.list_item_catagories, R.id.TVGents, ladiesItems);
                listView.setAdapter(adapter);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btnLadies.setBackground(getResources().getDrawable(R.drawable.list_item_main_background));
                    btnGents.setBackground(getResources().getDrawable(R.drawable.btn_unselected_bg));
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("Item", adapterView.getItemAtPosition(i).toString());
                intent.putExtra("Brand", name);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
