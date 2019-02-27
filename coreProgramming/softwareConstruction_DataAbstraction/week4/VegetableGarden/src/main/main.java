package main;

import model.Vegetable;
import model.Vegetables.Carrot;
import model.Vegetables.Lettuce;
import model.Vegetables.Tomato;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Lettuce lettuce1 = new Lettuce();
        Carrot carrot1 = new Carrot();
        Tomato tomato1 = new Tomato();

        List<Vegetable> garden = new ArrayList<Vegetable>();
        garden.add(lettuce1);
        garden.add(carrot1);
        garden.add(tomato1);

        garden.add(new Carrot());
        garden.add(new Tomato());
        garden.add(new Lettuce());

        System.out.println(garden.get(0).getName());
        System.out.println(garden.get(0).getVegType());
        System.out.println(garden.get(1).getInstructions());

        garden.get(2).feed();
        garden.get(5).harvest();
        garden.get(4).water();


    }
}
