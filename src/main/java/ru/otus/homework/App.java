package ru.otus.homework;

import ru.otus.homework.hw5.Cat;
import ru.otus.homework.hw5.Dog;
import ru.otus.homework.hw5.Horse;

public class App {
    public static void main(String[] args) {

        Cat cat = new Cat("Барсик");
        cat.info();
        showResult(cat.run(114));
        showResult(cat.swim(114));
        showResult(cat.run(900));
        cat.info();

        System.out.println();

        Dog dog = new Dog("Шарик");
        dog.info();
        showResult(dog.run(114));
        showResult(dog.swim(114));
        showResult(dog.run(900));
        showResult(dog.run(10));
        dog.info();

        System.out.println();

        Horse horse = new Horse("Росинант");
        horse.info();
        showResult(horse.run(114));
        showResult(horse.swim(114));
        showResult(horse.run(900));
        horse.info();
    }

    public static void showResult(float time) {
        if (time != -1)
            System.out.println("Время затрачено: " + Math.round(time * 100) / 100 + " секунд");
        else
            System.out.println("Не получилось...");
    }
}
