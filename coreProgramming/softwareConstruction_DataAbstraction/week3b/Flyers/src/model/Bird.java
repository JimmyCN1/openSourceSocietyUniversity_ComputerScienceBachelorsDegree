package model;

public class Bird implements Flyer{
    @Override
    public void takeoff() {
        System.out.println("Flap flap flap jump");
    }

    @Override
    public void fly() {
        System.out.println("Glide glide glide");
    }

    @Override
    public void land() {
        System.out.println("Flap hop run run");
    }
}
