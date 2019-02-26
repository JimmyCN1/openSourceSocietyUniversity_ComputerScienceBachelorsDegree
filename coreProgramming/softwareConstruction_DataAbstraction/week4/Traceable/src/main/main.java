package main;

import model.Call;
import model.CellPhone;
import model.FingerPrint;
import model.Person;

public class main {
    public static void main(String[] args) {
        Person p1 = null;

        CellPhone cp1 = new CellPhone("Singapore");
        FingerPrint fp1 = new FingerPrint(null,"LA");
        p1 = new Person(cp1, fp1);
        p1.setFingerPrint(fp1);

        Call c1 = new Call(cp1,"England");
        Call c2 = new Call(cp1,"America");
        Call c3 = new Call(cp1,"Australia");

        cp1.addCall(c1);
        cp1.addCall(c2);
        cp1.addCall(c3);

        cp1.makeCall();
        cp1.getCalls();

        c1.getLocation();
        c1.getTrace();
        System.out.println(c2.getTrace());

        System.out.println(cp1.getTrace());
        System.out.println(cp1.getLocation());

        c3.track();
        cp1.track();

        System.out.println(cp1.getCallFromCalls("America"));

        System.out.println(p1);
        System.out.println(p1.getCellPhone());
        System.out.println(p1.getFingerPrint());
        System.out.println(p1.getFingerPrint().getLocation());
    }
}
