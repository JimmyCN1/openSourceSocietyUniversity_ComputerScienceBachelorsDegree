package model.Vegetables;

import model.VegType;
import model.Vegetable;

public class Carrot extends Vegetable {
    public Carrot () {
        super("Carrot", VegType.ROOT);
        this.setInstructions("Carrot Instructions");
    }
    @Override
    public void feed() {
        System.out.println("Feeding Carrot...");
    }

    @Override
    public void water() {
        System.out.println("Watering Carrot...");
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting Carrot...");
    }
}
