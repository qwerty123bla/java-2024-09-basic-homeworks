package ru.otus.homework.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyFile {
    File currentDir;

    public MyFile() {
        this.currentDir = new File(System.getProperty("user.dir"));
    }

    public void showDir() {
        for (File f: this.currentDir.listFiles()) {
            System.out.println(f.getName() + " - " + (f.isDirectory() ? "папка " : "файл"));
        }
    }

    public void createFile() {
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        try {
            if(new File(currentDir.getAbsoluteFile() + File.separator + fileName).createNewFile())
                System.out.println("Файл успешно создан");
            else
                System.out.println("Файл с таким именем уже существуе");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при создании файла");
        }
    }

    public void writeFile() {
        System.out.println("Введите имя файла, содержание, которого необходимо отобразить");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        try (FileInputStream fis = new FileInputStream(currentDir.getAbsoluteFile() + File.separator + fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             InputStreamReader in = new InputStreamReader(bis)) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            System.out.println("При чтении файла возникла ошибка...");
        }
    }

    public void readFile() {
        System.out.println("Введите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        if (!new File(currentDir.getAbsoluteFile() + File.separator + fileName).exists()) {
            System.out.println("Файла с таким именем не существует");
            return;
        }

        System.out.println("Введите текст для записи. Для завершения считывания текста необходимо написать end:");

        String fileBody = "";
        String b;
        while (true){
            b = scanner.next();
            if (b.equals("end")) {
                break;
            }

            fileBody += " " + b;
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(currentDir.getAbsoluteFile() + File.separator + fileName))) {
            byte[] buffer = fileBody.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            System.out.println("При записи файла возникла ошибка...");
        }
    }
}
