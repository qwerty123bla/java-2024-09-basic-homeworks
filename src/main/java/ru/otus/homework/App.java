package ru.otus.homework;

import ru.otus.homework.hw7.*;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Human human = new Human("Тимофей");

        Transport transports[] = new Transport[] {
                new Car(100), new Horse(100), new Bicycle(), new AllTerrain(100), null
        };

        for(Transport transport: transports) {
            human.setTransport(transport);
            if (transport != null) {
                System.out.println("Сели в " + transport.getType());
            }
            else {
                System.out.println("Вышли из транспорта");
            }

            for (Locations loc : Locations.values()) {
                System.out.print("Пытаемся передвигаться по " + loc.getDescription() + ": ");
                if(human.run(loc, getRandomInt(30, 90)))
                    System.out.println("* Перемещение удалось");
                else
                    System.out.println("* Переместиться не получилось");
            }
            System.out.println("----------------------------");
        }
    }

    public static int getRandomInt(int minValue, int maxValue) {
        Random rn = new Random();
        return rn.nextInt(maxValue - minValue + 1) + minValue;
    }
}
