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

public class ImposingView extends DialogFragment {
    View root;
    FragmentManager fm;
    private ImposingView.ImposingViewFragmentListener mCallBack;

    public interface ImposingViewFragmentListener {


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ImposingView.ImposingViewFragmentListener) {
            mCallBack = (ImposingView.ImposingViewFragmentListener) context;


        } else {
            throw new ClassCastException(context.toString() + "Must implement ImposingViewFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.imposingview_fragment, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();


    }
}