package com.fragments.codetutor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fragments.codetutor.Fragments.Fragment_Three;
import com.fragments.codetutor.Fragments.Fragment_one;
import com.fragments.codetutor.Fragments.Fragment_two;
import com.fragments.codetutor.Fragments.SampleFragment;

public class MainActivity extends AppCompatActivity  {
    Button button_AddFragmet,button_popStackFragment,button_replace;
    TextView textView_container_text,textView_backStactEntryCount;
    public static final String ACTIVITY_NAME=MainActivity.class.getSimpleName();
    public static final String COMBINED_TAG="COMBINED_LIFECYCLE";
    public static final String TAG=ACTIVITY_NAME;//ACTIVITY_NAME;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, ACTIVITY_NAME+" onCreate: ");
        intializeView();
       onClickSetListner();
        intilazieFragmentManager();
        fragmentBackStackEntry_Count_TextView();
        backStackChange_Listner();
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
        /**
         * Buttons
         */
        button_AddFragmet=(Button)findViewById(R.id.mainActivtiy_AddButton);
        button_popStackFragment=(Button)findViewById(R.id.mainActivtiy_popBackStack);
        button_replace=(Button)findViewById(R.id.mainActivtiy_replace);
        /**
         * TextViews
         */
        textView_container_text=(TextView) findViewById(R.id.container_text);
        textView_backStactEntryCount=(TextView) findViewById(R.id.backStactEntryCount_textview);
    }

    private void onClickSetListner(){
        button_AddFragmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDifferentFragment();
            }
        });

        button_popStackFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    fragmentManager.findFragmentById(R.id.mainActivity_container);
                    fragmentManager.popBackStack();
            }
        });

        button_replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fragmentManager.findFragmentById(R.id.mainActivity_container);
                if(fragment!=null){
                    fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.mainActivity_container,fragment);
                    fragmentTransaction.addToBackStack("Replace "+fragment.toString());
                    fragmentTransaction.commit();
                }
            }
        });
    }
    private void addFragment(){
        Fragment fragment;
        switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new Fragment_one(); break;
            case 1: fragment = new Fragment_two();break;
            case 2: fragment = new Fragment_Three(); break;
            default: fragment = new SampleFragment(); break;
        }
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainActivity_container,fragment,fragment.toString());
      //  fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }



    private void intilazieFragmentManager(){
        fragmentManager=getSupportFragmentManager();
    }

    private void fragmentBackStackEntry_Count_TextView(){
        textView_backStactEntryCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());
    }
    private void backStackChange_Listner(){
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textView_backStactEntryCount.setText("Fragment count in back stack: "+fragmentManager.getBackStackEntryCount());
                StringBuilder backStackEntry_Message=new StringBuilder("Current Status of the Fragment Transaction Back Stack "+fragmentManager.getBackStackEntryCount()+"\n");
                for(int index=(fragmentManager.getBackStackEntryCount()-1); index>=0; index--){
                    FragmentManager.BackStackEntry entry =  fragmentManager.getBackStackEntryAt(index);
                    backStackEntry_Message.append(entry.getName()+"\n");
                }
                Log.i(TAG,backStackEntry_Message.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private void addDifferentFragment(){
        Fragment fragment;
        fragment=fragmentManager.findFragmentById(R.id.mainActivity_container);
        if(fragment instanceof  Fragment_one){
            fragment=new Fragment_two();
        }else if(fragment instanceof  Fragment_two){
            fragment=new Fragment_Three();
        }else if(fragment instanceof  Fragment_Three){
            fragment=new SampleFragment();
        }else if(fragment instanceof SampleFragment){
            fragment=new Fragment_one();
        }else {
            fragment=new SampleFragment();
        }
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainActivity_container,fragment,fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack("Add "+fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}