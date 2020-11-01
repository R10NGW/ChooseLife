package com.example.cs3270a7_ryanmcclain.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {

    @Query("select * from Course")
    LiveData<List<Course>> getALL();

    @Insert
    void insert (Course course);

    @Update
    void update(Course course);

    @Query("Select * from Course where id = :id")
    Course getByID(int id);

    @Delete
    void delete(Course course);

    @Query("Select * from course where id = :id")
    List<Course> loadByID(int id);

    @Query("Select * from Course where courseNumber = :courseNumber and name=:name and courseCode =:courseCode LIMIT 1")
    Course loadByCourseName(String courseNumber, String name, String courseCode);
}
