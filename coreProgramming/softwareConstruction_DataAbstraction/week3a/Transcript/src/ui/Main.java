package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Jimmy", 343735);
        Transcript t4 = new Transcript("Abdul", 343725);

        t1.addCourseAndGrade("CPSC-210", 3.5);
        t1.addCourseAndGrade("ENGL-201", 4.0);
        t1.addCourseAndGrade("CPSC-110", 3.1);

        t3.addCourseAndGrade("English", 2.5);
        t3.addCourseAndGrade("Math", 3.5);
        t3.addCourseAndGrade("Science", 3.4);
        t3.addCourseAndGrade("Sports", 3.0);
        t3.addCourseAndGrade("Art", 2.0);

        t4.addCourseAndGrade("English", 3.3);
        t4.addCourseAndGrade("Math", 2.4);
        t4.addCourseAndGrade("Science", 2.8);
        t4.addCourseAndGrade("Sports", 2.8);
        t4.addCourseAndGrade("Art", 3.0);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

        System.out.println(t1.getCourseAndGrade("ENGL-201"));

        t1.addCourseAndGrade("Math", 4.0);
        t1.printTranscript();

        t1.setStudentID(872930000);
        t1.getStudentID();


    }
}
