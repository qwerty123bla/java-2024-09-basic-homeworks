package ru.otus.homework;

import ru.otus.homework.hw4.Box;
import ru.otus.homework.hw4.User;

public class App {
    public static void main(String[] args) {
        User [] users = {
                new User("Андрей", "Кузнецов", "Евгеньевич", 14, "Andrey@mail.ru")
                , new User("Тимофей", "Степанов", "Степанович", 27, "Timofei@mail.ru")
                , new User("Эдуард", "Иванов", "Андреевич", 90, "Eduard@mail.ru")
                , new User("Сергей", "Сафин", "Тимофеевич", 40, "Sergei@mail.ru")
                , new User("Дмитрий", "Курочкин", "Петрович", 30, "Dmitriy@mail.ru")
                , new User("Пётр", "Жириновский", "Сергеевич", 21, "Petr@mail.ru")
                , new User("Илья", "Панин", "Эдуардович", 78, "Ilya@mail.ru")
                , new User("Иван", "Степанов", "Васильевич", 44, "Ivan@mail.ru")
                , new User("Владимир", "Сафронов", "Иванович", 35, "Vladimir@mail.ru")
                , new User("Арсений", "Кац", "Владимирович", 11, "Arseniy@mail.ru")
        };

        for (int i = 0; i < users.length; i++) {
            if (users[i].getYearOfBirth() > 40) {
                users[i].info();
            }
        }

        Box box = new Box(2, 2, 2, "Зелёный");
        System.out.println(box);

        System.out.println("Пытаемся положить в коробку таракана");
        box.put("таракан");
        System.out.println("Открываем коробку и ложим таракана");
        box.open();
        box.put("таракан");
        System.out.println(box);
        System.out.println("Ложим в коробку муху");
        box.put("муха");
        System.out.println("Вынимаем таракана и ложим муху");
        box.takeOut();
        box.put("муха");
        System.out.println(box);
        System.out.println("Меняем цвет коробки");
        box.setColor("Красный");
        System.out.println(box);
        System.out.println("Вынимаем муху и закрываем коробку");
        box.takeOut();
        box.close();
        System.out.println(box);
    }
}
