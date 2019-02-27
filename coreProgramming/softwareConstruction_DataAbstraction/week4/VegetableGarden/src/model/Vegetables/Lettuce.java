package model.Vegetables;

import model.VegType;
import model.Vegetable;

public class Lettuce extends Vegetable {
    public Lettuce() {
        super("Lettuce", VegType.LEAF);
        this.setInstructions("Lettuce Instructions");
    }

    @Override
    public void feed() {
        System.out.println("Feeding Lettuce...");
    }

    @Override
    public void water() {
        System.out.println("Watering lettuce...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting Lettuce...");
    }
}
