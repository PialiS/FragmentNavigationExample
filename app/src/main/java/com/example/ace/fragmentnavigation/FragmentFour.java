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
 * Created by ACE on 17-01-2017.
 */

public class FragmentFour extends Fragment implements View.OnClickListener {

    Button fragmentTwoButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_four, null);
        fragmentTwoButton=(Button)view.findViewById(R.id.button_fragment_two);
        fragmentTwoButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentTwo newFragmentTwo=new FragmentTwo();
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,newFragmentTwo);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
