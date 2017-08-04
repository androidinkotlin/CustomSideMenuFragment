package com.elementarylogics.customsidemenufragment;

import android.os.Bundle;

public class ActivityMain extends SideMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawerLayout();
    }


}
