package ru.otus.homework.hw3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        /*
        Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
        метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
         */
        int[][] arr = {{1, -1, 0 }, {2, -3, 4}};
        int sum = sumOfPositiveElements(arr);
        System.out.println("1. Посчитать сумму всех элементов массива");
        System.out.println("Исходный массив");
        printArray(arr);
        System.out.println("Сумма положительных элементов: " + sum);

        /*
        Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
         */
        int size = 4;
        System.out.println("2. Напечатать квадрат размером " + size);
        printStars(size);
        /*
        Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его диагональные элементы
        (можете выбрать любую из диагоналей, или занулить обе);
         */
        System.out.println("3. Установить по диагоналям массива число 0");
        int[][] arr2 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println("Исходный массив: ");
        printArray(arr2);
        setDiagonal(arr2);
        System.out.println("Результат: ");
        printArray(arr2);
        /*
        Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
         */
        System.out.println("4. Найти максимальный элемент двумерного массива");
        int[][] arr3 = {{1, 7, 4, 9, 2}, {4, 2, 8, 5, 2}, {4, 2, 1, 7, 34}, {21, 5, 6, 40, 35}, {12, 6, 8, 45, 9}};
        printArray(arr3);
        int maxVal = findMax(arr3);
        System.out.println("Максимальный элемент: " + maxVal);
        /*
        Реализуйте метод, который считает сумму элементов второй строки двумерного массива, если второй строки не существует, то в качестве результата необходимо вернуть -1
         */
        int[][] arr4 = {{1, 7, 4, 9, 2}, {4, 2, 8, 5, 2}, {4, 2, 1, 7, 34}, {21, 5, 6, 40, 35}, {12, 6, 8, 45, 9}};
        System.out.println("5. Посчитать сумму элементов второй строки двумерного массива");
        System.out.println("Исходный массив: ");
        printArray(arr4);
        sum = sumSecondString(arr4);
        System.out.println("Сумма элементов: " + sum);
    }

    public static int sumOfPositiveElements(int [][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += Math.max(arr[i][j], 0);
            }
        }
        return sum;
    }

    public static void printStars(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void setDiagonal(int [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || arr[i].length - 1 - j == i) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static int findMax(int [][] array) {
        int maxVal = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                maxVal = Math.max(array[i][j], maxVal);
            }
        }
        return maxVal;
    }

    public static int sumSecondString(int[][] array) {
        if (array.length < 2)
            return -1;

        int sum = 0;
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }

        return sum;
    }

    public static void printArray(int [][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
