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
import com.shhridoy.brandablehunt.myDataObject.Brand;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;
    ArrayList<Brand> arraylist = new ArrayList<Brand>();
    String[] name;
    Integer[] image;
    String item, brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        item = getIntent().getStringExtra("Item");
        brand = getIntent().getStringExtra("Brand");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(brand +" - "+ item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.GridViewThird);

        populatedGridView();

        for (int i=0; i<name.length; i++) {
            Brand bnd = new Brand(image[i], name[i]);
            arraylist.add(bnd);
        }

        adapter = new GridViewAdapter(this, arraylist);
        gridView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling to the "+ brand, Snackbar.LENGTH_LONG)
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

    private void populatedGridView(){
        switch (brand) {
            case "Aarong":
                switch (item) {
                    case "Shirts":
                        name = new String[]{
                                getResources().getString(R.string.aarong_man_shirts_1), getResources().getString(R.string.aarong_man_shirts_2),
                                getResources().getString(R.string.aarong_man_shirts_3), getResources().getString(R.string.aarong_man_shirts_4),
                                getResources().getString(R.string.aarong_man_shirts_5), getResources().getString(R.string.aarong_man_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_man_shirts_1, R.drawable.aarong_man_shirts_2,
                                R.drawable.aarong_man_shirts_3, R.drawable.aarong_man_shirts_4,
                                R.drawable.aarong_man_shirts_5, R.drawable.aarong_man_shirts_6
                        };
                        break;

                    case "T-Shirts":
                        name = new String[]{
                                getResources().getString(R.string.aarong_man_t_shirts_1), getResources().getString(R.string.aarong_man_t_shirts_2),
                                getResources().getString(R.string.aarong_man_t_shirts_3), getResources().getString(R.string.aarong_man_t_shirts_4),
                                getResources().getString(R.string.aarong_man_t_shirts_5), getResources().getString(R.string.aarong_man_t_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_man_t_shirts_1, R.drawable.aarong_man_t_shirts_2,
                                R.drawable.aarong_man_t_shirts_3, R.drawable.aarong_man_t_shirts_4,
                                R.drawable.aarong_man_t_shirts_5, R.drawable.aarong_man_t_shirts_6
                        };
                        break;

                    case "Fatua":
                        name = new String[]{
                                getResources().getString(R.string.aarong_men_fatua_1), getResources().getString(R.string.aarong_men_fatua_2),
                                getResources().getString(R.string.aarong_men_fatua_3), getResources().getString(R.string.aarong_men_fatua_4),
                                getResources().getString(R.string.aarong_men_fatua_5), getResources().getString(R.string.aarong_men_fatua_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_men_fatua_1, R.drawable.aarong_men_fatua_2,
                                R.drawable.aarong_men_fatua_3, R.drawable.aarong_men_fatua_4,
                                R.drawable.aarong_men_fatua_5, R.drawable.aarong_men_fatua_6
                        };
                        break;

                    case "Panjabi":
                        name = new String[]{
                                getResources().getString(R.string.aarong_men_panjabi_1), getResources().getString(R.string.aarong_men_panjabi_2),
                                getResources().getString(R.string.aarong_men_panjabi_3), getResources().getString(R.string.aarong_men_panjabi_4),
                                getResources().getString(R.string.aarong_men_panjabi_5), getResources().getString(R.string.aarong_men_panjabi_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_men_panjabi_1, R.drawable.aarong_men_panjabi_2,
                                R.drawable.aarong_men_panjabi_3, R.drawable.aarong_men_panjabi_4,
                                R.drawable.aarong_men_panjabi_5, R.drawable.aarong_men_panjabi_6
                        };
                        break;

                    case "Sharee":
                        name = new String[]{
                                getResources().getString(R.string.aarong_women_sharee_1), getResources().getString(R.string.aarong_women_sharee_2),
                                getResources().getString(R.string.aarong_women_sharee_3), getResources().getString(R.string.aarong_women_sharee_4),
                                getResources().getString(R.string.aarong_women_sharee_5), getResources().getString(R.string.aarong_women_sharee_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_women_sharee_1, R.drawable.aarong_women_sharee_2,
                                R.drawable.aarong_women_sharee_3, R.drawable.aarong_women_sharee_4,
                                R.drawable.aarong_women_sharee_5, R.drawable.aarong_women_sharee_6
                        };
                        break;

                    case "Kurta":
                        name = new String[]{
                                getResources().getString(R.string.aarong_women_kurta_1), getResources().getString(R.string.aarong_women_kurta_2),
                                getResources().getString(R.string.aarong_women_kurta_3), getResources().getString(R.string.aarong_women_kurta_4),
                                getResources().getString(R.string.aarong_women_kurta_5), getResources().getString(R.string.aarong_women_kurta_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_women_kurta_1, R.drawable.aarong_women_kurta_2,
                                R.drawable.aarong_women_kurta_3, R.drawable.aarong_women_kurta_4,
                                R.drawable.aarong_women_kurta_5, R.drawable.aarong_women_kurta_6
                        };
                        break;

                    case "Kameez":
                        name = new String[]{
                                getResources().getString(R.string.aarong_women_kamij_1), getResources().getString(R.string.aarong_women_kamij_2),
                                getResources().getString(R.string.aarong_women_kamij_3), getResources().getString(R.string.aarong_women_kamij_4),
                                getResources().getString(R.string.aarong_women_kamij_5), getResources().getString(R.string.aarong_women_kamij_6)
                        };
                        image = new Integer[]{
                                R.drawable.aarong_women_kamij_1, R.drawable.aarong_women_kamij_2,
                                R.drawable.aarong_women_kamij_3, R.drawable.aarong_women_kamij_4,
                                R.drawable.aarong_women_kamij_5, R.drawable.aarong_women_kamij_6
                        };
                        break;
                }
                break;

            case "Catseye":
                switch (item) {
                    case "Shirts":
                        name = new String[]{
                                getResources().getString(R.string.catseye_men_shirts_1), getResources().getString(R.string.catseye_men_shirts_2),
                                getResources().getString(R.string.catseye_men_shirts_3), getResources().getString(R.string.catseye_men_shirts_4),
                                getResources().getString(R.string.catseye_men_shirts_5), getResources().getString(R.string.catseye_men_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.catseye_men_shirts_1, R.drawable.catseye_men_shirts_2,
                                R.drawable.catseye_men_shirts_3, R.drawable.catseye_men_shirts_4,
                                R.drawable.catseye_men_shirts_5, R.drawable.catseye_men_shirts_6
                        };
                        break;

                    case "T-Shirts":
                        name = new String[]{
                                getResources().getString(R.string.catseye_men_t_shirts_1), getResources().getString(R.string.catseye_men_t_shirts_2),
                                getResources().getString(R.string.catseye_men_t_shirts_3), getResources().getString(R.string.catseye_men_t_shirts_4),
                                getResources().getString(R.string.catseye_men_t_shirts_5), getResources().getString(R.string.catseye_men_t_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.catseye_men_t_shirts_1, R.drawable.catseye_men_t_shirts_2,
                                R.drawable.catseye_men_t_shirts_3, R.drawable.catseye_men_t_shirts_4,
                                R.drawable.catseye_men_t_shirts_5, R.drawable.catseye_men_t_shirts_6
                        };
                        break;

                    case "Pants":
                        name = new String[]{
                                getResources().getString(R.string.catseye_men_pants_1), getResources().getString(R.string.catseye_men_pants_2),
                                getResources().getString(R.string.catseye_men_pants_3), getResources().getString(R.string.catseye_men_pants_4),
                                getResources().getString(R.string.catseye_men_pants_5), getResources().getString(R.string.catseye_men_pants_6)
                        };
                        image = new Integer[]{
                                R.drawable.catseye_men_pants_1, R.drawable.catseye_men_pants_2,
                                R.drawable.catseye_men_pants_3, R.drawable.catseye_men_pants_4,
                                R.drawable.catseye_men_pants_5, R.drawable.catseye_men_pants_6
                        };
                        break;

                    case "Tops":
                        name = new String[]{
                                getResources().getString(R.string.catseye_women_tops_1), getResources().getString(R.string.catseye_women_tops_2),
                                getResources().getString(R.string.catseye_women_tops_3), getResources().getString(R.string.catseye_women_tops_4),
                                getResources().getString(R.string.catseye_women_tops_5), getResources().getString(R.string.catseye_women_tops_6)
                        };
                        image = new Integer[]{
                                R.drawable.catseye_women_tops_1, R.drawable.catseye_women_tops_2,
                                R.drawable.catseye_women_tops_3, R.drawable.catseye_women_tops_4,
                                R.drawable.catseye_women_tops_5, R.drawable.catseye_women_tops_6
                        };
                        break;

                    case "Western Tops":
                        name = new String[]{
                                getResources().getString(R.string.catseye_women_western_top_1), getResources().getString(R.string.catseye_women_western_top_2),
                                getResources().getString(R.string.catseye_women_western_top_3), getResources().getString(R.string.catseye_women_western_top_4),
                                getResources().getString(R.string.catseye_women_western_top_5), getResources().getString(R.string.catseye_women_western_top_6)
                        };
                        image = new Integer[]{
                                R.drawable.catseye_women_western_top_1, R.drawable.catseye_women_western_top_2,
                                R.drawable.catseye_women_western_top_3, R.drawable.catseye_women_western_top_4,
                                R.drawable.catseye_women_western_top_5, R.drawable.catseye_women_western_top_6
                        };
                        break;
                }
                break;

            case "Richman":
                switch (item) {
                    case "Shirts":
                        name = new String[]{
                                getResources().getString(R.string.richman_men_shirts_1), getResources().getString(R.string.richman_men_shirts_2),
                                getResources().getString(R.string.richman_men_shirts_3), getResources().getString(R.string.richman_men_shirts_4),
                                getResources().getString(R.string.richman_men_shirts_5), getResources().getString(R.string.richman_men_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.richman_men_shirts_1, R.drawable.richman_men_shirts_2,
                                R.drawable.richman_men_shirts_3, R.drawable.richman_men_shirts_4,
                                R.drawable.richman_men_shirts_5, R.drawable.richman_men_shirts_6
                        };
                        break;

                    case "T-Shirts":
                        name = new String[]{
                                getResources().getString(R.string.richman_men_t_shirts_1), getResources().getString(R.string.richman_men_t_shirts_2),
                                getResources().getString(R.string.richman_men_t_shirts_3), getResources().getString(R.string.richman_men_t_shirts_4),
                                getResources().getString(R.string.richman_men_t_shirts_5)
                        };
                        image = new Integer[]{
                                R.drawable.richman_men_t_shirts_1, R.drawable.richman_men_t_shirts_2,
                                R.drawable.richman_men_t_shirts_3, R.drawable.richman_men_t_shirts_4,
                                R.drawable.richman_men_t_shirts_5
                        };
                        break;

                    case "Jeans":
                        name = new String[]{
                                getResources().getString(R.string.richman_men_jeans_1), getResources().getString(R.string.richman_men_jeans_2),
                                getResources().getString(R.string.richman_men_jeans_3), getResources().getString(R.string.richman_men_jeans_4),
                                getResources().getString(R.string.richman_men_jeans_5), getResources().getString(R.string.richman_men_jeans_6)
                        };
                        image = new Integer[]{
                                R.drawable.richman_men_jeans_1, R.drawable.richman_men_jeans_2,
                                R.drawable.richman_men_jeans_3, R.drawable.richman_men_jeans_4,
                                R.drawable.richman_men_jeans_5, R.drawable.richman_men_jeans_6
                        };
                        break;

                    case "Tops":
                        name = new String[]{
                                getResources().getString(R.string.richman_women_tops_1), getResources().getString(R.string.richman_women_tops_2),
                                getResources().getString(R.string.richman_women_tops_3), getResources().getString(R.string.richman_women_tops_4),
                                getResources().getString(R.string.richman_women_tops_5)
                        };
                        image = new Integer[]{
                                R.drawable.richman_women_tops_1, R.drawable.richman_women_tops_2,
                                R.drawable.richman_women_tops_3, R.drawable.richman_women_tops_4,
                                R.drawable.richman_women_tops_5
                        };
                        break;

                    case "Play Suits":
                        name = new String[]{
                                getResources().getString(R.string.richman_women_play_suits_1), getResources().getString(R.string.richman_women_play_suits_2),
                                getResources().getString(R.string.richman_women_play_suits_3), getResources().getString(R.string.richman_women_play_suits_4),
                                getResources().getString(R.string.richman_women_play_suits_5), getResources().getString(R.string.richman_women_play_suits_6)
                        };
                        image = new Integer[]{
                                R.drawable.richman_women_play_suits_1, R.drawable.richman_women_play_suits_2,
                                R.drawable.richman_women_play_suits_3, R.drawable.richman_women_play_suits_4,
                                R.drawable.richman_women_play_suits_5, R.drawable.richman_women_play_suits_6
                        };
                        break;

                    case "Ladies Jeans":
                        name = new String[]{
                                getResources().getString(R.string.richman_women_jeans_1), getResources().getString(R.string.richman_women_jeans_2),
                                getResources().getString(R.string.richman_women_jeans_3), getResources().getString(R.string.richman_women_jeans_4)
                        };
                        image = new Integer[]{
                                R.drawable.richman_women_jeans_1, R.drawable.richman_women_jeans_2,
                                R.drawable.richman_women_jeans_3, R.drawable.richman_women_jeans_4
                        };
                        break;
                }
                break;

            case "Yellow":
                switch (item) {
                    case "Shirts":
                        name = new String[]{
                                getResources().getString(R.string.yellow_men_shirts_1), getResources().getString(R.string.yellow_men_shirts_2),
                                getResources().getString(R.string.yellow_men_shirts_3), getResources().getString(R.string.yellow_men_shirts_4),
                                getResources().getString(R.string.yellow_men_shirts_5), getResources().getString(R.string.yellow_men_shirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_men_shirts_1, R.drawable.yellow_men_shirts_2,
                                R.drawable.yellow_men_shirts_3, R.drawable.yellow_men_shirts_4,
                                R.drawable.yellow_men_shirts_5, R.drawable.yellow_men_shirts_6
                        };
                        break;

                    case "T-Shirts":
                        name = new String[]{
                                getResources().getString(R.string.yellow_men_polo_tshirt_1), getResources().getString(R.string.yellow_men_polo_tshirt_2),
                                getResources().getString(R.string.yellow_men_polo_tshirt_3), getResources().getString(R.string.yellow_men_polo_tshirt_4),
                                getResources().getString(R.string.yellow_men_polo_tshirt_5)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_men_tshirts_1, R.drawable.yellow_men_tshirts_2,
                                R.drawable.yellow_men_tshirts_3, R.drawable.yellow_men_tshirts_4,
                                R.drawable.yellow_men_tshirts_5
                        };
                        break;

                    case "Panjabi":
                        name = new String[]{
                                getResources().getString(R.string.yellow_men_panjabi_1), getResources().getString(R.string.yellow_men_panjabi_2),
                                getResources().getString(R.string.yellow_men_panjabi_3), getResources().getString(R.string.yellow_men_panjabi_4),
                                getResources().getString(R.string.yellow_men_panjabi_5), getResources().getString(R.string.yellow_men_panjabi_6)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_men_panjabi_1, R.drawable.yellow_men_panjabi_2,
                                R.drawable.yellow_men_panjabi_3, R.drawable.yellow_men_panjabi_4,
                                R.drawable.yellow_men_panjabi_5, R.drawable.yellow_men_panjabi_6
                        };
                        break;

                    case "Sharee":
                        name = new String[]{
                                getResources().getString(R.string.yellow_women_sharee_1), getResources().getString(R.string.yellow_women_sharee_2),
                                getResources().getString(R.string.yellow_women_sharee_3), getResources().getString(R.string.yellow_women_sharee_4),
                                getResources().getString(R.string.yellow_women_sharee_5), getResources().getString(R.string.yellow_women_sharee_6)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_women_sharee_1, R.drawable.yellow_women_sharee_2,
                                R.drawable.yellow_women_sharee_3, R.drawable.yellow_women_sharee_4,
                                R.drawable.yellow_women_sharee_5, R.drawable.yellow_women_sharee_6
                        };
                        break;

                    case "Kameez":
                        name = new String[]{
                                getResources().getString(R.string.yellow_women_kameej_1), getResources().getString(R.string.yellow_women_kameej_2),
                                getResources().getString(R.string.yellow_women_kameej_3), getResources().getString(R.string.yellow_women_kameej_4),
                                getResources().getString(R.string.yellow_women_kameej_5), getResources().getString(R.string.yellow_women_kameej_6)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_women_kameej_1, R.drawable.yellow_women_kameej_2,
                                R.drawable.yellow_women_kameej_3, R.drawable.yellow_women_kameej_4,
                                R.drawable.yellow_women_kameej_5, R.drawable.yellow_women_kameej_6
                        };
                        break;

                    case "Palazzo and Skirts":
                        name = new String[]{
                                getResources().getString(R.string.yellow_women_palazzo_skirts_1), getResources().getString(R.string.yellow_women_palazzo_skirts_2),
                                getResources().getString(R.string.yellow_women_palazzo_skirts_3), getResources().getString(R.string.yellow_women_palazzo_skirts_4),
                                getResources().getString(R.string.yellow_women_palazzo_skirts_5), getResources().getString(R.string.yellow_women_palazzo_skirts_6)
                        };
                        image = new Integer[]{
                                R.drawable.yellow_women_palazzo_skirts_1, R.drawable.yellow_women_palazzo_skirts_2,
                                R.drawable.yellow_women_palazzo_skirts_3, R.drawable.yellow_women_palazzo_skirts_4,
                                R.drawable.yellow_women_palazzo_skirts_5, R.drawable.yellow_women_palazzo_skirts_6
                        };
                        break;
                }
                break;

            case "Dorji Bari":
                switch (item) {
                    case "Shirts":
                        name = new String[]{
                                getResources().getString(R.string.dorji_bari_men_shirts_1), getResources().getString(R.string.dorji_bari_men_shirts_2),
                                getResources().getString(R.string.dorji_bari_men_shirts_3), getResources().getString(R.string.dorji_bari_men_shirts_4),
                                getResources().getString(R.string.dorji_bari_men_shirts_5)
                        };
                        image = new Integer[]{
                                R.drawable.dorji_bari_men_shirts_1, R.drawable.dorji_bari_men_shirts_2,
                                R.drawable.dorji_bari_men_shirts_3, R.drawable.dorji_bari_men_shirts_4,
                                R.drawable.dorji_bari_men_shirts_5
                        };
                        break;

                    case "Pants":
                        name = new String[]{
                                getResources().getString(R.string.dorji_bari_men_pants_1), getResources().getString(R.string.dorji_bari_men_pants_2),
                                getResources().getString(R.string.dorji_bari_men_pants_3), getResources().getString(R.string.dorji_bari_men_pants_4),
                                getResources().getString(R.string.dorji_bari_men_pants_5)
                        };
                        image = new Integer[]{
                                R.drawable.dorji_bari_men_pants_1, R.drawable.dorji_bari_men_pants_2,
                                R.drawable.dorji_bari_men_pants_3, R.drawable.dorji_bari_men_pants_4,
                                R.drawable.dorji_bari_men_pants_5
                        };
                        break;

                    case "Panjabi and Koti":
                        name = new String[]{
                                getResources().getString(R.string.dorji_bari_men_panjabi_and_koti_1), getResources().getString(R.string.dorji_bari_men_panjabi_and_koti_2),
                                getResources().getString(R.string.dorji_bari_men_panjabi_and_koti_3), getResources().getString(R.string.dorji_bari_men_panjabi_and_koti_4),
                                getResources().getString(R.string.dorji_bari_men_panjabi_and_koti_5)
                        };
                        image = new Integer[]{
                                R.drawable.dorji_bari_panjabi_and_koti_1, R.drawable.dorji_bari_panjabi_and_koti_2,
                                R.drawable.dorji_bari_panjabi_and_koti_3, R.drawable.dorji_bari_panjabi_and_koti_4,
                                R.drawable.dorji_bari_panjabi_and_koti_5
                        };
                        break;
                }
                break;

            case "Lubnan":
                switch (item) {
                    case "Panjabi":
                        name = new String[]{
                                getResources().getString(R.string.lubnan_men_panjabi_1), getResources().getString(R.string.lubnan_men_panjabi_2),
                                getResources().getString(R.string.lubnan_men_panjabi_3), getResources().getString(R.string.lubnan_men_panjabi_4),
                                getResources().getString(R.string.lubnan_men_panjabi_5)
                        };
                        image = new Integer[]{
                                R.drawable.lubnan_men_panjabi_1, R.drawable.lubnan_men_panjabi_2,
                                R.drawable.lubnan_men_panjabi_3, R.drawable.lubnan_men_panjabi_4,
                                R.drawable.lubnan_men_panjabi_5
                        };
                        break;

                    case "Sherwani":
                        name = new String[]{
                                getResources().getString(R.string.lubnan_men_sherwani_1), getResources().getString(R.string.lubnan_men_sherwani_2),
                                getResources().getString(R.string.lubnan_men_sherwani_3), getResources().getString(R.string.lubnan_men_sherwani_4)
                        };
                        image = new Integer[]{
                                R.drawable.lubnan_men_sherwani_1, R.drawable.lubnan_men_sherwani_2,
                                R.drawable.lubnan_men_sherwani_3, R.drawable.lubnan_men_sherwani_4
                        };
                        break;

                    case "Koti":
                        name = new String[]{
                                getResources().getString(R.string.lubnan_men_koti_1), getResources().getString(R.string.lubnan_men_koti_2),
                                getResources().getString(R.string.lubnan_men_koti_3), getResources().getString(R.string.lubnan_men_koti_4)
                        };
                        image = new Integer[]{
                                R.drawable.lubnan_men_koti_1, R.drawable.lubnan_men_koti_2,
                                R.drawable.lubnan_men_koti_3, R.drawable.lubnan_men_koti_4
                        };
                        break;

                    case "Pagri":
                        name = new String[]{"", "", "", "", ""};
                        image = new Integer[]{
                                R.drawable.lubnan_men_pagri_1, R.drawable.lubnan_men_pagri_2,
                                R.drawable.lubnan_men_pagri_3, R.drawable.lubnan_men_pagri_4,
                                R.drawable.lubnan_men_pagri_5
                        };
                        break;
                }
                break;
            default:
                name = new String[]{
                        getResources().getString(R.string.grid_value1), getResources().getString(R.string.grid_value2),
                        getResources().getString(R.string.grid_value3), getResources().getString(R.string.grid_value4),
                        getResources().getString(R.string.grid_value4), getResources().getString(R.string.grid_value6)
                };

                image = new Integer[]{
                        R.drawable.images, R.drawable.images1,
                        R.drawable.images2, R.drawable.images3,
                        R.drawable.images4, R.drawable.images5
                };
        }
    }

}
