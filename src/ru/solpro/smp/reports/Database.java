package ru.solpro.smp.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Администратор on 07.09.2016.
 */

public class Database {
    private Connection connection;
    private Statement statement;
    private String connectionUrl;

    Database()
    {
        connection = null;
        statement = null;
        connectionUrl = "jdbc:sqlserver://192.168.204.128:1433;"
                + "database=CC_smp_repo_16_08_29_15_32_23R;"
                + "user=user;"
                + "password=user;"
                + "loginTimeout=10;";
    }

    Database(String serverName, String portNumber, String database, String username, String password)
    {
        connection = null;
        statement = null;
        connectionUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";"
                            + "database=" + database + ";"
                            + "user=" + username + ";"
                            + "password=" + username + ";"
                            + "loginTimeout=10;";
    }

    /**
     * Метод соединения с базой данных
     */
    public void dbConnect() throws ClassNotFoundException, SQLException
    {
        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
    }

    public Connection getConnection()
    {
        return connection;
    }

    public Statement getStatement()
    {
        return statement;
    }
}
