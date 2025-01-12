package ru.otus.homework.hw15.server;

import java.sql.*;

public class SQLAuthenticatedProvider implements AuthenticatedProvider{
    private Connection connection;
    private Server server;
    private Statement statement;

    public SQLAuthenticatedProvider (Server server) {
        this.server = server;
    }

    @Override
    public void initialize() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "");
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUserName = "";
        try {
            PreparedStatement ps = this.connection.prepareStatement("select u.user_name from otus.users u where u.login = ? and u.\"password\" = ?");
            ps.setString(1, login);
            ps.setString(2, password);

            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    if (rs.getString(1) != null) {
                        authUserName = rs.getString(1);
                    }
                    else {
                        clientHandler.sendMsg("Неверный логин/пароль");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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
        try {
            PreparedStatement ps = this.connection.prepareStatement("select count(1) from otus.users u where u.login = ?");
            ps.setString(1, login);

            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    if (rs.getInt(1) == 1) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return false;
    }

    private boolean isUserNameAlreadyExists(String userName) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("select count(1) from otus.users u where u.user_name = ?");
            ps.setString(1, userName);

            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    if (rs.getInt(1) == 1) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String userName) {
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

        try {
            connection.setAutoCommit(false);
            // создаём пользователя
            PreparedStatement ps = connection.prepareStatement("insert into otus.users (login, \"password\", user_name) values (?, ?, ?)");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, userName);
            ps.executeUpdate();

            // получаем Id созданного пользователя
            ps = this.connection.prepareStatement("select u.id from otus.users u where u.login = ? and u.\"password\" = ?");
            ps.setString(1, login);
            ps.setString(2, password);

            int userId = 0;
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    userId = rs.getInt(1);
                }
            }

            // получаем id роли - пользователь
            int roleId = 0;
            try(ResultSet rs = this.statement.executeQuery("select r.id from otus.roles r where r.\"name\" = 'user'")) {
                while(rs.next()) {
                    roleId = rs.getInt(1);
                }
            }

            // выдаём пользователю роль
            ps = connection.prepareStatement("insert into otus.users_to_roles (user_id, role_id) values (?, ?)");
            ps.setInt(1, userId);
            ps.setInt(2, roleId);
            ps.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        clientHandler.setUserName(userName);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + userName);

        return true;
    }

    @Override
    public Role getUserRole(String userName) {
        try {
            // создаём пользователя

            PreparedStatement ps = this.connection.prepareStatement("""
                    select r."name"\s
                      from otus.users u
                      join otus.users_to_roles ur
                        on u.id = ur.user_id
                      join otus.roles r
                        on r.id = ur.role_id\s
                     where u.user_name = ?;
                    """);
            ps.setString(1, userName);

            String role;
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    role = rs.getString(1);

                    if (role.equals("admin"))
                        return Role.ADMIN;
                    else
                        return Role.USER;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return null;
    }
}
