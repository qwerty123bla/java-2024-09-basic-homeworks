package ru.otus.homework.hw7;

public class Human {
    Transport currentTransport;
    String name;

    public Human(String name) {
        this.name = name;
    }

    public void setTransport(Transport transport) {
        this.currentTransport = transport;
    }

    public boolean run(Locations location, int duration) {
        if (this.currentTransport == null) {
            System.out.println("Человек прошёл пешком " + duration + " по локции " + location.getDescription());
            return true;
        }
        else {
            return this.currentTransport.run(location, duration);
        }
    }
}
