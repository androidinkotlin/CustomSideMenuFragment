package com.elementarylogics.customsidemenufragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Windows 10 on 4/28/2016.
 */
public class SideMenu extends FragmentActivity {

    protected DrawerLayout mDrawerLayout;

    protected void initDrawerLayout(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setScrimColor(Color.parseColor("#A447C469"));
        displayView(0);
    }

    public void clickedSideMenuOption(View view){
        String option_tag=view.getTag().toString();
        if (option_tag.equalsIgnoreCase("1")){
            displayView(0);
        }else if (option_tag.equalsIgnoreCase("2")){
            displayView(1);
        }

        closeSideMenu(view);
    }
    public void closeSideMenu(View view) {
        RelativeLayout rl_slider_menu=(RelativeLayout)findViewById(R.id.rl_slider_menu);
        mDrawerLayout.closeDrawer(rl_slider_menu);
    }

    public void openSideMenu(View view) {
        RelativeLayout rl_slider_menu=(RelativeLayout)findViewById(R.id.rl_slider_menu);
        mDrawerLayout.openDrawer(rl_slider_menu);
    }

    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentOne();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
