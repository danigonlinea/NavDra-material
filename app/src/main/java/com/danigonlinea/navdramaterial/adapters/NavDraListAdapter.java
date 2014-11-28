package com.danigonlinea.navdramaterial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.danigonlinea.navdramaterial.R;
import com.danigonlinea.navdramaterial.model.NavDraItem;

import java.util.ArrayList;


public class NavDraListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<NavDraItem> navDrawerItems;
    private LayoutInflater mInflater;

    static class ViewHolder{
        ImageView icon_item;
        TextView name_item;
    }

    public NavDraListAdapter(Context context, ArrayList<NavDraItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View fila = convertView;
        ViewHolder holder = null;

        if (fila == null) {
            holder = new ViewHolder();
            fila = mInflater.inflate(R.layout.dranav_item_list, parent, false);

            holder.icon_item = (ImageView) fila.findViewById(R.id.icon);
            holder.name_item = (TextView) fila.findViewById(R.id.option);

            fila.setTag(holder);
        }
        else
            holder = (ViewHolder) fila.getTag();

        NavDraItem currentItem = navDrawerItems.get(position);

        if (currentItem != null )
        {
            holder.icon_item.setImageResource(currentItem.getIcon());
            holder.name_item.setText(currentItem.getTitle());
        }

        return fila;
    }
}
