package test;

import model.Vegetable;
import model.Vegetables.Carrot;
import model.Vegetables.Lettuce;
import model.Vegetables.Tomato;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.VegType.ROOT;
import static org.junit.Assert.assertEquals;

public class VegetablesTest {
    List<Vegetable> testVegePatch = new ArrayList<Vegetable>();

    @Before
    public void setup() {
        testVegePatch.add(new Carrot());
        testVegePatch.add(new Lettuce());
        testVegePatch.add(new Tomato());
        testVegePatch.add(new Lettuce());
    }

    @Test
    public void testGetters() {
        assertEquals(testVegePatch.get(0).getName(), "Carrot");
        assertEquals(testVegePatch.get(0).getVegType(), ROOT);
        assertEquals(testVegePatch.get(1).getInstructions(), "Lettuce Instructions");
    }

    @Test
    public void testSetters() {
        testVegePatch.get(0).setName("Carr");
        assertEquals(testVegePatch.get(0).getName(), "Carr");
        testVegePatch.get(1).setInstructions("Lett Instructions");
        assertEquals(testVegePatch.get(1).getInstructions(), "Lett Instructions");
    }

}
