package com.example.cs3270a7_ryanmcclain.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String courseNumber, name, courseCode ,start_at, end_at;




    public Course(String courseNumber, String name, String courseCode,String start_at, String end_at) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.courseCode = courseCode;
        this.start_at = start_at;
        this.end_at = end_at;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNumber='" + courseNumber + '\'' +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", start_at='" + start_at + '\'' +
                ", end_at='" + end_at + '\'' +
                '}';
    }
}
