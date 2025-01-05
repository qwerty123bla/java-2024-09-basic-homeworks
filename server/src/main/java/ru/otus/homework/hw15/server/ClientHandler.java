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
    private boolean isAuthenticated;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.isAuthenticated = false;

        new Thread(() -> {
            try {
                //System.out.println("Клиент подключился " + socket.getPort());
                // цикл аутентификации
                while(true) {
                    sendMsg("Для начала работы надо пройти аутентификацию. Формат команды /auth login password \n" +
                            "или регистрацию. Формат команды /reg login password userName");

                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase(("/exit"))) {
                            sendMsg("/exitok");
                            break;
                        }

                        // /auth login password
                        if (message.startsWith(("/auth"))) {
                            String[] element = message.split(" ");

                            if (element.length != 3) {
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }

                            if (server.getAuthenticatedProvider()
                                    .authenticate(this, element[1], element[2])) {
                                this.isAuthenticated = true;
                                break;
                            }
                        }

                        // /reg login password username
                        if (message.startsWith(("/reg"))) {
                            String[] element = message.split(" ");

                            if (element.length != 4) {
                                sendMsg("Неверный формат команды /reg");
                                continue;
                            }

                            if (server.getAuthenticatedProvider().registration(this, element[1], element[2], element[3])) {
                                this.isAuthenticated = true;
                                break;
                            }
                        }
                    }


                }

                // цикл работы
                while(this.isAuthenticated) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase(("/exit"))) {
                            sendMsg("/exitok");
                            break;
                        }

                        if (message.equalsIgnoreCase(("/disconnect"))) {
                            break;
                        }

                        // /kick username
                        if (message.startsWith(("/kick"))) {
                            String[] element = message.split(" ");

                            if (element.length != 2) {
                                sendMsg("Неверный формат команды /kick");
                                continue;
                            }

                            if (server.getAuthenticatedProvider().getUserRole(userName) != Role.ADMIN) {
                                sendMsg("У вас нет прав для использоватния команды /kick");
                                continue;
                            }

                            server.sendMessage(element[1], "/disconnect");
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

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
