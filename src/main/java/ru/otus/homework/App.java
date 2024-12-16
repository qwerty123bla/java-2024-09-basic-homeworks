package ru.otus.homework;

import ru.otus.homework.hw11.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        PersonDataBase pd = new PersonDataBase();
        pd.add(new Person("Андрей", Position.DIRECTOR, 1L));
        pd.add(new Person("Сергей", Position.DRIVER, 2L));

        System.out.println("Найден сотрудник: " + pd.findById(2L));
        System.out.println((pd.isEmployee(2L))? "является сотрудником" : "является менеджером");
        System.out.println(pd.isManager(pd.findById(1L)) ? "является менеджером" : "является сотрудником" );
        System.out.println();
        //--------------------------------------------------------------------------------------------------------------

        System.out.println("quickSort");
        int [] array_qs = new int[] {3, 5, 1, 9, 23, 0, 15, 21, 9};
        System.out.println("Исходный массив: " + Arrays.toString(array_qs));
        Sort.quickSort(array_qs, 0, array_qs.length - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(array_qs));
        System.out.println();

        System.out.println("bubbleSort");
        int [] array_bs = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Исходный массив: " + Arrays.toString(array_bs));
        Sort.bubbleSort(array_bs);
        System.out.println("Отсортированный массив: " + Arrays.toString(array_bs));
    }


}
