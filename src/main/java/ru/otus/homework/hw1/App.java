package ru.otus.homework.hw1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        greetings();
        checkSign(1, -5, 3);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(4, 2, true);

        Scanner scanner = new Scanner(System.in);
        int n;

        while(true) {
            System.out.println("Введите число от 1 до 5:");
            n = scanner.nextInt();

            if(n >= 1 && n <= 5) {
                break;
            } else {
                System.out.println("Введено некорректное число");
            }
        }


        if (n == 1) {
            greetings();
        } else if (n == 2) {
            checkSign(getRandomInt(100,false), getRandomInt(100,false), getRandomInt(100,false));
        } else if (n == 3) {
            selectColor();
        } else if (n == 4) {
            compareNumbers();
        } else if (n == 5) {
            addOrSubtractAndPrint(getRandomInt(100,true), getRandomInt(100,true), getRandomInt(2,true) == 0);
        }
    }

    public static void greetings() {
        System.out.print("Hello,");
        System.out.print("World,");
        System.out.print("from,");
        System.out.print("Java");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("a=" + a + " b=" + b + " c=" + c);

        int sum = a + b + c;

        if (sum > 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 10;

        if (data <= 10) {
            System.out.println("Красный");
        }
        else if(data <= 20) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("initValue: " + initValue + ", delta: " + delta + ", increment: " + increment);
        if (increment) {
            System.out.println(initValue + delta);
        }
        else {
            System.out.println(initValue + delta);
        }
    }

    public static int getRandomInt(int maxValue, boolean onlyUnsigned) {
        if (onlyUnsigned) {
            return (int) (Math.random() * maxValue);
        } else {
            return (int) ((Math.random() - 0.5) * 2 * maxValue);
        }
    }
}
