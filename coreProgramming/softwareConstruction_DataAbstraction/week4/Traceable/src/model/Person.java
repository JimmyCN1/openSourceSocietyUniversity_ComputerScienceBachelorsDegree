package model;

public class Person {
    private CellPhone cellPhone;
    private FingerPrint fingerPrint;

    public Person(CellPhone cp, FingerPrint fp) {
        this.cellPhone = cp;
        this.fingerPrint = fp;
    }

    //getters:
    public CellPhone getCellPhone() { return this.cellPhone; }
    public FingerPrint getFingerPrint() { return this.fingerPrint; }
}
