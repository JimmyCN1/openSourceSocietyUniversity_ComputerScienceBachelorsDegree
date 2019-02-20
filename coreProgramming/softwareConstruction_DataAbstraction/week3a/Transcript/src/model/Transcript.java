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
    public HashMap<String, Double> getCourseAndGrade(String course) {
        HashMap<String, Double> courseAndGrade = new HashMap<String, Double>();
        if (this.courseListWithGrades.containsKey(course)) {
            Double grade = this.courseListWithGrades.get(course);
            courseAndGrade.put(course, this.courseListWithGrades.get(course));
        }
        return courseAndGrade;
    }

    // EFFECTS: return full transcript with grades for each course
    public HashMap<String, Double> getCourseListWithGrades() { return this.courseListWithGrades; }

    //REQUIRE: at least one course selected
    //EFFECTS: return the average gpa of the selected courses
    public Double getAverageOfTheSelectedCourses(String... course) {
        Double selectedGPA = 0.0;
        HashMap<String, Double> selectedCourses = new HashMap<String, Double>();
        for (Integer i = 0; i < course.length; i++) {
            if (course.length == 0) {
                return selectedGPA;
            } else {
                selectedCourses.put(course[i], this.getCourseAndGrade(course[i]).get(course[i]));
                selectedGPA = selectedGPA + selectedCourses.get(course[i]);
            }
        }
        if (course.length != 0) {
            selectedGPA = selectedGPA / course.length;
        }
        return selectedGPA;
    }

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
    public void addCourseAndGrade(String course, Double grade) {
        if(!this.containsCourse(course) && grade > 0.0 && grade <= 4.0) {
            this.courseListWithGrades.put(course, grade);
        }
    }

    // EFFECTS: gets transcript and prints it to the console with correct formatting
    public void printTranscript() {
        System.out.println("Name: " + this.studentName);
        System.out.println("ID: " + this.studentID);
        this.courseListWithGrades.forEach((course, grade) -> System.out.println(course + ": " + grade));
        this.printGPA();
    }

    public void printAverageOfSeletedCourses(String... course) {
        System.out.println("GPA for the selected courses: " + this.getAverageOfTheSelectedCourses(course));
    }

    // EFFECTS: print GPA
    public void printGPA() {
        System.out.println("\nGPA: " + this.getGPA());
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



