package ru.otus.homework.hw5;

public class Cat extends  Animal{
    public Cat(String name) {
        super(name, 5, 0, 1000);
    }

    @Override
    public float swim(int distance) {
        System.out.println(this.name + " нужно проплыть " + distance + " метров");
        System.out.println("Я не умею плавать, у меня лапки...");
        return -1;
    }
}
