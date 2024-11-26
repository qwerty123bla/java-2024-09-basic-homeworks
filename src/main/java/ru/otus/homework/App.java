package ru.otus.homework;


import ru.otus.homework.hw8.AppArrayDataException;
import ru.otus.homework.hw8.AppArraySizeException;

public class App {
    public static void main(String[] args) {
        int s = 0;

        try {
            s = summ(new String [][] {{"1", "1", "1"}, {"1", "1", "1"}, {"1", "1", "1"}});
        }
        catch (AppArraySizeException | AppArrayDataException e) {
            e.printStackTrace();
        }

        try {
            s = summ(new String [][] {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "ohhhh"}});
        }
        catch (AppArraySizeException | AppArrayDataException e) {
            e.printStackTrace();
        }

        try {
            s = summ(new String [][] {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}});
        }
        catch (AppArraySizeException | AppArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("Сумма элементов массива " + s);
    }

    public static int summ(String [][] array) throws AppArraySizeException, AppArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.valueOf(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        return sum;
    }
}
