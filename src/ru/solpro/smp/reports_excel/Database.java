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
//                + "database=CC_smp_repo_16_08_29_15_32_23R;"
                + "database=CC_smp_repo_16_10_24_16_20_09R;"
                + "user=user;"
                + "password=user;"
                + "loginTimeout=10;";
    }
}
