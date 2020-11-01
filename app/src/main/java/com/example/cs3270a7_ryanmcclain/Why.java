package com.example.cs3270a7_ryanmcclain;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class Why extends DialogFragment {
    View root;
    FragmentManager fm;
    private Why.WhyFragmentListener mCallBack;

    public interface WhyFragmentListener {
        void toToppics();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Why.WhyFragmentListener) {
            mCallBack = (Why.WhyFragmentListener) context;


        } else {
            throw new ClassCastException(context.toString() + "Must implement WhyFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.why_fragment, container, false);


    }
    public void onBackPressed() {
        mCallBack.toToppics();
    }

    @Override
    public void onResume() {
        super.onResume();


    }



}