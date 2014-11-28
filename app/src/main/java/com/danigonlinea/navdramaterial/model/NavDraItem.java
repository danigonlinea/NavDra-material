package com.danigonlinea.navdramaterial.model;


import com.danigonlinea.navdramaterial.R;

public class NavDraItem {

    private String title;
    private int icon;
    private int defaultIcon = R.drawable.ic_launcher;

    public NavDraItem(String title){
        this.title = title;
        icon = defaultIcon;
    }
    public NavDraItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }
}
