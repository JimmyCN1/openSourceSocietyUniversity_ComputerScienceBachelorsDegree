package model;

public class Time {
    private Integer hour;
    private Integer minute;

    public Time(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    //getters:
    public Integer getHour() { return this.hour; }
    public Integer getMinute() { return this.minute; }
    public String getTime() {
        String time = this.hour.toString() + ":" + this.minute.toString();
        return time;
    }
}
