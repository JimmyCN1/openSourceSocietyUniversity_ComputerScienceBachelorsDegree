package model;

public class Call implements Traceable {
    private CellPhone cellPhone;
    private String locationOfCall;

    public Call(CellPhone cell, String location) {
        this.cellPhone = cell;
        this.locationOfCall = location;
    }

    //EFFECTS: returns the cellphone of the caller
    @Override
    public CellPhone getTrace() { return this.cellPhone; }

    //EFFECTS: returns the location of where the call originated from
    @Override
    public String getLocation() { return this.locationOfCall; }

    //EFFECTS: tracks this
    @Override
    public void track() {
        System.out.println("Tracking... " + this);
    }
}
