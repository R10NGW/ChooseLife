package com.example.cs3270a7_ryanmcclain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs3270a7_ryanmcclain.db.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFragment extends Fragment {
    View root;
    private RecyclerView recyclerView;
    private CourseRecyclerViewAdapter courseRecyclerViewAdapter;
    private int columnCount = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main,container,false);
        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Context context = getContext();

        courseRecyclerViewAdapter = new CourseRecyclerViewAdapter(new ArrayList<Course>());

        if(columnCount <=1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else{
                recyclerView.setLayoutManager(new GridLayoutManager(context,columnCount));
            }
        recyclerView.setAdapter(courseRecyclerViewAdapter);
        recyclerView.setHasFixedSize(false);

        ViewModelProviders.of(this)
        .get(AllSupportersViewModel.class)
        .getCourseList(context)
        .observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                if (courses !=null){
                    courseRecyclerViewAdapter.addItems(courses);
                }
            }
        });
    }


}
