package com.example.cs3270a7_ryanmcclain;

import android.app.Dialog;
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

import androidx.appcompat.widget.Toolbar;

import com.example.cs3270a7_ryanmcclain.db.AppDatabase;
import com.example.cs3270a7_ryanmcclain.db.Course;
import com.google.android.material.textfield.TextInputEditText;


public class NewSupporterDialogFragment extends DialogFragment {

    private TextInputEditText txtCourseID, txtCourseName, txtCourseCode, txtCourseStartTime, txtCourseStopTime;
    Toolbar toolbar;
    private boolean isNew = true; //tells me if the user is trying to add new or edit.
    Course course;
    private int course_pkTwo;
    View root;
    private NewSupporterDialogFragment.NewCourseDialogFragmentListener mCallBack;

    public interface NewCourseDialogFragmentListener {
        void getNew(boolean b);
    }

//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof NewCourseDialogFragment.NewCourseDialogFragmentListener){
//            mCallBack = (NewCourseDialogFragment.NewCourseDialogFragmentListener) context;
//
//        }else{
//            throw new ClassCastException(context.toString() + "Must implement NewCourseDialogFragmentListener");
//        }
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_new_course_dialog, container, false);

        toolbar = (Toolbar)root.findViewById(R.id.toolbar);
        txtCourseID  = (TextInputEditText)root.findViewById((R.id.txtCourseId));
        txtCourseName = (TextInputEditText)root.findViewById((R.id.txtName));
        txtCourseCode = (TextInputEditText)root.findViewById((R.id.txtCourseCode));
        txtCourseStartTime = (TextInputEditText)root.findViewById((R.id.txtStart_at));
        txtCourseStopTime =(TextInputEditText)root.findViewById((R.id.txtEnd_At));

        Bundle bundle = this.getArguments();

        if(bundle !=null){
            isNew = false;
            course_pkTwo = bundle.getInt("course_pk");
            toolbar.setTitle("Edit Supporter");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    course = AppDatabase.getInstance(getContext())
                            .courseDAO()
                            .getByID(course_pkTwo);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            txtCourseID.setText(course.getCourseNumber());
                            txtCourseName.setText(course.getName());
                            txtCourseCode.setText(course.getCourseCode());
                            txtCourseStartTime.setText(course.getStart_at());
                            txtCourseStopTime.setText(course.getEnd_at());
                        }
                    });


                }
            }).start();

        }else{
            toolbar.setTitle("Add Supporter");
        }

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

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

    //generates save icon and inflates it from menu

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.menu_create_dialog,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_create:

                //get user information and save to db
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                          //if  new course
                        if(isNew){
                            Course course = new Course
                                    (txtCourseID.getText().toString(),
                                    txtCourseName.getText().toString(),
                                    txtCourseCode.getText().toString(),
                                    txtCourseStartTime.getText().toString(),
                                    txtCourseStopTime.getText().toString());
                            AppDatabase.getInstance(getContext())
                                    .courseDAO()
                                    .insert(course);

                        }   else{
                            //if updating course
//                            course = AppDatabase.getInstance(getContext())
//                                    .courseDAO()
//                                    .getByID(course_pkTwo);

                            course.setCourseNumber(txtCourseID.getText().toString());
                            course.setName(txtCourseName.getText().toString());
                            course.setCourseCode(txtCourseCode.getText().toString());
                            course.setStart_at(txtCourseStartTime.getText().toString());
                            course.setEnd_at(txtCourseStopTime.getText().toString());


                            AppDatabase.getInstance(getContext())
                                    .courseDAO()

                                    .update(course);

                        }
                    }
                }).start();
                dismiss();
                return true;

            case android.R.id.home:
                dismiss();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}