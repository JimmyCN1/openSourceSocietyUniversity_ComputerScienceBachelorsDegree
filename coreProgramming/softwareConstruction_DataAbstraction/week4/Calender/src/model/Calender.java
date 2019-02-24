package model;

public class Calender {
    private Date currentDate;
    private String associatedEmail;

    public Calender(Date currentDate, String associatedEmail) {
        this.currentDate = currentDate;
        this.associatedEmail = associatedEmail;
    }

    //getters:
    public Date getCurrentDate() { return this.currentDate; }
    public String getAssociatedEmail() { return this.associatedEmail; }

    //setters:
    public void setCurrentDate(Date currentDate) { this.currentDate = currentDate; }
    public void setAssociatedEmail(String associatedEmail) { this.associatedEmail = associatedEmail; }


}
