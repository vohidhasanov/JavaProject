package DataBase;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import java.sql.DriverManager;
import java.sql.SQLException;

public class TableCreate {
    private static final String SQL_CREATE = "CREATE TABLE EMPLOYEE"
            +"("
            +"ID serial,"
            +"NAME varchar(100) NOT NULL,"
            +"SALARY numeric (15,2) NOT NULL,"
            +"CREATED_DATE timestamp with the zone NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            +"PRIMARY KEY(ID)"
            +")";

    public static void main(String[] args) {
        try (Connection conn = (Connection) DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres","password")) {
        Statement statement = (Statement) conn.createStatement();
        statement.execute(SQL_CREATE);

        }   catch (SQLException e){
                System.err.format("SQL state: %s \n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
