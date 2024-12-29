package ru.otus.homework.hw15.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    //private List<ClientHandler> clients;
    private Map<String, ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        clients = new ConcurrentHashMap<>(); //CopyOnWriteArrayList<>();
    }

    public void start() {
        int port = 8189;
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            while(true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        System.out.println("Подключился клиент " + clientHandler.getUserName());
        clients.put(clientHandler.getUserName(), clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler.getUserName());
        broadcastMessage("Из чата вышел: " + clientHandler.getUserName());
    }

    public void broadcastMessage(String message) {
        for(ClientHandler c: clients.values()) {
            c.sendMsg(message);
        }
    }

    public void sendMessage(String user, String message) {
        ClientHandler c = clients.get(user);
        if (c != null) {
            c.sendMsg(message);
        }
    }
}
