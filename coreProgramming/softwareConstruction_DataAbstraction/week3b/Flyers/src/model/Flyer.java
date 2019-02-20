package model;

public interface Flyer {

    //REQUIRES: being on land
    //MODIFIES: this
    //EFFECTS: moves this into the air
    public void takeoff();

    //REQUIRES: being in the air
    //MODIFIES: this
    //EFFECTS: moves this horizontally in the air
    public void fly();

    //REQUIRES: being in the air
    //MODIFIES: this
    //EFFECTS: moves this onto the land
    public void land();
}
