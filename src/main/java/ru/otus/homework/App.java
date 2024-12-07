package ru.otus.homework;

import ru.otus.homework.hw12.MyFile;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MyFile myFile = new MyFile();
        boolean exit = false;

        while(true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. показать содержимое дирректории");
            System.out.println("2. Создать новый файл");
            System.out.println("3. Показать содержимое файла");
            System.out.println("4. Записать файл");
            System.out.println("5. Выйти из программы");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    myFile.showDir();
                    break;
                case 2:
                    myFile.createFile();
                    break;
                case 3:
                    myFile.writeFile();
                    break;
                case 4:
                    myFile.readFile();
                    break;
                case 5:
                    exit = true;
                    break;
            }

            if (exit) break;

            System.out.println();
        }
    }
}
