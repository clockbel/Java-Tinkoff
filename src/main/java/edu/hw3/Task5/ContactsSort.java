package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ContactsSort {
    private ContactsSort() {
    }

    private static final String WHITE_SPACE = " ";

    public static List<Contact> parseContacts(List<String> contacts, String choice) {
        if (contacts == null) {
            return new ArrayList<>();
        }

        List<Contact> sortedContacts = contactsList(contacts);
        sortedContacts.sort((o1, o2) -> {
            String firstContact = o1.secondName();
            String secondContact = o2.secondName();
            int sortChoice = 1;
            if (firstContact == null) {
                firstContact = o1.firstName();
            }
            if (secondContact == null) {
                secondContact = o2.firstName();
            }
            if (!Objects.equals(choice, "ASC")) {
                sortChoice = -sortChoice;
            }
            return firstContact.compareTo(secondContact) * sortChoice;
        });
        return sortedContacts;
    }

    private static List<Contact> contactsList(List<String> contacts) {
        List<Contact> contactList = new ArrayList<>();
        String[] personData;
        for (String person : contacts) {
            personData = person.split(WHITE_SPACE);
            if (personData.length == 1) {
                contactList.add(new Contact(personData[0]));
            } else {
                contactList.add(new Contact(personData[0], personData[1]));
            }
        }
        return contactList;
    }
}
