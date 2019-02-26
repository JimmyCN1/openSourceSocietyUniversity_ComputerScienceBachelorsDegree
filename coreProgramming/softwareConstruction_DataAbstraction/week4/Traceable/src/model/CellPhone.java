package model;

import java.util.ArrayList;
import java.util.List;

public class CellPhone implements Traceable {
    private Person person;
    private String locationOfCellPhone;
    private Call call;
    private List<Call> calls;

    public CellPhone(String location) {
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

    //MODIFIES: this
    //EFFECTS: adds given call to the list of calls made by the phone
    public void addCall(Call call) {
        if (call != null) {
            calls.add(call);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a call to the list of calls made by this cell phone
    public void makeCall() {
        call = new Call(this, this.locationOfCellPhone);
        calls.add(call);
    }

    //EFFECTS: returns list of all calls made from this cell phone
    public void getCalls() {
        if (this.calls.size() != 0) {
            for (Call c : calls) {
                System.out.println("Source of call: " + c.getLocation());
            }
        }
    }

    //EFFECTS: returns calls made from the passed location
    public Call getCallFromCalls(String location) {
        Call retrievedCall = null;
        for (Call c : calls) {
            if (c.getLocation() == location) {
                retrievedCall = c;
            }
        }

        return retrievedCall;
    }
}
