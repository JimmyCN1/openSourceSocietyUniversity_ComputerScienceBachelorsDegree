package model;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


public class Calender {
    private LocalDate currentDate;
    private LocalTime currentTime;
    private String associatedEmail;
    private List<Entry> entries = new ArrayList<Entry>();

    public Calender(String associatedEmail) {
        setDate();
        setTime();
        this.associatedEmail = associatedEmail;
        this.entries = getEntries();
    }

    //getters:
    public LocalDate getCurrentDate() { return this.currentDate; }
    public LocalTime getCurrentTime() { return this.currentTime; }
    public String getAssociatedEmail() { return this.associatedEmail; }
    public List<Entry> getEntries() { return this.entries; }

    //setters:
    public void setDate() { this.currentDate = LocalDateTime.now().toLocalDate(); }
    public void setTime() { this.currentTime = LocalDateTime.now().toLocalTime(); }
    public void setAssociatedEmail(String associatedEmail) { this.associatedEmail = associatedEmail; }

    //REQUIRES: list already in chronological order
    //MODIFIES: this
    //EFFECTS: adds one entry to the list of entries in chronological order
    public void addEntry(Entry entry) {
        boolean added = false;
        if (this.entries.size() == 0) {
            this.entries.add(entry);
        }
        if (!this.entries.contains(entry)) {
            for (Integer i = 0; i < this.entries.size(); i++) {
                if (entry.getDate().isBefore(this.getEntries().get(i).getDate())) {
                    this.entries.add(i, entry);
                    added = true;
                    break;
                }
            }
            if (added == false) {
                this.entries.add(entry);
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
    public void printEntries() {
        if (this.entries.size() != 0) {
            for (Entry e : this.entries) {
                this.printEntry(e);
//                System.out.println("Date: " + e.getDate() + "\nTime: " + e.getTime() + "\nLabel: " + e.getLabel() + "\n");
            }
        }
    }

    //REQUIRES: entry not null
    //EFFECTS: prints out every detail of an entry
    public void printEntry(Entry entry) {
        System.out.println(
                "Date: " + entry.getDate() +
                "\nTime: " + entry.getTime() +
                "\nLabel: " + entry.getLabel() +
                "\nRepeating: " + entry.getRepeating() +
                "\nRepitition Interval: " + entry.getRepetitionInterval() + " days\n");
    }

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












