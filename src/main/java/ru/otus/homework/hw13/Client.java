package ru.otus.homework.hw13;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try (Socket socket = new Socket("localhost", 8080);
                 DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
                System.out.println("Расчёт выполняется в формате - число число оператор (доступные операторы +, -, *, /: ");
                System.out.println("Для выхода необходимо набрать exit");
                System.out.println("Введите выражение для расчёта: ");
                String userMessage = scanner.nextLine();

                if (userMessage.equals("exit")) {
                    send(userMessage, outputStream, inputStream);
                    break;
                }

                send(userMessage, outputStream, inputStream);
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void send(String message, DataOutputStream outputStream, DataInputStream inputStream) {
        try {
            outputStream.writeUTF(message);
            outputStream.flush();

            String result = inputStream.readUTF();
            System.out.println(result);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
