package ru.otus.homework;

import ru.otus.homework.hw10.PhoneBook;

public class App {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.add("Дементий", "32432434");
        book.add("Сергей", "123");
        book.add("Сергей", "345");


        System.out.println("Телефоны, зарегестрированные на имя Сергей: " + book.find("Сергей"));

        System.out.println("Содержит ли телефонная книга номер 345" + (book.containsPhoneNumber("345") ? " - Содержит" : " - Не содержит"));
    }
}
