package DataBase;


import org.apache.log4j.Logger;
//import org.sqlite.JDBC;

import java.nio.charset.StandardCharsets;
import java.sql.*;


public class DBHelper {
    private static Logger logger = Logger.getLogger(DBHelper.class);
    private static Connection conn;
    private static DBHelper instance;
    private static String databaseURL = "jdbc:sqlite:testdb.sqlite";
    static Connection[] connections;

    public static DBHelper getInstance() {
        if (instance == null) instance = new DBHelper();
        return instance;
    }

    private DBHelper () {

        try {
            Class.forName("org.sqlite.JDBC");
          //  DriverManager.registerDriver(new JDBC());
            logger.info ("Opening database: {}"+ databaseURL);
            conn = DriverManager.getConnection(databaseURL);

            if (!isTableExist()) {
                Statement stmt = conn.createStatement();
                String createSql = readResource (DBHelper.class, "/create.sql");
                stmt.executeUpdate(createSql);

                String insertSql = readResource(DBHelper.class, "/insert.sql");
                stmt.executeUpdate(insertSql);
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            closeConnection();
        }

    }

    public Connection getConn () {
        if (conn==null) {
            try {
                conn=DriverManager.getConnection(databaseURL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    boolean  isTableExist () throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count (*) FROM sqlite_master WHERE type='table' AND name='USERS'; ");
        boolean result =true;
        int count = rs.getInt(1);
        if (count == 0) {return result=false;}
        rs.close();
        stmt.close();
        return result;
    }

     String readResource( Class cpHolder, String path) throws Exception {
         System.out.println("the adress is: "+ cpHolder.getResource(path));
        java.net.URL url = cpHolder.getResource(path);

        java.nio.file.Path resPath =  java.nio.file.Paths.get(url.toURI());
        return new String (java.nio.file.Files.readAllBytes(resPath), StandardCharsets.UTF_8);
    }

    static void closeResource(AutoCloseable res) {
        if (res!=null) {
            try {
                res.close();
                res=null;
            } catch (Exception e) {
                logger.warn("Failed to close resource {}"+res);
            }
        }
    }

    static void closeConnection() {
        closeResource(conn);
        conn=null;
    }


}
