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

public class Rape extends DialogFragment {
    View root;
    FragmentManager fm;
    private Rape.RapeFragmentListener mCallBack;

    public interface RapeFragmentListener {


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Rape.RapeFragmentListener) {
            mCallBack = (Rape.RapeFragmentListener) context;


        } else {
            throw new ClassCastException(context.toString() + "Must implement RapeFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.rape_fragment, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();


    }
}