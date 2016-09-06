package ru.solpro.smp.reports;

import java.sql.*;

public class Main {
/*    public static void main(String[] args) {

        // Create a variable for the connection string.
        String connectionUrl =
                "jdbc:sqlserver://192.168.204.128:1433;"
                        + "database=CC_smp_repo_16_08_29_15_32_23R;"
                        + "user=user;"
                        + "password=user;"
                        + "loginTimeout=10;";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection.
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT TOP 5 * FROM dbo.UA#Johnson_Fat";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString(1) + " \t" + rs.getString(2) + " \t" + rs.getString(3) + " \t" + rs.getString(4) + "   \t" + rs.getString(5) + " \t" + rs.getString(6) + " \t" + rs.getString(7) + " \t" + rs.getString(8) + " \t" + rs.getString(9));
            }
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }*/
}
