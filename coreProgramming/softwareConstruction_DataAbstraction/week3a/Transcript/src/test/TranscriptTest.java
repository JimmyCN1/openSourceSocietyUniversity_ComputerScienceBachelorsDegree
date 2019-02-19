package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.*;

public class TranscriptTest {

    private Transcript testTranscript;
    private HashMap<String, Double> testGrades;

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
        //check that the student ID is an Integer
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

    //TODO: Test Get Course And Grade When Course Exists: return the course and the corresponding grade given a course name
    //TODO: outcome: return a string which includes the course name and the gpa obtained in that course
    @Test
    public void testGetCourseAndGradeWhenCourseExists() {
        //check that the course is in the hash map
        assertTrue(testTranscript.containsCourse("English"));

        //retrieve the course and grade from the hash map
        HashMap<String, Double> testMap;
        testMap = testTranscript.getCourseAndGrade("English");

        //check that course and grade were correctly retrieved
        assertTrue(testMap.containsKey("English") && testMap.get("English") == 3.2);
    }


    //TODO: Test Get Course And Grade When No Course: return error message since course is not in transcript
    //TODO: outcome: return error
    @Test
    public void testGetCourseAndGradWhenNoCourse() {
        //check that the course is not in the hash map
        assertFalse(testTranscript.containsCourse("Home Economics"));

        // try and fail to retrieve course and grade from the hash map
        HashMap<String, Double> testMap;
        testMap = testTranscript.getCourseAndGrade("Home Economics");

        //check that no course or gpa has been retrieved
        assertTrue(!testMap.containsKey("Home Economics"));
        //assertFalse(testMap.get("Home Economics") == null);

    }

    //TODO: Test Get GPA: return the calculated GPA of the transcript
    //TODO: outcome: return calculated GPA
    @Test
    public void testGetGPA() {
        //check that the course is in the hash map
        assertTrue(testTranscript.containsCourse("English"));

        assertTrue(testTranscript.sizeOfTranscript() == 3);
        //check that an Integer is returned
        //assertTrue(testTranscript.getGPA() instanceof Integer);
    }

    //TODO: Test Add Course And Grade No Course
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndGradeNoCourse() {
        //check that the course is not in the hash map
        assertFalse(testTranscript.containsCourse("Home Economics"));
        assertTrue(testTranscript.sizeOfTranscript() == 3);

        //add the course and corresponding score to the hash map
        testTranscript.addCourseAndGrade("Home Economics", 3.8);

        //check that the course and score were added to the hash map
        assertTrue(testTranscript.sizeOfTranscript() == 4);
        assertTrue(testTranscript.getCourseAndGrade("Home Economics").get("Home Economics") == 3.8);
    }

    //TODO: Test Add Course And Grade Already Course
    //TODO: outcome: leave transcript unchanged
    @Test
    public void testAddCourseAndGradeAlreadyCourse() {
        //check that the course is not in the hash map
        assertTrue(testTranscript.containsCourse("English"));
        assertTrue(testTranscript.sizeOfTranscript() == 3);

        //add the course and corresponding score to the hash map
        testTranscript.addCourseAndGrade("English", 3.7);

        //check that the hash map remains unchanged
        assertTrue(testTranscript.sizeOfTranscript() == 3);
        assertTrue(testTranscript.getCourseAndGrade("English").get("English") == 3.2);
    }

    //TODO: Test Add Course And In Bounds Grade
    //TODO: outcome: add course and grade to the transcript
    @Test
    public void testAddCourseAndInBoundsGrade() {
        //check that the given grade is a valid gpa
        assertTrue(0.0 < 3.0 && 3.0 < 4.0);
        assertTrue(testTranscript.sizeOfTranscript() == 3);

        //add the course and corresponding score to the hash map
        testTranscript.addCourseAndGrade("Home Economics", 3.0);

        //check that the course and score were added to the hash map
        assertTrue(testTranscript.sizeOfTranscript() == 4);
        assertTrue(testTranscript.getCourseAndGrade("Home Economics").get("Home Economics") == 3.0);
    }

    //TODO: Test Add Course And Out Of Bounds Grade
    //TODO: outcome: return error
    @Test
    public void testAddCourseAndOutOfBoundsGrade() {
        //check that the given grade is not a valid gpa
        assertFalse(0.0 < 5.2 && 5.2 < 4.0);

        //add the course and the corresponding function to the hash map
        testTranscript.addCourseAndGrade("Home Economics", 5.2);

        //check that the hash map remains unchanged
        assertTrue(testTranscript.sizeOfTranscript() == 3);
    }
}










