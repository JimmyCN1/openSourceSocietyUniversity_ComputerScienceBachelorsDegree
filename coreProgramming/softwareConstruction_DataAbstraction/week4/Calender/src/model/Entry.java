package model;

import java.sql.Time;
import java.util.Date;

public abstract class Entry {
    private Date date;
    private Time time;
    private String label;
    private boolean repeating;
    private Integer repetitionInterval;

    public Entry(Date date, Time time, String label, boolean repeating, Integer repetitionInterval) {
        this.date = date;
        this.time = time;
        this.label = label;
        this.repeating = repeating;
        this.repetitionInterval = repetitionInterval;
    }

    //getters:
    public Date getDate() { return this.date; }
    public Time getTime() { return this.time; }
    public String getLabel() { return this.label; }
    public boolean getRepeating() { return this.repeating; }
    public Integer getRepetitionInterval() { return this.repetitionInterval; }

    //setters:
    public void setRepetitionInterval(Integer interval) { this.repetitionInterval = repetitionInterval; }



}
