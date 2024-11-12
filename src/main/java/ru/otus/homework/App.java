package ru.otus.homework;

import ru.otus.homework.hw6.Cat;
import ru.otus.homework.hw6.Plate;

public class App {
    public static void main(String[] args) {
        Plate plate = new Plate(50);

        Cat[] cats = {
                new Cat("Барсик", 20)
                , new Cat("Кеша", 15)
                , new Cat("Мурзик", 18)
                , new Cat("Колобок", 30)
                , new Cat("Кот", 23)
        };

        for(Cat c: cats) {
            c.eat(plate);
        }

        for(Cat c: cats) {
            System.out.println(c);
        }

        plate.add(40);

        for(Cat c: cats) {
            c.eat(plate);
        }

        for(Cat c: cats) {
            System.out.println(c);
        }

        plate.add(40);

        for(Cat c: cats) {
            c.eat(plate);
        }

        for(Cat c: cats) {
            System.out.println(c);
        }

        System.out.println(plate);
    }


}
