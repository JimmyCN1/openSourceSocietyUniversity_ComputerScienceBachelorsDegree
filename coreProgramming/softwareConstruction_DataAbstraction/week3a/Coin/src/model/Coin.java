package model;


import java.util.Random;


public class Coin {
    private String coinStatus;
    private String lastStatus;
    private Integer currentStreak;
    private Integer consecutiveResultCount;
    private Integer longestConsecutiveResultCount;

    public Coin() {
        coinStatus = "";
        lastStatus = "";
        currentStreak = 0;
        consecutiveResultCount = 0;
        longestConsecutiveResultCount = 0;
    }

    // EFFECTS: returns coinStatus
    public String getCoinStatus() { return this.coinStatus; }

    //EFFECTS: sets coinStatus
    public void setCoinStatus(String status) { this.coinStatus = status; }

    // MODIFIES: this
    // EFFECTS: sets the status of the coin to heads or tails
    public void flipCoin() {
        lastStatus = coinStatus;
        Random random = new Random();
        Integer booleanCoin;
        booleanCoin = random.nextInt(2);
        if (booleanCoin == 0) {
            setCoinStatus("heads");
        } else {
            setCoinStatus("tails");
        }
    }

    //EFFECTS: returns the current number of times the coin has landed on the same side consecutively
    public Integer getCurrentStreak() {
        if (coinStatus.equals(lastStatus)) {
            consecutiveResultCount++;
        } else {
            consecutiveResultCount = 0;
        }
        return consecutiveResultCount;
    }

    public Integer getLongestStreak() {
        if (consecutiveResultCount > longestConsecutiveResultCount) {
            longestConsecutiveResultCount = consecutiveResultCount;
        }
        return longestConsecutiveResultCount;
    }

    //EFFECTS: prints the current coin status
    public void printCoinStatus() {
        System.out.print("Coin toss landed on " + this.coinStatus + ". \t\t");
    }

    //EFFECTS: prints the current streak
    public void printStreaks() {
        System.out.print("Current Streak: " + Integer.toString(this.getCurrentStreak()) + "\n");
    }

    //EFFECTS: prints the longest streak that occurred
    public void printLongestStreak() {
        System.out.println("\n\n\t\t\tLongest Streak: " + Integer.toString((this.getLongestStreak())) + "\n");
    }
}
