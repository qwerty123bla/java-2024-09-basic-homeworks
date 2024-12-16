package ru.otus.homework.hw11;

public class Person implements Comparable {
    private String name;
    private Position position;
    private Long id;

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " Имя: " + this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        if (p.getId() > this.id)
            return -1;
        if (p.getId() < this.id)
            return 1;
        else
            return 0;
    }
}
