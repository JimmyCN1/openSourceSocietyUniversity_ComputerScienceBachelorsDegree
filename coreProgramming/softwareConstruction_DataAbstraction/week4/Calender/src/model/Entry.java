package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Entry {
    private String entrysDate;
    private String entrysTime;
    private String label;
    private boolean repeating;
    private Integer repetitionInterval;
    private LocalDate date;
    private LocalTime time;

    public Entry(String entrysDate, String entrysTime, String label, boolean repeating, Integer repetitionInterval) {
        this.entrysDate = entrysDate;
        this.entrysTime = entrysTime;
        this.label = label;
        this.repeating = repeating;
        this.repetitionInterval = repetitionInterval;
        this.date = getDate();
        this.time = getTime();
    }

    //    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    private LocalDate date() { return LocalDate.parse(this.entrysDate); }

    private LocalTime time() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(this.entrysTime, timeFormatter);
    }

    //getters:
    public LocalDate getDate() { return date(); }
    public LocalTime getTime() { return time(); }
    public String getLabel() { return this.label; }
    public boolean getRepeating() { return this.repeating; }
    public Integer getRepetitionInterval() { return this.repetitionInterval; }

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


    //ABSTRACT FUNCTIONS FOR EVENT

    //getter:
    public abstract LocalDate getReminderDate();

    //MODIFES: this
    //EFFECTS: sets a reminderDate 3 days before the event
    public abstract void setReminder();


    //ABSTRACT FUNCTIONS FOR Meeting

    public abstract List<String> getEmailAddressesOfAttendees();

    //REQUIRES: email address not already in the list attendees
    //MODIFIES: this
    //EFFECTS: adds a new email address to the list of attendees
    public abstract void addEmailAddressesOfAttendees();

    //REQUIRES: email address is in the list of attendees
    //MODIFIES: this
    //EFFECTS: removes the invitee with the passed email address
    public abstract void removeEmailAddressesOfAttendees();

    //REQUIRES: list of email addresses of attendees not empty
    //MODIFIES: this
    //EFFECTS: sends and invitation to every email in the list
    public abstract void sendInvitations();


    //ABSTRACT FUNCTIONS FOR Reminder

    //EFFECTS: get the additional note
    public abstract String getNote();

    //MODIFIES: this
    //EFFECTS: set an additional note
    public abstract void setNote(String note);

}
