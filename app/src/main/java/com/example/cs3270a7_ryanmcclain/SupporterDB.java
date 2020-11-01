package com.example.cs3270a7_ryanmcclain;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.cs3270a7_ryanmcclain.db.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class SupporterDB extends DialogFragment {

    View root;
    FragmentManager fm;
    private SupporterDB.SupporterDBFragmentListener mCallBack;

    public interface SupporterDBFragmentListener {
        void createNewSupporter();

        void setString2();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SupporterDB.SupporterDBFragmentListener){
            mCallBack = (SupporterDB.SupporterDBFragmentListener) context;


        }else{
            throw new ClassCastException(context.toString() + "Must implement SupporterDBFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.supporterdb_fragment, container, false);
        mCallBack.setString2();
        FloatingActionButton fab = root.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.createNewSupporter();
 //               fm.beginTransaction()
//                        .add(android.R.id.content,new NewCourseDialogFragment())
//                        .addToBackStack(null)
//                        .commit();
            }
        });

        return root;
    }

    public void newSupporter(){

    }




}
