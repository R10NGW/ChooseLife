package com.example.cs3270a7_ryanmcclain;

import android.content.Context;
import android.widget.Button;
import android.widget.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class video extends DialogFragment{
    View root;
    FragmentManager fm;
    private video.VideoFragmentListener mCallBack;
    public interface VideoFragmentListener {
    void playVideo();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof video.VideoFragmentListener){
            mCallBack = (video.VideoFragmentListener) context;


        }else{
            throw new ClassCastException(context.toString() + "Must implement VideoFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.video_fragment, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();
        Button video = root.findViewById(R.id.buttonPlay);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.playVideo();
            }
        });

    }





}
