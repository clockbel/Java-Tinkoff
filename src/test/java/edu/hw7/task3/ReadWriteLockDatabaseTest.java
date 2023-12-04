package edu.hw7.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadWriteLockDatabaseTest {
    @Test
    @DisplayName("Проверка корректного добавления, удаления и поиска человека, который есть в списке")
    public void testDataBaseWork() throws InterruptedException {
        ReadWriteLockPersonDatabase readWriteLockPersonDatabase = new ReadWriteLockPersonDatabase();
        AtomicBoolean phoneFound = new AtomicBoolean(false);
        AtomicBoolean nameFound = new AtomicBoolean(false);
        AtomicBoolean addressFound = new AtomicBoolean(false);

        Thread addThread1 = new Thread(() -> {
            readWriteLockPersonDatabase.add(new Person(1, "Misha", "Pobeda St", "4443-121"));
            readWriteLockPersonDatabase.add(new Person(2, "Ruslan", "Tukai St", "2221-122"));
        });

        Thread addThread2 = new Thread(() -> {
            readWriteLockPersonDatabase.add(new Person(3, "Rail", "Ershova St", "4143-121"));
            readWriteLockPersonDatabase.add(new Person(4, "Ilnar", "Iamashevo St", "3221-122"));
        });

        Thread deleteThread = new Thread(() -> {
            readWriteLockPersonDatabase.delete(2);
        });

        Thread searchThread2 = new Thread(() -> {
            List<Person> adressList = readWriteLockPersonDatabase.findByAddress("Pobeda St");
            addressFound.set(!adressList.isEmpty());
        });

        Thread searchThread = new Thread(() -> {
            List<Person> phoneList = readWriteLockPersonDatabase.findByPhone("3221-122");
            phoneFound.set(!phoneList.isEmpty());

        });

        Thread searchThread3 = new Thread(() -> {
            List<Person> nameList = readWriteLockPersonDatabase.findByName("Rail");
            nameFound.set(!nameList.isEmpty());
        });

        addThread1.start();
        addThread2.start();

        sleep(1000);
        deleteThread.start();
        searchThread.start();
        searchThread2.start();
        searchThread3.start();

        try {
            addThread1.join();
            addThread2.join();
            deleteThread.join();
            searchThread.join();
            searchThread2.join();
            searchThread3.join();

            assertEquals(readWriteLockPersonDatabase.getDatabase().size(), 3);
            assertTrue(phoneFound.get());
            assertTrue(nameFound.get());
            assertTrue(addressFound.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Проверка поиска человека, которого нет в списке")
    public void testDataBaseFindNonExistingPerson() {
        ReadWriteLockPersonDatabase synchronizedPersonDatabase = new ReadWriteLockPersonDatabase();
        AtomicBoolean phoneFound = new AtomicBoolean(false);
        AtomicBoolean nameFound = new AtomicBoolean(false);
        AtomicBoolean addressFound = new AtomicBoolean(false);

        Thread addThread1 = new Thread(() -> {
            synchronizedPersonDatabase.add(new Person(1, "Misha", "Pobeda St", "4443-121"));
            synchronizedPersonDatabase.add(new Person(2, "Ruslan", "Tukai St", "2221-122"));
        });

        Thread searchThread2 = new Thread(() -> {
            List<Person> adressList;
            adressList = synchronizedPersonDatabase.findByAddress("Trump");
            addressFound.set(!adressList.isEmpty());
        });

        Thread searchThread = new Thread(() -> {
            List<Person> phoneList;
            phoneList = synchronizedPersonDatabase.findByPhone("5552-1118");
            phoneFound.set(!phoneList.isEmpty());

        });

        Thread searchThread3 = new Thread(() -> {
            List<Person> nameList;
            nameList = synchronizedPersonDatabase.findByName("Carl");
            nameFound.set(!nameList.isEmpty());
        });

        addThread1.start();
        searchThread.start();
        searchThread2.start();
        searchThread3.start();

        try {
            addThread1.join();
            searchThread.join();
            searchThread2.join();
            searchThread3.join();

            assertFalse(phoneFound.get());
            assertFalse(nameFound.get());
            assertFalse(addressFound.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
