package test;

import model.HighVolumeIntegerSet;
import model.IntegerSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class HighVolumeIntegerSetTest {
    IntegerSet testSet;

    @Before
    public void setup() {
        testSet = new HighVolumeIntegerSet();
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

    @Test
    public void testInsertHighVolume() {
        for (Integer i = 0; i < 50000; i++) {
            testSet.insert(i);
            assertTrue(testSet.contains(i));
            assertEquals(testSet.size(), i + 1);
        }
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
