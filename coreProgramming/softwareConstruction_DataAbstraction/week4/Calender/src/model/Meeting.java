package model;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event {
    private List<String> emailAddressesOfAttendees = new ArrayList<String>();

    public Meeting(String date, String time, String label, boolean repeating, Integer repetitionInterval, List<String> emailAddressesOfAttendees) {
        super(date, time, label, repeating, repetitionInterval);
        this.emailAddressesOfAttendees = emailAddressesOfAttendees;
    }

    //getter:
    public List<String> getEmailAddressesOfAttendees() { return this.emailAddressesOfAttendees; }

    //REQUIRES: email address not already in the list attendees
    //MODIFIES: this
    //EFFECTS: adds a new email address to the list of attendees
    public void addEmailAddressesOfAttendees(String emailAddress) {
        if (!this.emailAddressesOfAttendees.contains(emailAddress)) {
            this.emailAddressesOfAttendees.add(emailAddress);
        }
    }

    //REQUIRES: email address is in the list of attendees
    //MODIFIES: this
    //EFFECTS: removes the invitee with the passed email address
    public void removeEmailAddressesOfAttendees(String emailAddress) {
        if (this.emailAddressesOfAttendees.contains(emailAddress)) {
            for (String email : this.emailAddressesOfAttendees) {
                if (email == emailAddress) {
                    this.emailAddressesOfAttendees.remove(email);
                    break;
                }
            }
        }
    }

    //REQUIRES: list of email addresses of attendees not empty
    //MODIFIES: this
    //EFFECTS: sends and invitation to every email in the list
    public void sendInvitations() {
        if (this.emailAddressesOfAttendees.size() != 0) {
            for (String email : this.emailAddressesOfAttendees) {
                System.out.println("Inviting: " + email);
            }
        }
    }
}
