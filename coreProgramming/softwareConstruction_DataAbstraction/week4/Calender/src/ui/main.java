package ui;

import model.*;

import java.time.LocalDateTime;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Calender calender = new Calender(
                LocalDateTime.now().toLocalDate(),
                LocalDateTime.now().toLocalTime(),
                "123@gmail.com");

        Entry bday1 = new Event("2019-04-19","00:00","My Birthday",false,365);
        Entry bday2 = new Event("2019-03-11","07:00","bro1 bday",true,365);
        Entry bday3 = new Event("2019-03-18","16:00","bro2 bday",true,366);

        Entry meeting1 = new Meeting("2019-08-11", "08:00", "tyre meeting", true, 7,
                Arrays.asList("123@meme.com", "456@meme.com", "789@meme.com"));
        Entry meeting2 = new Meeting("2019-06-11", "12:00", "cake meeting", true, 31,
                Arrays.asList("abc@meme.com", "def@meme.com", "ghij@meme.com"));

        Entry reminder1 = new Reminder("2019-12-31", "00:00", "newYearsEve", false, 0, "bring presents");
        Entry reminder2 = new Reminder("2019-10-15", "18:30", "donday", false, 0, "help yourself");
        Entry reminder3 = new Reminder("2019-08-29", "13;40", "ag", true, 21, "ery 3 weeks");

        calender.addEntry(bday1);
        calender.addEntry(bday2);
        calender.addEntry(bday3);
        calender.addEntry(meeting1);
        calender.addEntry(meeting2);
        calender.addEntry(reminder1);
        calender.addEntry(reminder2);
        calender.addEntry(reminder3);

        calender.getFirstEntry();
    }
}
