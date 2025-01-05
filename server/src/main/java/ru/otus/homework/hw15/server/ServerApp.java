package ru.otus.homework.hw15.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerApp {
    public static void main(String[] args) {
        new Server(8189).start();
    }
}