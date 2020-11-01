package com.example.cs3270a7_ryanmcclain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.cs3270a7_ryanmcclain.SupporterDB;

public class AboutMe extends DialogFragment {


    View root;
    FragmentManager fm;
    private AboutMe.AboutMeFragmentListener mCallBack;

    public interface AboutMeFragmentListener {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.about_me_fragment, container, false);

    }
}
