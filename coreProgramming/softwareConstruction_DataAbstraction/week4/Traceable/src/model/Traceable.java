package model;

public interface Traceable {
    //EFFECTS: returns the object of interest
    public Object getTrace();

    //EFFECTS: returns the location of the object of interest
    public String getLocation();

    //EFFECTS: tracks the target object of interest
    public void track();
}
