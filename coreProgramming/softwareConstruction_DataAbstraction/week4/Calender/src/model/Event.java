package model;

import java.time.*;

public class Event extends Entry {
    private LocalDateTime reminder;

    public Event(String date, String time, String label, boolean repeating, Integer repetitionInterval) {
        super(date, time, label, repeating, repetitionInterval);
        this.reminder = reminder;
    }

    //getter:
    public LocalDateTime getReminder() { return this.reminder; }

    //MODIFES: this
    //EFFECTS: sets a reminder 3 days before the event
    //public void setReminder(LocalDateTime reminder) { this.reminder = reminder; }
}
