package model;

import java.util.ArrayList;

public class Transcript {
    private String studentName;
    private int studentID;
    private ArrayList<Subject> grades = new ArrayList<Subject>();

    public Transcript(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    // MODIFY: this
    // EFFECTS: set the name of the given Transcript object to the passed name
    public void setStudentName(String name) { this.studentName = name; }

    // MODIFY: this
    // EFFECTS: set the ID of the given Transcript object to the passed name
    public void setStudentID(int id) { this.studentID = id; }

    // EFFECTS: return the given student's name
    public String getStudentName() { return this.studentName; }

    // EFFECTS: return the given student's ID
    public int getStudentID() { return this.studentID; }

    // REQUIRES: transcript to have given course already recorded
    // EFFECTS: returns the course and grade of a given course
    public String getCourseAndGrade(String course) { return null; }

    // EFFECTS: returns the calculated GPA
    public double getGPA(){ return 0.0; }

    // REQUIRES: given course must in the database, 1.0 <= grade <= 4.0
    // MODIFIES: this
    // EFFECTS: adds new subject with its corresponding grade to a list
    public void addCourseAndGrade(String course, double grade) { }

    // EFFECTS: gets transcript and prints it to the console with correct formatting
    public void printTranscript() { }




}



