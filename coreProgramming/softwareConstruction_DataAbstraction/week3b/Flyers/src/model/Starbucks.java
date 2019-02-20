package model;

public class Starbucks implements Cafe {
    @Override
    public void serveDrinks() {
        System.out.println("Serving drinks");
    }

    @Override
    public void serveSnacks() {
        System.out.println("Serving food");
    }
}
