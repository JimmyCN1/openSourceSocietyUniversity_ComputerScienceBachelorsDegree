package model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public abstract class Entry {
    private String entrysDate;
    private String entrysTime;
    private String label;
    private boolean repeating;
    private Integer repetitionInterval;

//    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    private LocalDate date = LocalDate.parse(this.entrysDate);

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime time = LocalTime.parse(this.entrysTime, this.timeFormatter);

    public Entry(String entrysDate, String entrysTime, String label, boolean repeating, Integer repetitionInterval) {
        this.entrysDate = entrysDate;
        this.entrysTime = entrysTime;
        this.label = label;
        this.repeating = repeating;
        this.repetitionInterval = repetitionInterval;
    }

    //getters:
    public LocalDate getDate() { return this.date; }
    public LocalTime getTime() { return this.time; }
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




}
