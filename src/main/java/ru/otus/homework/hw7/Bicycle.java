package ru.otus.homework.hw7;

public class Bicycle implements Transport {
    @Override
    public boolean run(Locations location, int duration) {
        if(location == Locations.SWAMP) {
            System.out.println("Велосипед не может перемещаться по этому типу местности - " + location.getDescription());
            return false;
        }
        System.out.println("Проехали на велосипеде " + duration);
        return true;
    }
}
