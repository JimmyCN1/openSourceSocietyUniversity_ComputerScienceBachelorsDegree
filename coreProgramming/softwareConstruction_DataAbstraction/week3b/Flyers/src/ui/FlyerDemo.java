package ui;

import model.*;

public class FlyerDemo {
    public static void main(String[] args) {
        Bird birdie = new Bird();
        Airplane planie = new Airplane();
        Cafe cafePlane = new Airplane();
        Flyer flyerPlane = new Airplane();
        Starbucks hillside = new Starbucks();

        birdie.fly();
        planie.serveDrinks();
        cafePlane.serveSnacks();
        hillside.serveDrinks();
        hillside.serveSnacks();
        flyerPlane.land();

        FlyerDemo fd = new FlyerDemo();
        fd.lunchService(cafePlane);
        fd.firstPartOfFlight(planie);
    }

    public void lunchService(Cafe c) {
        c.serveDrinks();
        c.serveSnacks();
        c.serveSnacks();
    }

    public void firstPartOfFlight(Airplane a) {
        a.takeoff();
        a.serveDrinks();
        a.fly();
    }
}
