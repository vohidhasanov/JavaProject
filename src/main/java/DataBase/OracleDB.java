package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDB {

    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery("select*from emp ");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2) );
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
