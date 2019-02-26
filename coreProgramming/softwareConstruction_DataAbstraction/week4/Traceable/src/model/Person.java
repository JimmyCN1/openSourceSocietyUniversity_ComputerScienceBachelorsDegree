package model;

public class Person {
    private CellPhone cellPhone;
    private FingerPrint fingerPrint;

    public Person(CellPhone cp, FingerPrint fp) {
        this.cellPhone = cp;
        this.fingerPrint = fp;
    }
}
