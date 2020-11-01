package com.example.cs3270a7_ryanmcclain;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cs3270a7_ryanmcclain.db.AppDatabase;
import com.example.cs3270a7_ryanmcclain.db.Course;

import java.util.List;

public class AllSupportersViewModel extends ViewModel {
    private LiveData<List<Course>> courseList;

    public LiveData<List<Course>> getCourseList(Context c){
        if(courseList != null){
            return courseList;
        }else{
            return courseList = AppDatabase.getInstance(c).courseDAO().getALL();
        }
    }
}
