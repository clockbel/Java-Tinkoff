package edu.hw3.Task5;

public record Contact(String firstName, String secondName) {
    public Contact(String firstName) {
        this(firstName, null);
    }
}
