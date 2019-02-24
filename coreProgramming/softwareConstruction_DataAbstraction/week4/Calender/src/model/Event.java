package model;

public class Event extends Entry {
    private Date reminder;

    public Event(Date date, Time time, String label, boolean repeating, Integer repetitionInterval, Date reminder) {
        super(date, time, label, repeating, repetitionInterval);
        this.reminder = reminder;
    }

    //getter:
    public Date getReminder() { return this.reminder; }

    //setter:
    public void setReminder(Date reminder) { this.reminder = reminder; }
}
