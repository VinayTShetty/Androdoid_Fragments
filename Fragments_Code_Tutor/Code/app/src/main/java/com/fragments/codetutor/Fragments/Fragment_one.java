package com.fragments.codetutor.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fragments.codetutor.BaserFragment.BaseFragment;
import com.fragments.codetutor.R;

public class Fragment_one extends BaseFragment {
    public static final String FRAGMENT_NAME=Fragment_one.class.getName();
    public static final String COMBINED_TAG="COMBINED_LIFECYCLE";
    public static final String TAG=FRAGMENT_NAME;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, FRAGMENT_NAME+" onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, FRAGMENT_NAME+" onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, FRAGMENT_NAME+" onCreateView: ");
        return inflater.inflate(R.layout.fragment_one,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, FRAGMENT_NAME+" onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, FRAGMENT_NAME+" onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, FRAGMENT_NAME+" onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, FRAGMENT_NAME+" onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, FRAGMENT_NAME+" onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, FRAGMENT_NAME+" onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, FRAGMENT_NAME+" onDetach: ");
    }
}
