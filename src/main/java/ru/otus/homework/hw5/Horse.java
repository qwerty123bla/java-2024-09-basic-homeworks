package ru.otus.homework.hw5;

public class Horse extends Animal{
    public Horse(String name) {
        super(name, 9, 4, 1500);
    }

    @Override
    public float swim(int distance) {
        System.out.println(this.name + " нужно проплыть " + distance + " метров");
        return action(distance, 4, this.swimSpeed);
    }
}
