package model;

public class Transcript {

    public Transcript(String studentName, int studentID) { }

    // MODIFY: this
    // EFFECTS: set the name of the given Transcript object to the passed name
    public void setStudentName(String name) { }

    // MODIFY: this
    // EFFECTS: set the ID of the given Transcript object to the passed name
    public void setStudentID(int id) { }

    // EFFECTS: return the given student's name
    public String getStudentName() { return null; }

    // EFFECTS: return the given student's ID
    public int getStudentID() { return 0; }

    // REQUIRES: given course must in the database, 0 <= grade <= 4
    // MODIFIES: this
    // EFFECTS: adds new subject with its corresponding grade to a list
    public void addGrade(String course, double grade) { }

    // TODO
    public String getCourseAndGrade() { return null; }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: gets transcript and prints it to the console with correct formatting
    public void printTranscript() { }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: returns the calculated GPA
    public double getGPA(){ return 0.0; }




}



