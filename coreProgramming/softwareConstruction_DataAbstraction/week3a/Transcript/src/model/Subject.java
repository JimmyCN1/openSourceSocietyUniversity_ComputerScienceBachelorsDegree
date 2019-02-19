package model;

public class Subject {
    private String course;
    private int gpa;

    // GETTERS:
    public String getCourse() { return this.course; }
    public int getGpa() { return this.gpa; }

    // SETTERS:
    public void setCourse(String course) { this.course = course; }
    public void setGpa(int gpa) { this.gpa = gpa; }

    // EFFECTS: returns the gpa as a string
    public String stringifyGpa() { return Integer.toString(this.gpa); }
}
