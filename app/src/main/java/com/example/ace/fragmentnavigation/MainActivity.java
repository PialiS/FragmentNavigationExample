package com.example.ace.fragmentnavigation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String fragmentNameTag;
    FragmentOne mfragmentOne;
    Button clickOneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickOneButton=(Button)findViewById(R.id.clickOneButton);
        clickOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFragmentOne();
            }
        });

    }

    private void navigateToFragmentOne() {


        mfragmentOne=new FragmentOne();
        FragmentManager fragmentManager=getFragmentManager() ;
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentNameTag="FragmentOne";
        if(fragmentManager.findFragmentById(R.id.frame_container)==null){
            fragmentTransaction.replace(R.id.frame_container,mfragmentOne,fragmentNameTag);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            Toast.makeText(MainActivity.this,"Activity page",Toast.LENGTH_LONG).show();
        }
    }
}
