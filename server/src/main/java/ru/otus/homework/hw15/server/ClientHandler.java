package ru.otus.homework.hw15.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;
    private String userName;
    private static int userCount = 0;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        userName = "user_" + userCount;

        new Thread(() -> {
            try {
                //System.out.println("Клиент подключился " + socket.getPort());

                while(true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase(("/exit"))) {
                            sendMsg("/exitok");
                            break;
                        }

                        String [] msg = message.split(" ", 3);

                        if (msg[0].equalsIgnoreCase("/w")) {
                            server.sendMessage(msg[1], msg[2]);
                        }
                    }
                    else {
                        server.broadcastMessage(userName + " : " + message);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }

        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);

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

    public String getUserName() {
        return userName;
    }
}
