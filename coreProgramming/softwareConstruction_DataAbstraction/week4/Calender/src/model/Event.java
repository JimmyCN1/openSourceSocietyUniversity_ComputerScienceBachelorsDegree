package model;

import java.time.*;
import java.util.Scanner;

public class Event extends Entry {
//    private LocalDate reminderDate;

    public Event(String date, String time, String label, boolean repeating, Integer repetitionInterval) {
        super(date, time, label, repeating, repetitionInterval);
    }

    //getter:
//    public LocalDate getReminderDate() { return this.reminderDate; }

    //MODIFES: this
    //EFFECTS: sets a reminderDate 3 days before the event
    public void setReminder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("would you live to set a reminder for this event? Type 'yes' or 'no'");
        String response = scanner.nextLine();
        if (response == "yes") {
            //set reminder
        }
    }
}
