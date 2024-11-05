package ru.otus.homework.hw4;

public class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int yearOfBirth;
    private String email;

    public User(String firstName, String lastName, String patronymic, int yearOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + this.lastName + ' ' + this.firstName + ' ' + this.patronymic);
        System.out.println("Год рождения: " + this.yearOfBirth);
        System.out.println("e-mail: " + this.email);
        System.out.println();
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }
}
