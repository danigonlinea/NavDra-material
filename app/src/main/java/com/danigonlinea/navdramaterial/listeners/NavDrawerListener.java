package com.danigonlinea.navdramaterial.listeners;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.danigonlinea.navdramaterial.R;
import com.danigonlinea.navdramaterial.fragments.FragmentFive;
import com.danigonlinea.navdramaterial.fragments.FragmentFour;
import com.danigonlinea.navdramaterial.fragments.FragmentOne;
import com.danigonlinea.navdramaterial.fragments.FragmentThree;
import com.danigonlinea.navdramaterial.fragments.FragmentTwo;

import java.lang.ref.WeakReference;


public class NavDrawerListener implements  ListView.OnItemClickListener{

    WeakReference<DrawerLayout> mDrawerLayout;
    android.app.FragmentManager fm;
    private Context ctx;

    public NavDrawerListener(Context ctx, WeakReference<DrawerLayout> mDrawerLayout, android.app.FragmentManager fm)
    {
        this.mDrawerLayout = mDrawerLayout;
        this.fm = fm;
        this.ctx = ctx;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayView(position);
    }

    private void displayView(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentOne();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
            case 3:
                fragment = new FragmentFour();
                break;
            case 4:
                fragment = new FragmentFive();
                break;
            default:
                break;
        }

        if (fragment != null) {
            fm.beginTransaction().replace(R.id.frame_container, fragment).commit();

            mDrawerLayout.get().closeDrawers();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}
