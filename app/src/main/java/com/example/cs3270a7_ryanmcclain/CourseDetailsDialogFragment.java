package com.example.cs3270a7_ryanmcclain;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.cs3270a7_ryanmcclain.db.AppDatabase;
import com.example.cs3270a7_ryanmcclain.db.Course;

public class CourseDetailsDialogFragment extends DialogFragment {
    View root;
    private int course_pk;
    Course course;
    Toolbar toolbar_details;
    boolean confirmDele;
    private TextView txtCourseID, txtCourseName, txtCourseCode, txtCourseStartTime, txtCourseStopTime;
    private CourseDetailsDialogFragment.onCourseDetailsDialogFragmentListener mCallBack;

    public interface onCourseDetailsDialogFragmentListener{

        boolean getConfirmDelete();

        void sendPKtoDel(Course course);

        void toEditFragment();

        void sendBundle(Bundle bundle);

        void setString();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof CourseDetailsDialogFragment.onCourseDetailsDialogFragmentListener){
            mCallBack = (CourseDetailsDialogFragment.onCourseDetailsDialogFragmentListener) context;

        }else{
            throw new ClassCastException(context.toString() + "Must implement onCourseDetailsDialogFragmentListener");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_course_details_dialog, container, false);
        toolbar_details = (Toolbar)root.findViewById(R.id.toolbar_details);
        mCallBack.setString();

        txtCourseID = (TextView)root.findViewById(R.id.txtCourseIdDetails);
        txtCourseName = (TextView)root.findViewById(R.id.txtCourseNameDetails);
        txtCourseCode = (TextView)root.findViewById(R.id.txtCourseCodeDetails);
        txtCourseStartTime = (TextView)root.findViewById(R.id.txtCourseStartTimeDetails);
        txtCourseStopTime = (TextView)root.findViewById(R.id.txtCourseEndTimeDetails);

        Bundle bundle = this.getArguments();

        if(bundle != null){
            course_pk = bundle.getInt("course_pk");
            toolbar_details.setTitle("Supporter Details");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    course = AppDatabase.getInstance(getContext())
                            .courseDAO()
                            .getByID(course_pk);

                    txtCourseID.setText(course.getCourseNumber());
                    txtCourseName.setText(course.getName());
                    txtCourseCode.setText(course.getCourseCode());
                    txtCourseStartTime.setText(course.getStart_at());
                    txtCourseStopTime.setText(course.getEnd_at());
                }
            }).start();
        }



        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_details);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
        }

        setHasOptionsMenu(true);


        return root;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog (@Nullable Bundle savedInstanceState){
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_edit_dialog,menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.menu_delete:
                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                            course = AppDatabase.getInstance(getContext())
                                    .courseDAO()
                                    .getByID(course_pk);
                        mCallBack.sendPKtoDel(course);
                    }
                }).start();
                dismiss();
                return true;

            case R.id.menu_edit:

                Bundle bundle = new Bundle();
                bundle.putInt("course_pk",course.getId());

                NewSupporterDialogFragment newSupporterDialogFragment = new NewSupporterDialogFragment();
                newSupporterDialogFragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) getView().getContext();
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .add(android.R.id.content, newSupporterDialogFragment)
                        .addToBackStack(null)
                        .commit();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        course = AppDatabase.getInstance(getContext())
//                                .courseDAO()
//                                .getByID(course_pk);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("course_pk",course.getId());
//
//                        //mCallBack.sendBundle(bundle);




   //                 }
//                }).start();



                dismiss();
                break;

            case android.R.id.home:
                dismiss();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }



        return super.onOptionsItemSelected(item);
    }
}