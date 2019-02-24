package model;

import java.text.DateFormatSymbols;

public class Date {
    private Integer month;
    private Integer day;
    private Integer year;

    public Date(Integer month, Integer date, Integer year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //getters:
    public Integer getMonth() { return this.month; }
    public Integer getDay() { return this.day; }
    public Integer getYear() { return this.year; }
    public String getDateShort() {
        String date = this.day.toString() + "-" + this.month + "-" + this.year;
        return date;
    }
    public String getDateLong() {
        String date = this.getMonth(this.month) + " " + this.day.toString() + ", " + this.year;
        return date;
    }
    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }
}
