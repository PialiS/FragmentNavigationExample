package com.example.ace.fragmentnavigation;

import android.app.Fragment;
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
        Fragment fragmentOne = getFragmentManager().findFragmentByTag("FragmentOne");
        Fragment fragmentTwo = getFragmentManager().findFragmentByTag("FragmentTwo");
        Fragment fragmentThree = getFragmentManager().findFragmentByTag("FragmentThree");
        Fragment fragmentFour = getFragmentManager().findFragmentByTag("FragmentFour");

        if(fragmentOne!=null && fragmentOne.isVisible()){
            getFragmentManager().popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else if(fragmentTwo!=null && fragmentTwo.isVisible()){
            getFragmentManager().beginTransaction().replace(R.id.frame_container,new FragmentOne(),"FragmentOne").addToBackStack(null).commit();
        }
        else if(fragmentThree!=null && fragmentThree.isVisible()){
            getFragmentManager().beginTransaction().replace(R.id.frame_container,new FragmentTwo(),"FragmentTwo").addToBackStack(null).commit();
        }
        else if(fragmentFour!=null && fragmentFour.isVisible()){
            getFragmentManager().beginTransaction().replace(R.id.frame_container,new FragmentThree(),"FragmentThree").addToBackStack(null).commit();
        }else{

            Toast.makeText(MainActivity.this,"Activity page",Toast.LENGTH_LONG).show();
        }

//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack();
////
//        } else {
//
//        }
    }
}
