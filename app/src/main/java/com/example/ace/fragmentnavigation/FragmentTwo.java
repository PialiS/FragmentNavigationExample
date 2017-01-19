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
 *
 */

public class FragmentTwo extends Fragment implements View.OnClickListener{
    Fragment mFragmentThree;
    String fragmentNameTag;
    Button clickToFragmentthree;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_two, null);
        clickToFragmentthree = (Button) root.findViewById(R.id.clickThreeButton);
        clickToFragmentthree.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        mFragmentThree=new FragmentThree();
        fragmentNameTag="FragmentThree";
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, mFragmentThree, fragmentNameTag);
        ft.addToBackStack(null);
        ft.commit();
    }
}
