package ru.solpro.smp.reports_excel;

import java.sql.*;

/**
 * Created by danila on 15.11.2016.
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
                + "database=CC_smp_repo_16_10_24_16_20_09R;"
                + "user=user;"
                + "password=user;"
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
