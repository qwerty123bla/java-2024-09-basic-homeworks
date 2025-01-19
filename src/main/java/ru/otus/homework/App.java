package ru.otus.homework;

import ru.otus.homework.hw19.Apple;
import ru.otus.homework.hw19.Box;
import ru.otus.homework.hw19.Fruit;
import ru.otus.homework.hw19.Orange;

public class App {
    public static void main(String[] args) {
        Box<Apple> ba = new Box<>();
        ba.add(new Apple());
        ba.add(new Apple());
        ba.add(new Apple());
        ba.add(new Apple());
        System.out.println("Вес коробки с яблоками: " + ba.weight());

        Box<Orange> bo = new Box<>();
        bo.add(new Orange());
        bo.add(new Orange());
        System.out.println("Вес коробки с апельсинами: " + bo.weight());

        Box<Fruit> bAll = new Box<>();
        bAll.add(new Apple());
        bAll.add(new Orange());
        System.out.println("Вес коробки с несортированными фруктами: " + bAll.weight());

        System.out.println("Равен или нет вес коробки с яблоками и коробки с апельсинами: " + ba.ccompare(bo));
        System.out.println("Равен или нет вес коробки с яблоками и коробки с несортированными фруктами: " + ba.ccompare(bAll));

        Box<Fruit> bAll2 = new Box<>();
        bAll2.add(new Apple());
        bAll2.add(new Orange());
        System.out.println("Вес второй коробки с несортированными фруктами: " + bAll2.weight());

        bAll2.move(bAll);

        System.out.println("Вес коробки с несортированными фруктами: " + bAll.weight());
        System.out.println("Веса в коробках после пересыапания");
        System.out.println("Вес коробки с несортированными фруктами: " + bAll.weight());
        System.out.println("Вес второй коробки с несортированными фруктами: " + bAll2.weight());
    }
}
