package model;

public interface IntegerSet {
    // MODIFIES: this
    // EFFECTS: inserts num if not already there
    //          if num is there, does nothing
    void insert(Integer num);

    // MODIFIES: this
    // EFFECTS: if the integer is in the integer set, then remove it from the integer set,
    //          Otherwise, do nothing
    void remove(Integer num);

    // EFFECTS: if the integer is contained in the set, return true. Otherwise return false
    boolean contains(Integer num);

    // EFFECTS: returns the size of the set
    int size();
}
