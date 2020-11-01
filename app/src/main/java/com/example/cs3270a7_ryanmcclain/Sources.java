package com.example.cs3270a7_ryanmcclain;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class Sources extends DialogFragment {
    View root;
    FragmentManager fm;
    private Sources.PlannedPOFragmentListener mCallBack;

    public interface PlannedPOFragmentListener {


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Sources.PlannedPOFragmentListener) {
            mCallBack = (Sources.PlannedPOFragmentListener) context;


        } else {
            throw new ClassCastException(context.toString() + "Must implement PlannedPOFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.sources, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();


    }
}