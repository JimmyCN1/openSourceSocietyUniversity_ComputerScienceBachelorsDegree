package test;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CoinTest {
    private Coin coin;

    @Before
    public void setup() {
        coin = new Coin();
    }

    //Make sure we are not always getting the same response
    @Test
    public void testFlipHeadsAndTails() {
        int timesChanged = 0;
        String lastStatus = "heads";
        for (int i = 0; i < 10; i++) {
            coin.flipCoin();
            String status = coin.getCoinStatus();
            System.out.println(status);
            if (!status.equals(lastStatus)) {
                lastStatus = status;
                timesChanged++;
            }
        }
        assertFalse(timesChanged == 0);
    }

    //Test to ensure he same value isn't being returned more than ten times in a row
    @Test
    public void testFlipRandomness() {
        String lastStatus = "heads";
        int consecutiveResultCount = 0;
        int longestConsecutiveResultCount = 0;
        for (int i = 0; i < 100; i++) {
            coin.flipCoin();
            String status = coin.getCoinStatus();
            System.out.println(status);
            if (status.equals(lastStatus)) {
                lastStatus = status;
                consecutiveResultCount++;
                assertFalse(consecutiveResultCount == 10);
            } else {
                lastStatus = status;
                if (consecutiveResultCount > longestConsecutiveResultCount) {
                    longestConsecutiveResultCount = consecutiveResultCount;
                }
                consecutiveResultCount = 0;
            }
            System.out.println(consecutiveResultCount);
        }
    }

}
