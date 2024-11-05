package ru.otus.homework.hw4;

import java.sql.SQLOutput;

public class Box {
    private boolean isOpened;
    private int width;
    private int height;
    private int depth;
    private String color;
    private String something;

    public Box(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;

        this.color = color;
        this.isOpened = false;
        this.something = "";
    }
    public void open() {
        this.isOpened = true;
        System.out.println("Открываем коробку");
    }

    public void close() {
        this.isOpened = false;
        System.out.println("Закрываем коробку");
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Установили коробке цвет - " + color);
    }

    public void put(String something) {
        if (!this.isOpened) {
            System.out.println("Коробка закрыта");
            return;
        }
        if (!this.something.isEmpty()) {
            System.out.println("Коробка не пуста");
            return;
        }

        this.something = something;
        System.out.println("Положили в коробку - " + something);
    }

    public void takeOut() {
        if (!this.isOpened) {
            System.out.println("Коробка закрыта");
            return;
        }

        if (this.something.isEmpty()) {
            System.out.println("Коробка пуста");
            return;
        }

        System.out.println("Вынимаем из коробки - " + this.something);
        this.something = "";
    }

    @Override
    public String toString() {
        return "Габариты ШВГ: " + this.width + "*" + this.height + "*" + this.depth + " цвет: " + this.color + ", состояние: " + ((this.isOpened) ? "открыта" : "закрыта") + "."
                + " В коробке лежит: " + ((this.something.isEmpty()) ? "-" : this.something);
    }
}
