package com.example.cs3270a7_ryanmcclain;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cs3270a7_ryanmcclain.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class SupporterEditFragment extends Fragment {
    View root;
    private TextInputEditText cId, cName, cCode, sTime,eTime;
    private Button btnSubmit;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_course_edit, container, false);
        cId = (TextInputEditText)root.findViewById(R.id.txtCourseId);
        cName = (TextInputEditText)root.findViewById(R.id.txtName);
        cCode = (TextInputEditText)root.findViewById(R.id.txtCourseCode);
        sTime = (TextInputEditText)root.findViewById(R.id.txtStart_at);
        eTime = (TextInputEditText)root.findViewById(R.id.txtEnd_At);
        btnSubmit = (Button)root.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String sCourseId = cId.getText().toString();
                final String sCourseName = cName.getText().toString();
                final String sCourseCode = cCode.getText().toString();
                final String sStartTime = sTime.getText().toString();
                final String sEndTime = eTime.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //inserts courses in db
//                        AppDatabase.getInstance(getContext())
//                                .courseDAO()
//                                .insert(new Course(sCourseId,sCourseName,sCourseCode,sStartTime,sEndTime));
//                        //gets all courses in db
//                        List<Course> courses = AppDatabase.getInstance(getContext())
//                                .courseDAO()
//                                .getALL();
//
//                        for (Course c:courses){
//                            Log.d("test", "courses" + c.toString());
//                        }
//                        Log.d("test","------------------" );
                    }
                }).start();

            }
        });


        return root;
    }
}