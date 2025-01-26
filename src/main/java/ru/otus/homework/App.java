package ru.otus.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        subStrCount();
    }

    public static void subStrCount() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя файла: ");
            String filename = scanner.nextLine();

            System.out.println("Введите текстовую последовательность для поиска: ");
            String subStr = scanner.nextLine();

            String findString = readFile(filename);
            System.out.println("Содержимое файла: ");
            System.out.println(findString);

            int count = calcSubStrCnt(findString, subStr);
            System.out.println("Кол-во вхождений подстроки " + subStr + ": " + count);

            System.out.println("Для выхода наберите exit, наберите любую последовательность:");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    public static String readFile(String fileName) {
        StringBuilder retString = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                retString.append(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        return retString.toString();
    }

    public static int calcSubStrCnt(String srcString, String subStr) {
        int start = 0;
        int count = 0;
        while(true) {
            int position = srcString.indexOf(subStr, start);
            start = position + subStr.length();
            if (position == -1) {
                break;
            }

            count++;
        }

        return count;
    }
}


