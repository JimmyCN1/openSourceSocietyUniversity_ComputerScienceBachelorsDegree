package model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.*;
import java.util.List;


public class Calender {
    private String currentDate;
    private String currentTime;
    private String associatedEmail;
    private List<Entry> entries = new ArrayList<Entry>();

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDateTime date = LocalDateTime.parse(currentDate, dateFormatter);

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private LocalDateTime time = LocalDateTime.parse(currentTime, timeFormatter);



    public Calender(String currentDate, String currentTime, String associatedEmail) {
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.associatedEmail = associatedEmail;
        this.entries = getEntries();
    }

    //getters:
    public LocalDateTime getDate() { return this.date; }
    public LocalDateTime getTime() { return this.time; }
    public String getAssociatedEmail() { return this.associatedEmail; }
    public List<Entry> getEntries() { return this.entries; }

    //setters:
    public void setDate(LocalDateTime date) { this.date = date; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public void setAssociatedEmail(String associatedEmail) { this.associatedEmail = associatedEmail; }

    //REQUIRES: list already in chronological order
    //MODIFIES: this
    //EFFECTS: adds one entry to the list of entries in chronological order
    public void addEntry(Entry entry) {
        List<Entry> newEntryList = new ArrayList<Entry>();
        if (this.entries.size() == 0) {
            this.entries.add(entry);
        }
        if (!this.entries.contains(entry)) {
            for (Integer i = 0; i < this.entries.size(); i++) {
                if (entry.getEntrysDate().before(this.getEntries().get(i).getEntrysDate())) {
                    this.entries.add(i, entry);
                    break;
                }
            }
        }
    }

    //REQUIRES: list to contain given entry
    //MODIFIES: this
    //EFFECTS: removes given entry from the list
    public void removeEntry(Entry entry) {
        if (this.entries.contains(entry)) {
            for (Entry e : this.entries) {
                if (e.equals(entry)) {
                    this.entries.remove(e);
                    break;
                }
            }
        }
    }

    //REQUIRES: list must not be empty
    //EFFECTS: prints out every entry in the list
//    public void printEntries() {
//        if (this.entries.size() != 0) {
//            for (Entry e : this.entries) {
//                System.out.println("OurDateTime: " + e.getEntrysDate() + "\nTime: " + e.getEntrysTime() + "\nLabel: " + e.getLabel() + "\n");
//            }
//        }
//    }

    //REQUIRES: list must already be in chronological order
    //MODIFIES: this
    //EFFECTS: returns the soonest entry (first entry in the list of entries)
    public Entry getFirstEntry() {
        return this.entries.get(0);
    }

    //REQUIRES: entries list not size 0
    //MODIFIES: this
    //EFFECTS: returns the entry with the name of label, else returns null
    public Entry getEntryWithLabel(String label) {
        Entry entry = null;
        if (this.entries.size() != 0) {
            for (Entry e : this.entries) {
                if (e.getLabel() == label) {
                    entry = e;
                }
            }
        }
        return entry;
    }
}












