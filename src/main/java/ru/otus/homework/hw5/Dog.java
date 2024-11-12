package ru.otus.homework.hw5;

public class Dog extends Animal{
    public Dog(String name) {
        super(name, 4, 2, 800);
    }

    @Override
    public float swim(int distance) {
        System.out.println(this.name + " нужно проплыть " + distance + " метров");
        return action(distance, 2, this.swimSpeed);
    }
}
