package ru.otus.homework.hw13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);

        while(true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Подключился клиет с портом: " + client.getPort() + " подключился!");

            String userInput = inputStream.readUTF();

            if (userInput.equals("exit")) {
                outputStream.writeUTF("Сеанс завершён");
                outputStream.flush();
                client.close();
                continue;
            }

            double val1;
            double val2;
            String operator = "";

            try {
                userInput = userInput.replace(',', '.');
                int spaceIndex1 = userInput.indexOf(' ');
                System.out.println(spaceIndex1);
                val1 = Double.parseDouble(userInput.substring(0, spaceIndex1));
                int spaceIndex2 = userInput.indexOf(' ', spaceIndex1 + 1);
                System.out.println(spaceIndex2);
                val2 = Double.parseDouble(userInput.substring(spaceIndex1, spaceIndex2));
                operator = userInput.substring(spaceIndex2 + 1);
            }
            catch (Exception e) {
                outputStream.writeUTF("Неверный формат ввода");
                outputStream.flush();
                client.close();
                continue;
            }

            String result;
            switch (operator) {
                case "+":
                    result = String.valueOf(val1 + val2);
                    break;
                case "-":
                    result = String.valueOf(val1 - val2);
                    break;
                case "*":
                    result = String.valueOf(val1 * val2);
                    break;
                case "/":
                    if (val2 == 0)
                        result = "бесконечнось ¯\\_(ツ)_/¯";
                    else
                        result = String.valueOf(val1 / val2);
                    break;
                default:
                    result = "Некорректный оператор";
            }

            outputStream.writeUTF("Результат вычислений: " + result);
            outputStream.flush();
        }
    }
}
