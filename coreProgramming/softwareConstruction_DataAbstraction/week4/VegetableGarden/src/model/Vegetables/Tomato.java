package model.Vegetables;

import model.VegType;
import model.Vegetable;

public class Tomato extends Vegetable {
    public Tomato() {
        super("Tomato", VegType.SEED);
        this.setInstructions("Tomato Instructions");
    }

    @Override
    public void feed() {
        System.out.println("Feeding Tomato...");
    }

    @Override
    public void water() {
        System.out.println("Watering Tomato...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting Tomato...");
    }
}
