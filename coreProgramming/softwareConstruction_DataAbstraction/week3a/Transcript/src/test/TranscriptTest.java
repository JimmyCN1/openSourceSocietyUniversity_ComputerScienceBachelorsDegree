package test;

import model.Course;
import model.Transcript;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        testTranscript.addCourseAndGrade("Math", 3.4);
        testTranscript.addCourseAndGrade("English", 3.2);
        testTranscript.addCourseAndGrade("Science", 3.8);
    }

    @Test
    public void testTemplate(){
        //TODO: write tests for Transcript methods
    }

    //TODO: Test Set Student Name: update the name of the transcript
    //TODO: outcome: Transcript has its name updated
    @Test
    public void testSetStudentName() {
        //check what the student name is a string
        assertTrue(testTranscript.getStudentName() instanceof String);
        String initialName = testTranscript.getStudentName();

        //set the student name
        testTranscript.setStudentName("Jeffory");

        //check if the student name has been correctly set
        assertTrue(testTranscript.getStudentName().equals("Jeffory"));
    }

    //TODO: Test Set Student ID: update the studentID of the transcript
    //TODO: outcome: Transcript has its sudentID updated
    @Test
    public void testSetStudentID() {
        //check that the student ID is an int
        assertTrue(testTranscript.getStudentID() instanceof Integer);
        Integer initialID = testTranscript.getStudentID();

        //set the student ID
        testTranscript.setStudentID(3430597);

        //check if the student ID has been correctly set
        assertTrue(testTranscript.getStudentID().equals(3430597));
    }

    //TODO: Test Get Student Name: return the student name of the transcript
    //TODO: outcome: the student's name is returned
    @Test
    public void testGetStudentName() {
        //set student name
        testTranscript.setStudentName("James");

        //check that the correct student name that is returned
        String name = testTranscript.getStudentName();
        assertTrue(name.equals("James"));
    }

    //TODO: Test Get Student ID: return the student ID of the transcript
    //TODO: outcome: the student's ID is returned
    @Test
    public void testGetStudentID() {
        //set student id
        testTranscript.setStudentID(34569);

        //check that the correct student ID is returned
        Integer id = testTranscript.getStudentID();
        assertTrue(id.equals(34569));
    }

    //TODO: Test Get Course And Grade Course Exists: return the course and the corresponding grade given a course name
    //TODO: outcome: return a string which includes the course name and the gpa obtained in that course
    @Test
    public void testGetCourseAndGradeCourseExists() {
        //make list with course included
        Map<String, Integer> courseGrade = new HashMap<String, Integer>();
        courseGrade.put(this.course = course, this.gpa = gpa);
        ArrayList<Course> courses = new ArrayList<Course>(("English", 3.9), ("Math", 2.4));
        //check that the course is in the list

        //retrieve tha course and grade from the list
    }


    //TODO: Test Get Course And Grade No Course: return error message since course is not in transcript
    //TODO: outcome: return error
    @Test
    public void testGetCourseAndGradeNoCourse() {
        //check that the course is not in the list
        //return error message
    }

    //TODO: Test Get GPA: return the calculated GPA of the transcript
    //TODO: outcome: return calculated GPA
    @Test
    public void testGetGPA() {
        //check that an Integer is returned
    }

    //TODO: Test Add Course And Grade No Course
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndGradeNoCourse() {
        //check that the course isn't already in the list
        //add the course and corresponding score to the list
        //check that the course and score were added to the list
    }

    //TODO: Test Add Course And Grade Already Course
    //TODO: outcome: leave transcript unchanged
    @Test
    public void testAddCourseAndGradeAlreadyCourse() {
        //check that the course already exists in the list
        //return error message
        //check that the list remains unchanged
    }

    //TODO: Test Add Course And In Bounds Grade
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndInBoundsGrade() {
        //check that the given grade is a valid gpa
        //add the course and corresponding score to the list
        //check that the course and score were added to the list
    }

    //TODO: Test Add Course And Out Of Bounds Grade
    //TODO: outcome: return error
    @Test
    public void testAddCourseAndOutOfBoundsGrade() {
        //check that the given grade is not a valid gpa
        //return error message
        //check that the list remains unchanged
    }
}










