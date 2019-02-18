package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Jimmy", 343735);
        Transcript t4 = new Transcript("Abdul", 343725);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t3.addGrade("English", 2.5);
        t3.addGrade("Math", 3.5);
        t3.addGrade("Science", 3.4);
        t3.addGrade("Sports", 3.0);
        t3.addGrade("Art", 2.0);

        t4.addGrade("English", 3.3);
        t4.addGrade("Math", 2.4);
        t4.addGrade("Science", 2.8);
        t4.addGrade("Sports", 2.8);
        t4.addGrade("Art", 3.0);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

        System.out.println(t1.getCourseAndGrade());

        t1.addGrade("Math", 4.0);
        t1.printTranscript();

        t1.setStudentID(872930000);
        t1.getStudentID();


    }
}
