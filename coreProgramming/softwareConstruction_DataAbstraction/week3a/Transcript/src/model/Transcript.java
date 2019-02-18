package model;

public class Transcript {

    // REQUIRES: given course must in the database, 0 <= grade <= 4
    // MODIFIES: this
    // EFFECTS: adds new subject with its corresponding grade to a list
    public void addGrade(String course, double grade){ }

    // REQUIRES: given course must be in the database
    // MODIFIES: this
    // EFFECTS: returns a string of the of the course and its corresponding grade in the format "Course: Grade"
    public String getCourseAndGrade(String course){ return null; }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: gets transcript and prints it to the console with correct formatting
    public void printTranscript(){ }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the calculated GPA
    public double getGPA(){ return 0.0; }

}



// MODIFIES: this
// EFFECTS: inserts num if not already there
    //      if num is there, does nothing
public void insert(Integer num) { []; }