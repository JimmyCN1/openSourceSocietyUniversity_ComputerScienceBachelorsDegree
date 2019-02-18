package ui;

import model.Coin;

public class main {

    public static void main(String[] args) {

        Coin coin1 = new Coin();
        coin1.flipCoin();
        System.out.println(coin1.checkCoinStatus());



    }
}
