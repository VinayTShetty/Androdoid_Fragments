package com.fragments.codetutor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fragments.codetutor.Fragments.Fragment_one;

public class MainActivity extends AppCompatActivity {
    Button button_AddFragmet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeView();
        onClickSetListner();
    }

    private void intializeView(){
        button_AddFragmet=(Button)findViewById(R.id.mainActivtiy_AddButton);
    }

    private void onClickSetListner(){
        button_AddFragmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
    }

    private void addFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        Fragment_one fragment_one=new Fragment_one();
        fragmentTransaction.add(R.id.mainActivity_container,fragment_one);
        fragmentTransaction.commit();
    }
}