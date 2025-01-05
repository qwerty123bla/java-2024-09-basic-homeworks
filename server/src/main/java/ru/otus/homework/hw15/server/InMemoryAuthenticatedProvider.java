package ru.otus.homework.hw15.server;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {
    private class User {
        private String login;
        private String password;
        private String userName;
        private Role role;

        public User(String login, String password, String userName, Role role) {
            this.login = login;
            this.password = password;
            this.userName = userName;
            this.role = role;
        }
    }

    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        users = new CopyOnWriteArrayList<>();
        users.add(new User("qwe", "qwe", "qwe1", Role.ADMIN));
        users.add(new User("asd", "asd", "asd1", Role.USER));
        users.add(new User("zxc", "zxc", "zxc1", Role.USER));
    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUserNameByLoginAndPassword(String login, String password) {
        for(User u: users) {
            System.out.println("перебираем " + u.login + " " + u.password);
            if(u.login.equals(login) && u.password.equals(password)) {
                return u.userName;
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUserName = getUserNameByLoginAndPassword(login, password);
        System.out.println("логинимся " + login + " " + password);
        if(authUserName == null) {
            clientHandler.sendMsg("Неверный логин/пароль");
            return false;
        }

        if (server.isUserNameBusy(authUserName)) {
            clientHandler.sendMsg("Указанная учётная запись уже используется");
            return false;
        }

        clientHandler.setUserName(authUserName);
        server.subscribe(clientHandler);
        clientHandler.sendMsg(("/authok " + authUserName));
        return true;
    }

    private boolean isLoginAlreadyExists(String login) {
        for (User u: users) {
            if(u.login.equals(login)) {
                return true;
            }
        }

        return false;
    }

    private boolean isUserNameAlreadyExists(String userName) {
        for (User u: users) {
            if(u.userName.equals(userName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String userName) {
        // /reg login password username
        if (login.length() < 3 || password.length() < 3 || userName.length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }

        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }

        if (isUserNameAlreadyExists(userName)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }

        users.add(new User(login, password, userName, Role.USER));
        clientHandler.setUserName(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + userName);

        return true;
    }

    @Override
    public Role getUserRole(String userName) {
        for (User u: users) {
            if(u.userName.equals(userName)) {
                return u.role;
            }
        }

        return null;
    }


}
