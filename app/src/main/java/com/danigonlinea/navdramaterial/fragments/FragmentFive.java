package com.danigonlinea.navdramaterial.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danigonlinea.navdramaterial.R;

public class FragmentFive extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.content_fragment, null);

        TextView title = (TextView) v.findViewById(R.id.title);
        title.setText("Fifth Fragment");

        return v;
    }
}