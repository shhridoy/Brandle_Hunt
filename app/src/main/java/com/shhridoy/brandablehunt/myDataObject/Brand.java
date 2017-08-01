package com.shhridoy.brandablehunt.myDataObject;

/**
 * Created by Code Land on 7/30/2017.
 */

public class Brand {
    private String name;
    private int icon;


    public Brand (int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
