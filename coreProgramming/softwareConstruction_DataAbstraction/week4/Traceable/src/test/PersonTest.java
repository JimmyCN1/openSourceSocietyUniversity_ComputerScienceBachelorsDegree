package test;

import model.Call;
import model.CellPhone;
import model.FingerPrint;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person testP1;
    private FingerPrint testFP1;
    private CellPhone testCP1;
    private Call testCall1;
    private Call testCall2;
    private Call testCall3;

    @Before
    public void setup() {
        testCP1 = new CellPhone("amsterdam");
        testP1 = new Person(testCP1, null);
        testFP1 = new FingerPrint(testP1,"sydney");
        testP1.setFingerPrint(testFP1);
        testCall1 = new Call(testCP1, "amsterdam");
        testCall2 = new Call(testCP1, "london");
        testCall3 = new Call(testCP1, "stockholm");
    }

    @Test
    public void testPersonCellPhoneGetter() {
        assertEquals(testP1.getCellPhone(), testCP1);
    }

    @Test
    public void testGetPersonFingerPrint() {
        assertEquals(testP1.getFingerPrint(), testFP1);
    }

    @Test
    public void testFingerPrint() {
        assertEquals(testP1.getFingerPrint().getTrace(), testP1);
        assertEquals(testP1.getFingerPrint().getLocation(), "sydney");
    }

    @Test
    public void testCellPhoneGetters() {
        assertEquals(testP1.getCellPhone().getTrace(), testCP1);
        assertEquals(testP1.getCellPhone().getLocation(), "amsterdam");
    }

    @Test
    public void testMakeCall() {
        assertEquals(testP1.getCellPhone().getCalls().size(), 0);
        testP1.getCellPhone().makeCall();
        assertEquals(testP1.getCellPhone().getCalls().size(), 1);
    }

    @Test
    public void testAddCall() {
        assertEquals(testP1.getCellPhone().getCalls().size(), 0);
        testP1.getCellPhone().addCall(testCall1);
        assertEquals(testP1.getCellPhone().getCalls().size(), 1);
        testP1.getCellPhone().addCall(testCall2);
        assertEquals(testP1.getCellPhone().getCalls().size(), 2);
        testP1.getCellPhone().addCall(testCall3);
        assertEquals(testP1.getCellPhone().getCalls().size(), 3);
    }

    @Test
    public void testGetCallFromCallsUsingLocationString() {
        testP1.getCellPhone().addCall(testCall1);
        testP1.getCellPhone().addCall(testCall2);
        testP1.getCellPhone().addCall(testCall3);
        assertEquals(testP1.getCellPhone().getCallFromCalls("stockholm"), testCall3);
    }

    @Test
    public void testCall() {
        assertEquals(testCall1.getTrace(), testCP1);
        assertEquals(testCall2.getLocation(), "london");
    }
}
