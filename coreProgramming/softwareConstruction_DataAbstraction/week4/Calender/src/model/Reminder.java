package model;

public class Reminder extends Entry {
    private String note;

    public Reminder(Calender calender, String date, String time, String label, boolean repeating, Integer repetitionInterval) {
        super(calender, date, time, label, repeating, repetitionInterval);
        this.getCalender().addEntry(this);
    }

    //EFFECTS: get the additional note
    public String getNote() { return this.note; }

    //MODIFIES: this
    //EFFECTS: set an additional note
    public void setNote(String note) { this.note = note; }

}
