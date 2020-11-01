package com.example.cs3270a7_ryanmcclain;
import android.app.AlertDialog;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs3270a7_ryanmcclain.db.AppDatabase;
import com.example.cs3270a7_ryanmcclain.db.Course;


public class deleteDialog extends DialogFragment
{
    private deleteDialogFragmentListener mCallBack;
    Course course;
    boolean confirmDelete;


    public interface deleteDialogFragmentListener{
        void sendDelete(boolean b);

        Course getItemToDelete();
    }

    public deleteDialog() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof deleteDialog.deleteDialogFragmentListener){
            mCallBack = (deleteDialog.deleteDialogFragmentListener) context;

        }else{
            throw new ClassCastException(context.toString() + "Must implement deleteDialogFragmentListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_dialog, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you want to delete?");
        builder.setTitle("Delete?");
        builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        course = mCallBack.getItemToDelete();
                        AppDatabase.getInstance(getContext())
                                .courseDAO()
                                .delete(course);
                    }
                }).start();


            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //     confirmDelete = false;
                //  mCallBack.sendDelete(confirmDelete);
            }
        });
        //creates dialog box wont do anything until you call from main
        return builder.create();
    }



}
