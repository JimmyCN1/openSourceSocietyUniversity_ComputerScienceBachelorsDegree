package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Transcript {
    private String studentName;
    private Integer studentID;
    private HashMap<String, Double> courseListWithGrades = new HashMap<String, Double>();

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
    public Integer getStudentID() { return this.studentID; }

    // REQUIRES: transcript to have given course already recorded
    // EFFECTS: returns the course and grade of a given course
    public Double getCourseAndGrade(String course) { return this.courseListWithGrades.get(course); }

    // EFFECTS: returns the calculated GPA
    public Double getGPA(){
        ArrayList<Double> grades = new ArrayList<Double>();
        this.courseListWithGrades.forEach((course, grade) -> grades.add(grade));
        Double average = 0.0;
        for (Integer i = 0; i < grades.size(); i++) {
            average = average + grades.get(i);
        }
        return average / grades.size();
    }

    // REQUIRES: given course must in the database, 1.0 <= grade <= 4.0
    // MODIFIES: this
    // EFFECTS: adds new subject with its corresponding grade to a list
    public void addCourseAndGrade(String course, Double grade) { this.courseListWithGrades.put(course, grade); }

    // EFFECTS: gets transcript and prints it to the console with correct formatting
    public void printTranscript() {
        this.courseListWithGrades.forEach((course, grade) -> System.out.println(course + ": " + grade));
    }

    // EFFECTS: returns true if the given course is in the transcript
    public boolean containsCourse(String course) {
        if (this.courseListWithGrades.containsKey(course)) {
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: returns the number of courses in the transcript
    public Integer sizeOfTranscript() { return this.courseListWithGrades.size(); }


}



