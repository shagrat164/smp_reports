package ru.solpro.smp.reports;

import java.sql.*;

/**
 * Created by Администратор on 07.09.2016.
 */

public class Database {
    private Connection connection;
    private Statement statement;
    private String connectionUrl;
    private ResultSet resultSet;

    public Database() {
        connection = null;
        statement = null;
        resultSet = null;
        connectionUrl = "jdbc:sqlserver://192.168.164.136:1433;"
//                + "database=CC_smp_repo_16_08_29_15_32_23R;"
                + "database=CC_smp_repo_16_10_24_16_20_09R;"
                + "user=user;"
                + "password=user;"
                + "loginTimeout=10;";
    }

    public Database(String serverName, String portNumber, String database, String username, String password) {
        connection = null;
        statement = null;
        resultSet = null;
        connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";"
                            + "database=" + database + ";"
                            + "user=" + username + ";"
                            + "password=" + password + ";"
                            + "loginTimeout=10;";
    }

    /**
     * Метод соединения с базой данных.
     */
    public void dbConnect() {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement();
            System.out.println("connect db");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод отсоединения от базы данных.
     */
    public void dbDisconnect() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
                System.out.println("disconnect db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Выполнение SQL запроса.
     * @param SQL
     *        Строка запроса SQL
     * @return Тип ResultSet.
     */
    public ResultSet execSQL (String SQL) {
        try {
            resultSet = statement.executeQuery(SQL);
            return resultSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
