package ui;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;

//private static Calender calender = new Calender("123@gmail.com");

public class main {
    public static void main(String[] args) {
        Calender calender = new Calender("123@gmail.com");

        Entry bday1 = new Event(calender,"2019-04-19","00:00","My Birthday",false,0);
        Entry bday2 = new Event(calender,"2019-03-11","07:00","bro1 bday",true,365);
        Entry bday3 = new Event(calender,"2019-03-18","16:00","bro2 bday",true,366);

        Entry meeting1 = new Meeting(calender ,"2019-08-11", "08:00", "tyre meeting", true, 7,
                new ArrayList<String>(Arrays.asList("123@meme.com", "456@meme.com", "789@meme.com")));
        Entry meeting2 = new Meeting(calender,"2019-06-11", "12:00", "cake meeting", true, 31,
                new ArrayList<String>(Arrays.asList("abc@meme.com", "def@meme.com", "ghij@meme.com")));

        Entry reminder1 = new Reminder(calender,"2019-12-31", "00:00", "newYearsEve", false, 0);
        Entry reminder2 = new Reminder(calender,"2019-10-15", "18:30", "donday", false, 0);
        Entry reminder3 = new Reminder(calender,"2019-08-29", "13:40", "ag", true, 21);


        Entry firstEntry = calender.getFirstEntry();
        calender.printEntries();
        calender.removeEntry(reminder3);
        Entry entryWithLabel = calender.getEntryWithLabel("donday");
        System.out.println(firstEntry.getLabel());
        System.out.println(entryWithLabel.getLabel());
        System.out.println("");


        System.out.println(((Meeting) meeting1).getEmailAddressesOfAttendees());
        ((Meeting) meeting1).addEmailAddressesOfAttendees("jaklsdg@hotmail.com");
        System.out.println(((Meeting) meeting1).getEmailAddressesOfAttendees());

        Meeting m = (Meeting) calender.getEntryWithLabel("tyre meeting");
        m.getEmailAddressesOfAttendees();
        System.out.println(m);
        m.removeEmailAddressesOfAttendees("456@meme.com");
        m.sendInvitations();
        System.out.println("");


        System.out.println(calender.getCurrentDate());
        System.out.println(calender.getCurrentTime());
        System.out.println(calender.getAssociatedEmail());
    }

}
