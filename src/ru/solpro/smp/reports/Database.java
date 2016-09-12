package ru.solpro.smp.reports;

/**
 * Created by Администратор on 07.09.2016.
 */

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static String connectionUrl;
    private static ResultSet resultSet;

    public Database() {
        connection = null;
        statement = null;
        resultSet = null;
        connectionUrl = "jdbc:sqlserver://192.168.164.135:1433;"
                + "database=CC_smp_repo_16_08_29_15_32_23R;"
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
    public static void dbConnect() {
        try {
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("connect db");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод отсоединения от базы данных.
     */
    public static void dbDisconnect() {
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ResultSet execSQL (String SQL) {
        try {
            resultSet = statement.executeQuery(SQL);
            return resultSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }
}
