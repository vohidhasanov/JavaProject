package DataBase;

import JavaConcepts.GenericsErasure.Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample2 {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres","password")) {

            if (conn != null) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failed connect to database");
            }
        }
        catch (SQLException e) {System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());}
        catch (Exception e) {e.printStackTrace();}
    }
}
