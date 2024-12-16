package ru.otus.homework;

import ru.otus.homework.hw14.Handler;

import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Заполнение массива одним потоком
        double[] array = new double[100_000_000];

        Date dateBefore = new Date();

        for(int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        Date dateAfter = new Date();
        System.out.println("Время в миллисекундах при заполнении одним потоком: " + (dateAfter.getTime() - dateBefore.getTime()));

        // Заполнение массива 4мя потоками
        double[] arrayParallel = new double[100_000_000];

        Thread h1 = new Thread(new Handler(arrayParallel, 0, 25_000_000)) ;
        Thread h2 = new Thread(new Handler(arrayParallel, 25_000_000, 50_000_000)) ;
        Thread h3 = new Thread(new Handler(arrayParallel, 50_000_000, 75_000_000)) ;
        Thread h4 = new Thread(new Handler(arrayParallel, 75_000_000, 100_000_000)) ;

        dateBefore = new Date();

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();

        dateAfter = new Date();

        System.out.println("Время в миллисекундах при заполнении четырьмя потоками: " + (dateAfter.getTime() - dateBefore.getTime()));
    }
}
