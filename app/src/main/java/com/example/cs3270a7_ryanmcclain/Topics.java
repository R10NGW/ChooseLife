package com.example.cs3270a7_ryanmcclain;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Topics extends DialogFragment implements View.OnClickListener {


    View root;
    FragmentManager fm;
    private Topics.TopicsFragmentListener mCallBack;



    public interface TopicsFragmentListener {
        void sendToVideo();

        void sendTowhy();

        void sendToScience();

        void sendToOperation();

        void sendToLaws();

        void sendToStats();

        void sendToDebatePoints();

        void sendToPlannedPC();

        void sendToPlannedPO();

        void sendToDevelopment();

        void sendToHelp();

        void sendToTemp();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Topics.TopicsFragmentListener){
            mCallBack = (Topics.TopicsFragmentListener) context;


        }else{
            throw new ClassCastException(context.toString() + "Must implement TopicsFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return root = inflater.inflate(R.layout.toppics_fragment, container, false);

    }

    @Override
    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.buttonWhy:
                mCallBack.sendTowhy();
                break;
            case R.id.buttonVideo:
                mCallBack.sendToVideo();
                break;
            case R.id.buttonScience:
                mCallBack.sendToScience();
                break;
            case R.id.buttonOperation:
                mCallBack.sendToOperation();
                break;
            case R.id.buttonLaws:
                mCallBack.sendToLaws();
                break;

            case R.id.buttonStats:
                mCallBack.sendToStats();
                break;
            case R.id.buttonDebatePoints:
                mCallBack.sendToDebatePoints();
                break;
            case R.id.buttonPlannedP:
                mCallBack.sendToPlannedPC();
                break;
            case R.id.buttonSources:
                mCallBack.sendToPlannedPO();
                break;
            case R.id.buttonDevelopment:
                mCallBack.sendToDevelopment();
                break;
            case R.id.buttonHowToHelp:
                mCallBack.sendToHelp();
                break;
            case R.id.buttonTemp:
                mCallBack.sendToTemp();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Button why = (Button) root.findViewById(R.id.buttonWhy);
        why.setOnClickListener(this);

        Button video =(Button) root.findViewById(R.id.buttonVideo);
        video.setOnClickListener(this);

        Button operation = (Button) root.findViewById(R.id.buttonOperation);
        operation.setOnClickListener(this);

        Button laws =(Button) root.findViewById(R.id.buttonLaws);
        laws.setOnClickListener(this);

        Button science =(Button) root.findViewById(R.id.buttonScience);
        science.setOnClickListener(this);

        Button stats =(Button) root.findViewById(R.id.buttonStats);
        stats.setOnClickListener(this);

        Button debatePoints =(Button) root.findViewById(R.id.buttonDebatePoints);
        debatePoints.setOnClickListener(this);

        Button plannedPC =(Button) root.findViewById(R.id.buttonPlannedP);
        plannedPC.setOnClickListener(this);

        Button plannedPO =(Button) root.findViewById(R.id.buttonSources);
        plannedPO.setOnClickListener(this);

        Button development =(Button) root.findViewById(R.id.buttonDevelopment);
        development.setOnClickListener(this);

        Button help =(Button) root.findViewById(R.id.buttonHowToHelp);
        help.setOnClickListener(this);

        Button temp =(Button) root.findViewById(R.id.buttonTemp);
        temp.setOnClickListener(this);

    }


}
