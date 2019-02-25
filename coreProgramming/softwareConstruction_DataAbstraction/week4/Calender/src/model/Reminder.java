package model;

import java.sql.Time;
import java.util.Date;

public class Reminder extends Entry {
    private String note;

    public Reminder(Date date, Time time, String label, boolean repeating, Integer repetitionInterval, String note) {
        super(date, time, label, repeating, repetitionInterval);
        this.note = note;
    }

    //EFFECTS: get the additional note
    public String getNote() { return this.note; }

    //MODIFIES: this
    //EFFECTS: set an additional note
    public void setNote(String note) { this.note = note; }
}
