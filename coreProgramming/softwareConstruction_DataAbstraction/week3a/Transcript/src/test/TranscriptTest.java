package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

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
    public void testSetStudentName(String name) {
        //check what the student name is
        //set the student name
        //check if the student name has been correctly set
    }

    //TODO: Test Set Student ID: update the studentID of the transcript
    //TODO: outcome: Transcript has its sudentID updated
    @Test
    public void testSetStudentID(int id) {
        //check what the student ID is
        //set the student ID
        //check if the student ID has been correctly set
    }

    //TODO: Test Get Student Name: return the student name of the transcript
    //TODO: outcome: the student's name is returned
    @Test
    public String testGetStudentName() {
        //check that the student name that is returned
        return "";
    }

    //TODO: Test Get Student ID: return the student ID of the transcript
    //TODO: outcome: the student's ID is returned
    @Test
    public String testGetStudentID() {
        //check that the student ID is returned
        return "";
    }

    //TODO: Test Get Course And Grade Course Exists: return the course and the corresponding grade given a course name
    //TODO: outcome: return a string which includes the course name and the gpa obtained in that course
    @Test
    public String testGetCourseAndGradeCourseExists(String course) {
        //check that the course is in the list
        //retrieve tha course and grade from the list
        return "";
    }


    //TODO: Test Get Course And Grade No Course: return error message since course is not in transcript
    //TODO: outcome: return error
    @Test
    public String testGetCourseAndGradeNoCourse(String course) {
        //check that the course is not in the list
        //return error message
        return "";
    }

    //TODO: Test Get GPA: return the calculated GPA of the transcript
    //TODO: outcome: return calculated GPA
    @Test
    public int testGetGPA() {
        //check that an int is returned
        return 0;
    }

    //TODO: Test Add Course And Grade No Course
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndGradeNoCourse(String course, int grade) {
        //check that the course isn't already in the list
        //add the course and corresponding score to the list
        //check that the course and score were added to the list
    }

    //TODO: Test Add Course And Grade Already Course
    //TODO: outcome: leave transcript unchanged
    @Test
    public void testAddCourseAndGradeAlreadyCourse(String course, int grade) {
        //check that the course already exists in the list
        //return error message
        //check that the list remains unchanged
    }

    //TODO: Test Add Course And In Bounds Grade
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndInBoundsGrade(String course, int grade) {
        //check that the given grade is a valid gpa
        //add the course and corresponding score to the list
        //check that the course and score were added to the list
    }

    //TODO: Test Add Course And Out Of Bounds Grade
    //TODO: outcome: return error
    @Test
    public void testAddCourseAndOutOfBoundsGrade(String course, int grade) {
        //check that the given grade is not a valid gpa
        //return error message
        //check that the list remains unchanged
    }
}










