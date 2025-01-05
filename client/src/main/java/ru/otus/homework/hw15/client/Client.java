package ru.otus.homework.hw15.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Scanner scanner;
    private boolean isActive;

    public Client() throws IOException {
        scanner = new Scanner(System.in);

        socket = new Socket("localhost", 8189);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        isActive = true;

        new Thread(() -> {
            try {
                while(true) {
                    String message = in.readUTF();
                    if(message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exitok")) {
                            break;
                        }

                        if (message.startsWith("/authok")) {
                            System.out.println("Удалось успешно войти в чат с именем пользователя "
                                    + message.split(" ")[1]);
                        }

                        if (message.startsWith("/regok")) {
                            System.out.println("Удалось успешно зарегистрироваться с именем пользователя "
                                    + message.split(" ")[1]);
                        }

                        if (message.equalsIgnoreCase("/disconnect")) {
                            System.out.println("Вы были отключены администратором");
                            setIsActive(false);
                            out.writeUTF("/disconnect");
                            break;
                        }
                    } else {
                        System.out.println(message);
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();

        while(true) {
            String message = scanner.nextLine();
            if (!isActive) break;
            out.writeUTF(message);
            if (message.equalsIgnoreCase("/exit")) {
                break;
            }
        }
    }

    private synchronized void setIsActive(boolean action) {
        isActive = action;
    }

    public void disconnect() {
        try {
            if(in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
