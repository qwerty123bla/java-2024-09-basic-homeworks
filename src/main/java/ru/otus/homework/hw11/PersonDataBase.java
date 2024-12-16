package ru.otus.homework.hw11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> db;

    public PersonDataBase() {
        db = new HashMap<Long, Person>();
    }

    public void add(Person person) {
        this.db.put(person.getId(), person);
    }

    public Person findById(Long id) {
        return db.get(id);
    }

    public boolean isManager(Person person) {
        return person.getPosition().isManager();
    }

    public boolean isEmployee(Long id) {
        return !this.findById(id).getPosition().isManager();
    }
}
