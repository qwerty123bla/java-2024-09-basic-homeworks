package ru.otus.homework.hw8;

public class AppArraySizeException extends Exception {
    public AppArraySizeException() {
        super("Некорректный размер массива");
    }
}
