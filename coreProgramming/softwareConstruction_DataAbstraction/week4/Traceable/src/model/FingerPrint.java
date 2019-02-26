package model;

public class FingerPrint implements Traceable {
    private Person person;
    private String policePrecintContainingFingerPrints;

    public FingerPrint(Person p, String precinct) {
        this.person = p;
        this.policePrecintContainingFingerPrints = precinct;
    }

    //EFFECTS: returns this person
    @Override
    public Person getTrace() { return this.person; }

    //EFFECTS: returns the police precinct which has the finger prints of interest
    @Override
    public String getLocation() { return this.policePrecintContainingFingerPrints; }

    //EFFECTS: tracks this
    @Override
    public void track() {
        System.out.println("Tracking... " + this);
    }
}
