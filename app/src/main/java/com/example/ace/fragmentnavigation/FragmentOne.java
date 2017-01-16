package com.example.ace.fragmentnavigation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ACE on 26-10-2016.
 */

public class FragmentOne extends Fragment implements View.OnClickListener{
    Button clickToFragmenttwo;
    Fragment mFragmentTwo;
    String fragmentNameTag;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_one, null);
        clickToFragmenttwo = (Button) root.findViewById(R.id.clickTwoButton);
        clickToFragmenttwo.setOnClickListener(this);
        return root;



    }


    @Override
    public void onClick(View view) {
        mFragmentTwo=new FragmentTwo();
        fragmentNameTag="FragmentTwo";
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container,mFragmentTwo, fragmentNameTag);
        ft.addToBackStack(null);
        ft.commit();

    }
}
