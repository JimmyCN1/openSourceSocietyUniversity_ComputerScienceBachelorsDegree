package test;

import model.IntegerSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class IntegerSetTest {
    IntegerSet testSet;

    @Before
    public void setup() {
        testSet = new IntegerSet();
    }


    @Test
    public void testInsertNotThere() {
        checkSetEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
    }


    @Test
    public void testInsertAlreadyThere() {
        checkSetEmptyDoesntContain(3);
        testSet.insert(3);
        checkSetContainsOnce(3);
        testSet.insert(3);
        checkSetContainsOnce(3);

    }


    private void checkSetEmptyDoesntContain(int num) {
        assertEquals(testSet.size(), 0);
        assertFalse(testSet.contains(3));
    }

    private void checkSetContainsOnce(int num) {
        assertEquals(testSet.size(), 1);
        assertTrue(testSet.contains(3));
    }

}
