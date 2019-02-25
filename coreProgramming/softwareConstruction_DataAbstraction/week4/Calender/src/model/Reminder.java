package model;

import java.time.LocalDateTime;

public class Reminder extends Entry {
    private String note;

    public Reminder(LocalDateTime dateTime, String label, boolean repeating, Integer repetitionInterval, String note) {
        super(dateTime, label, repeating, repetitionInterval);
        this.note = note;
    }

    //EFFECTS: get the additional note
    public String getNote() { return this.note; }

    //MODIFIES: this
    //EFFECTS: set an additional note
    public void setNote(String note) { this.note = note; }
}
