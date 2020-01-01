package DataBase;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    private static Logger logger  = Logger.getLogger(TestDB.class);
    static DBHelper dbHelper = DBHelper.getInstance() ;

    static void selectExample () {
        Statement stmt = null;
        ResultSet rs =null;
        StringBuilder result = new StringBuilder();

        try {
            stmt = dbHelper.getConn().createStatement();
            rs = stmt.executeQuery("SELECT * FROM CATEGORIES;");
            while (rs.next() ) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.append(String.format("%d %s\n", id, name));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResource(stmt);
            DBHelper.closeConnection();
        }
        logger.info("categories: \n{}\n"+ result);
    }

    static void preparedStatementExample () {
        PreparedStatement stmt =   null;
        ResultSet rs =null;
        StringBuilder result = new StringBuilder();
        try {
            stmt = dbHelper.getConn().prepareStatement("SELECT * FROM CATEGORIES WHERE  ID=?");
            stmt.setInt(1,2);

        rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            result.append(String.format("%d %s\n", id, name));
        }
    }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResource(stmt);
            DBHelper.closeConnection();
        }
        logger.info("categories: \n{}\n"+ result);
    }



    public static void main(String[] args) {
        selectExample();
        preparedStatementExample();
    }
}
