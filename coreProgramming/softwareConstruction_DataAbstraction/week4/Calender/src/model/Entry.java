package model;

import java.time.*;

public abstract class Entry {
    private LocalDateTime entrysDate;
    private LocalDateTime entrysTime;
    private String label;
    private boolean repeating;
    private Integer repetitionInterval;

    public Entry(LocalDateTime entrysDate, LocalDateTime entrysTime, String label, boolean repeating, Integer repetitionInterval) {
        this.entrysDate = entrysDate;
        this.entrysTime = entrysTime;
        this.label = label;
        this.repeating = repeating;
        this.repetitionInterval = repetitionInterval;
    }

    //getters:
    public LocalDateTime getEntrysDate() { return this.entrysDate; }
    public LocalDateTime getEntrysTime() { return this.entrysTime; }
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
