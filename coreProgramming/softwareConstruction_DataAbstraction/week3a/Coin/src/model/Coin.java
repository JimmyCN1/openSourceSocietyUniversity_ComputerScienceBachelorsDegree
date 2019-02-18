package model;


import java.util.Random;


public class Coin {

    private String coinStatus;

    // MODIFIES: this
    // EFFECTS: sets the status of the coin to heads or tails
    public void flipCoin() {
        Random random = new Random();
        Integer booleanCoin;
        booleanCoin = random.nextInt(2);
        if (booleanCoin == 0) {
            this.coinStatus = "heads";
        } else {
            this.coinStatus = "tails";
        }
    }

    // EFFECTS: returns coinStatus
    public String checkCoinStatus() { return this.coinStatus; }


}
