//package model;
//
//import java.text.DateFormatSymbols;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class OurDateTime {
//    private Date datetime;
//
//    public OurDateTime() {
//    }
//
//    //getters:
//    public Integer getMonth() { return this.month; }
//    public Integer getDay() { return this.day; }
//    public Integer getYear() { return this.year; }
//
//    public java.util.Date getDateShort() throws ParseException {
//        String dateString = this.day.toString() + "-" + this.month + "-" + this.year;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        java.util.Date date = dateFormat.parse(dateString);
//        return date;
//    }
//
//    public String getDateLong() {
//        String date = this.getMonth(this.month) + " " + this.day.toString() + ", " + this.year;
//        return date;
//    }
//    public String getMonth(int month) {
//        return new DateFormatSymbols().getMonths()[month-1];
//    }
//}
