package com.fragments.codetutor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fragments.codetutor.Fragments.Fragment_one;

public class MainActivity extends AppCompatActivity {
    Button button_AddFragmet;
    TextView textView_container_text;
    public static final String ACTIVITY_NAME=MainActivity.class.getName();
    public static final String COMBINED_TAG="COMBINED_LIFECYCLE";
    public static final String TAG=ACTIVITY_NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        intializeView();
        onClickSetListner();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, ACTIVITY_NAME+" onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, ACTIVITY_NAME+" onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, ACTIVITY_NAME+" onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, ACTIVITY_NAME+"  onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, ACTIVITY_NAME+"  onDestroy: ");
    }

    

    private void intializeView(){
        button_AddFragmet=(Button)findViewById(R.id.mainActivtiy_AddButton);
        textView_container_text=(TextView) findViewById(R.id.container_text);
    }

    private void onClickSetListner(){
        button_AddFragmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_container_text.setVisibility(View.INVISIBLE);
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