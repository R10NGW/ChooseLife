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

public class DebatePoints extends DialogFragment  implements View.OnClickListener{
    View root;
    FragmentManager fm;
    private DebatePoints.DebatePointsFragmentListener mCallBack;

    public interface DebatePointsFragmentListener {


        void sendToRape();

        void sendToBody();

        void sendToChoice();

        void sendToGender();

        void sendToIllegalAbortion();

        void sendToImposingView();

        void sendToMen();

        void sendToCircumstances();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DebatePoints.DebatePointsFragmentListener) {
            mCallBack = (DebatePoints.DebatePointsFragmentListener) context;


        } else {
            throw new ClassCastException(context.toString() + "Must implement DebatePointsFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.debatepoints_fragment, container, false);

    }

    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.buttondpRape:
                mCallBack.sendToRape();
                break;
            case R.id.buttonDPBody:
                mCallBack.sendToBody();
                break;
            case R.id.buttonDPChoice:
                mCallBack.sendToChoice();
                break;
            case R.id.buttonDPGender:
                mCallBack.sendToGender();
                break;
            case R.id.buttonDPIllegalAportion:
                mCallBack.sendToIllegalAbortion();
                break;

            case R.id.buttonDPImposingView:
                mCallBack.sendToImposingView();
                break;
            case R.id.buttonDPMen:
                mCallBack.sendToMen();
                break;
            case R.id.buttonDPcercomstances:
                mCallBack.sendToCircumstances();
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        Button rape = (Button) root.findViewById(R.id.buttondpRape);
        rape.setOnClickListener(this);

        Button body =(Button) root.findViewById(R.id.buttonDPBody);
        body.setOnClickListener(this);

        Button choice = (Button) root.findViewById(R.id.buttonDPChoice);
        choice.setOnClickListener(this);

        Button gender =(Button) root.findViewById(R.id.buttonDPGender);
        gender.setOnClickListener(this);

        Button illegalAbortion =(Button) root.findViewById(R.id.buttonDPIllegalAportion);
        illegalAbortion.setOnClickListener(this);

        Button imposingView =(Button) root.findViewById(R.id.buttonDPImposingView);
        imposingView.setOnClickListener(this);

        Button men =(Button) root.findViewById(R.id.buttonDPMen);
        men.setOnClickListener(this);

        Button cercomstances =(Button) root.findViewById(R.id.buttonDPcercomstances);
        cercomstances.setOnClickListener(this);
    }

}