package model;

import java.time.*;

public class Event extends Entry {
    private LocalDateTime reminder;

    public Event(LocalDateTime dateTime, String label, boolean repeating, Integer repetitionInterval , LocalDateTime reminder) {
        super(dateTime, label, repeating, repetitionInterval);
        this.reminder = reminder;
    }

    //getter:
    public LocalDateTime getReminder() { return this.reminder; }

    //setter:
    public void setReminder(LocalDateTime reminder) { this.reminder = reminder; }
}
