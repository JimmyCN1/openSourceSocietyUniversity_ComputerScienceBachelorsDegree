package model;

import java.util.ArrayList;
import java.util.List;

public class CellPhone implements Traceable {
    private Person person;
    private String locationOfCellPhone;
    private List<Call> calls;

    public CellPhone(Person p, String location) {
        this.person = p;
        this.locationOfCellPhone = location;
        this.calls = new ArrayList<Call>();
    }

    //EFFECTS: returns the cellPhone itself
    @Override
    public CellPhone getTrace() { return this; }

    //EFFECTS: returns the up-to-date location of the cell phone
    @Override
    public String getLocation() { return this.locationOfCellPhone; }

    //EFFECTS: tracks this
    @Override
    public void track() {
        System.out.println("Tracking... " + this);
    }
}
