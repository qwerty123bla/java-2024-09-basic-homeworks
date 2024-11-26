package ru.otus.homework.hw8;

public class AppArrayDataException extends Exception {
    public AppArrayDataException(int i, int j) {
        super("Некорректное заполнение массива в ячейке с координатами х = " + i + " y = " + j);
    }
}
