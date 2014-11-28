package com.danigonlinea.navdramaterial.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.danigonlinea.navdramaterial.listeners.NavDrawerListener;
import com.danigonlinea.navdramaterial.R;
import com.danigonlinea.navdramaterial.adapters.NavDraListAdapter;
import com.danigonlinea.navdramaterial.fragments.FragmentOne;
import com.danigonlinea.navdramaterial.model.NavDraItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class Main extends ActionBarActivity {

    android.support.v7.widget.Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setSupportActionBar(mToolbar);
        mDrawerToggle= new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        String[] nameoptionList = getResources().getStringArray(R.array.nav_drawer_items);

        // If you want to apply different icon for items, use the other constructor for NavDraItem.
        ArrayList<NavDraItem> navDrawerItems = new ArrayList<NavDraItem>();
        for (int i = 0 ; i < nameoptionList.length ; i++){
            navDrawerItems.add(new NavDraItem(nameoptionList[i]));
        }

        NavDraListAdapter adapter = new NavDraListAdapter(getApplicationContext(),navDrawerItems);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new NavDrawerListener(getApplicationContext(),
                                                                new WeakReference<DrawerLayout>(mDrawerLayout),
                                                                getFragmentManager()));
        // Init First Container by default
        getFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentOne()).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.START|Gravity.LEFT)){
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}
