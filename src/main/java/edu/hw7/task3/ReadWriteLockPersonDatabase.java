package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> persons = new HashMap<>();
    private final Map<String, List<Person>> nameIndex = new HashMap<>();
    private final Map<String, List<Person>> addressIndex = new HashMap<>();
    private final Map<String, List<Person>> phoneIndex = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            persons.put(person.id(), person);
            addIndex(nameIndex, person.name(), person);
            addIndex(addressIndex, person.address(), person);
            addIndex(phoneIndex, person.phoneNumber(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = persons.get(id);
            if (person == null) {
                throw new IllegalArgumentException();
            } else {
                persons.remove(id);
                removeIndex(nameIndex, person.name(), person);
                removeIndex(addressIndex, person.address(), person);
                removeIndex(phoneIndex, person.phoneNumber(), person);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.writeLock().lock();
        try {
            return nameIndex.getOrDefault(name, new ArrayList<>());
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.writeLock().lock();
        try {
            return addressIndex.getOrDefault(address, new ArrayList<>());
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.writeLock().lock();
        try {
            return phoneIndex.getOrDefault(phone, new ArrayList<>());
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void addIndex(Map<String, List<Person>> index, String key, Person person) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(person);
    }

    private void removeIndex(Map<String, List<Person>> index, String key, Person person) {
        index.computeIfPresent(key, (k, persons) -> {
            persons.remove(person);
            if (persons.isEmpty()) {
                return null;
            }
            return persons;
        });
    }

    public Map<Integer, Person> getDatabase() {
        return new HashMap<>(persons);
    }
}
