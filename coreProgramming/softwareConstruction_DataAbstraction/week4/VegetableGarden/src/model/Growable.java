package model;

public interface Growable {
    //MODIFIES: this
    //EFFECTS: feeds the vegetable
    public void feed();

    //MODIFIES: this
    //EFFECTS: waters the vegetable
    public void water();

    //EFFECTS: returns the instructions as a string
    public String getInstructions();

    //MODIFIES: this
    //EFFECTS: harvests the vegetable
    public void harvest();
}
