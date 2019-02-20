package model;

public class Airplane implements Flyer, Cafe {
    @Override
    public void serveDrinks() {
        System.out.println("Serving airplane drinks");
    }

    @Override
    public void serveSnacks() {
        System.out.println("Serving airplaine snacks");
    }

    @Override
    public void takeoff() {
        System.out.println("Taking off!!");
    }

    @Override
    public void fly() {
        System.out.println("Flying along -- no turbulence!");
    }

    @Override
    public void land() {
        System.out.println("Fasten you seatbelts -- landing!");
    }
}
