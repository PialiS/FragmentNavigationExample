package com.example.ace.fragmentnavigation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ACE on 26-10-2016.
 */

public class FragmentThree extends Fragment  implements View.OnClickListener {

    Fragment mFragmentFour;
    String fragmentNameTag;
    Button clickToFragmentFour;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);
        clickToFragmentFour = (Button) root.findViewById(R.id.clickToFragmentFour);
        clickToFragmentFour.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        mFragmentFour=new FragmentFour();
        fragmentNameTag="FragmentFour";
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, mFragmentFour, fragmentNameTag);
        ft.addToBackStack(null);
        ft.commit();
    }
}
