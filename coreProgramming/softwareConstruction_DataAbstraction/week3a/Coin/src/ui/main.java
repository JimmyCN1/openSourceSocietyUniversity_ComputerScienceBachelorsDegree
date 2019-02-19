package ui;

import model.Coin;

public class main {

    public static final int FLIP_COUNT = 100;

    public static void main(String[] args) {

        Coin coin1 = new Coin();


        for(int flips = 0; flips < FLIP_COUNT; flips++) {
            coin1.flipCoin();
            System.out.println(coin1.getCoinStatus());
        }




    }
}
