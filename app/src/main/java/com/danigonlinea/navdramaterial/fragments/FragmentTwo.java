package com.danigonlinea.navdramaterial.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danigonlinea.navdramaterial.R;

public class FragmentTwo extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.content_fragment, null);

        TextView title = (TextView) v.findViewById(R.id.title);
        title.setText("Second Fragment");

        return v;
    }
}