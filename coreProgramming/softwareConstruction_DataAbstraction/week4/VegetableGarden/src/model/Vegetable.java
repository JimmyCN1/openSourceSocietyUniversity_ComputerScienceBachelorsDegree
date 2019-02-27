package model;

public abstract class Vegetable implements Growable {
    private String name;
    private VegType vegType;
    private String instructions;

    public Vegetable(String name, VegType type) {
        this.name = name;
        this.vegType = type;
    }

    //getters:
    public String getName() { return this.name; }
    public String getInstructions() { return this.instructions; }
    public VegType getVegType() { return this.vegType; }

    //setters:
    public void setName(String name) { this.name = name; }
    public void setInstructions(String instructions) { this.instructions = instructions; }



}
