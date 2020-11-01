package com.example.cs3270a7_ryanmcclain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cs3270a7_ryanmcclain.db.Course;

import java.util.List;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {

    public final List<Course> courses;

    public CourseRecyclerViewAdapter(List<Course> courses){
        this.courses = courses;
    }
    public void addItems(List<Course>courses){
        this.courses.clear();
        this.courses.addAll(courses);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View root;
        public Course course;
        public TextView txtLine1, txtLine2,txtLine3,txtLine4,txtLine5;

        public ViewHolder(View itemView){
            super (itemView);
            root = itemView;
            txtLine1=(TextView)root.findViewById(R.id.txtLine1);
            txtLine2=(TextView)root.findViewById(R.id.txtLine2);
            txtLine3=(TextView)root.findViewById(R.id.txtLine3);
            txtLine4=(TextView)root.findViewById(R.id.txtLine4);
            txtLine5=(TextView)root.findViewById(R.id.txtLine5);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    //need more holders txtlines and the rest of info for course

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Course course = courses.get(position);
        if(course != null){
            holder.course = course;
            holder.txtLine1.setText(course.getCourseNumber());
            holder.txtLine2.setText(course.getName());
            holder.txtLine3.setText(course.getCourseCode());
            holder.txtLine4.setText(course.getStart_at());
            holder.txtLine5.setText(course.getEnd_at());

            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putInt("course_pk",course.getId());

                    CourseDetailsDialogFragment courseDetailsDialogFragment = new CourseDetailsDialogFragment();
                    courseDetailsDialogFragment.setArguments(bundle);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .add(android.R.id.content,courseDetailsDialogFragment)
                            .addToBackStack(null)
                            .commit();


                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return courses.size();
    }


}
