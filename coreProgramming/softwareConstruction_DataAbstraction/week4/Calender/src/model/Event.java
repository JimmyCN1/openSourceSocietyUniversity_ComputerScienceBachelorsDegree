package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Event extends Entry {
//    private LocalDate reminderDate;

    public Event(Calender calender, String date, String time, String label, boolean repeating, Integer repetitionInterval) {
        super(calender, date, time, label, repeating, repetitionInterval);
        this.getCalender().addEntry(this);
        makeReminder();
    }

//    //getter:
//    public LocalDate getReminderDate() { return this.reminderDate; }

    //MODIFES: this
    //EFFECTS: sets a reminderDate 3 days before the event
    public void makeReminder() {
        Reminder reminder = null;
        Scanner scanner = new Scanner(System.in);
        LocalDate reminderDate = this.getDate().plusDays(362);
        System.out.println("would you live to set a reminder for this event? Type 'yes' or 'no'");
        String response = scanner.nextLine();
        if (response.equals("yes")) {
            reminder = new Reminder(this.getCalender(), reminderDate.toString(), this.getStringTime(), this.getLabel() + " is in 3 days.", this.getRepeating(), this.getRepetitionInterval());
            reminder.setDate(reminderDate);
            System.out.println("Would you like to add a note for this reminder? Type 'yes' or 'no'");
            response = scanner.nextLine();
            if (response.equals("yes")) {
                System.out.println("Please type your note:");
                response = scanner.nextLine();
                reminder.setNote(response);
                this.getCalender().addEntry(reminder);
            }
        }
    }
}
