package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Entry {
    private Calender calender;
    private String entrysDate;
    private String entrysTime;
    private String label;
    private boolean repeating;
    private Integer repetitionInterval;
    private LocalDate date;
    private LocalTime time;

    public Entry(Calender calender, String entrysDate, String entrysTime, String label, boolean repeating, Integer repetitionInterval) {
        this.calender = calender;
        this.entrysDate = entrysDate;
        this.entrysTime = entrysTime;
        this.label = label;
        this.repeating = repeating;
        this.repetitionInterval = repetitionInterval;
        this.date = getDate();
        this.time = getTime();
    }

    //MODIFIES: this
    //EFFECTS: set the date variable with the LocalDate format
    private LocalDate date() {
        LocalDate date = null;
        if (this.entrysDate != null) {
            date = LocalDate.parse(this.entrysDate);
        }
        return date;
    }

    //MODIFIES: this
    //EFFECTS: set the time variable with the LocalTime format
    private LocalTime time() {
        LocalTime time = null;
        if (this.entrysTime != null) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            time = LocalTime.parse(this.entrysTime, timeFormatter);
        }
        return time;
    }

    //getters:
    public Calender getCalender() { return this.calender; }
    public String getStringDate() { return this.entrysDate; }
    public String getStringTime() { return this.entrysTime; }
    public String getLabel() { return this.label; }
    public boolean getRepeating() { return this.repeating; }
    public Integer getRepetitionInterval() { return this.repetitionInterval; }
    public LocalDate getDate() { return date(); }
    public LocalTime getTime() { return time(); }

    //setters:
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(LocalTime time) { this.time = time; }
    public void setLabel(String label) { this.label = label; }
    public void setRepeating(boolean repeating) { this.repeating = repeating; }

    //REQUIRES: Interger 0 <= x <= 365, repeating must equal true
    //MODIFIES: this
    //EFFECTS: determines how many days pass until the entry occurs again in the calender
    public void setRepetitionInterval(Integer interval) {
        if (this.repeating == true) {
            if (interval >= 0 && interval <= 365) {
                this.repetitionInterval = repetitionInterval;
            }
        }
    }


//    //ABSTRACT FUNCTIONS FOR EVENT
//
//    //getter:
//    public abstract LocalDate getReminderDate();
//
//    //MODIFES: this
//    //EFFECTS: sets a reminderDate 3 days before the event
//    public abstract Entry makeReminder();
//
//
//    //ABSTRACT FUNCTIONS FOR Meeting
//
//    public abstract List<String> getEmailAddressesOfAttendees();
//
//    //REQUIRES: email address not already in the list attendees
//    //MODIFIES: this
//    //EFFECTS: adds a new email address to the list of attendees
//    public abstract void addEmailAddressesOfAttendees();
//
//    //REQUIRES: email address is in the list of attendees
//    //MODIFIES: this
//    //EFFECTS: removes the invitee with the passed email address
//    public abstract void removeEmailAddressesOfAttendees();
//
//    //REQUIRES: list of email addresses of attendees not empty
//    //MODIFIES: this
//    //EFFECTS: sends and invitation to every email in the list
//    public abstract void sendInvitations();
//
//
//    //ABSTRACT FUNCTIONS FOR Reminder
//
//    //EFFECTS: get the additional note
//    public abstract String getNote();
//
//    //MODIFIES: this
//    //EFFECTS: set an additional note
//    public abstract void setNote(String note);

}
