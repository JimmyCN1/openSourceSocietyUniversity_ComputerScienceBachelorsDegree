package ui;

import model.Coin;

public class main {

    public static final int FLIP_COUNT = 1000;

    public static void main(String[] args) {

        Coin coin1 = new Coin();


        for(int flips = 0; flips < FLIP_COUNT; flips++) {
            coin1.flipCoin();
            coin1.printCoinStatus();
            coin1.printStreaks();
            coin1.getLongestStreak();
        }

        coin1.printLongestStreak();




    }
}
