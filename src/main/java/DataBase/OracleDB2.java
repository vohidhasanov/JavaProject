package DataBase;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDB2 {


    public static void main(String[] args)  {





            try{
               // conn = (Connection) DriverManager.getConnection("jdbc:oracle://127.0.0.1:3306/testdb");
                    Connection conn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Password123");

                if (conn != null) {
                    System.out.println("Connected to database");
                } else {
                    System.out.println("Failed to connect");
                }
            } catch (SQLException e) {
                System.err.format("SQL State: %s \n%s", e.getSQLState(), e.getMessage());
           } catch (Exception e) {
                    e.printStackTrace();
        }



    }


    }

