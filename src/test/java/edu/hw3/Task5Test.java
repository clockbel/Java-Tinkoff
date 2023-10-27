package edu.hw3;

import edu.hw3.Task5.Contact;
import edu.hw3.Task5.ContactsSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        List<String> person = List.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"});
        List<Contact> result = new ArrayList<>();
        result.add(new Contact("Thomas", "Aquinas"));
        result.add(new Contact("Rene", "Descartes"));
        result.add(new Contact("David", "Hume"));
        result.add(new Contact("John", "Locke"));
        assertThat(ContactsSort.parseContacts(person, "ASC")).isEqualTo(result);
    }

    @Test
    @DisplayName("Test2")
    public void Test2() {
        List<String> person = List.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"});
        List<Contact> result = new ArrayList<>();
        result.add(new Contact("Carl", "Gauss"));
        result.add(new Contact("Leonhard", "Euler"));
        result.add(new Contact("Paul", "Erdos"));
        assertThat(ContactsSort.parseContacts(person, "DESC")).isEqualTo(result);
    }
    @Test
    @DisplayName("Test3")
    public void Test3() {
        List<String> person = new ArrayList<>();
        List<Contact> result = new ArrayList<>();
        assertThat(ContactsSort.parseContacts(person, "DESC")).isEqualTo(result);
    }
    @Test
    @DisplayName("Test4")
    public void Test4() {
        List<Contact> result = new ArrayList<>();
        assertThat(ContactsSort.parseContacts(null, "DESC")).isEqualTo(result);
    }
}
