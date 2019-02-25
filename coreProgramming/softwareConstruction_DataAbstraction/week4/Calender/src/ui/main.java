package ui;

import model.Calender;
import model.Entry;
import model.Event;

import java.time.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Calender calender = new Calender(LocalDateTime.now(), "123@gmail.com");

        Entry bday1 = new Event(
                LocalDateTime.of(2019),
                "My Birthday",
                false,
                365);
        Entry bday2 = new Event(
                new LocalDateTime()
        )
    }
}
