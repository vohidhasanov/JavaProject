package DataBase;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) {
        System.out.println("MySQL JDBC Connection Testing:");
        List<Employee> result = new ArrayList<>();
        String SQL_SELECT = "Select * from EMPLOYEE";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "password");
             PreparedStatement preparedStatement= conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next())
            {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createDate = resultSet.getTimestamp("CREATED_DATE");

                Employee obj = new Employee();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                //Timestam -> LocalDateTime
                obj.setCreateDate(createDate.toLocalDateTime()) ;
                result.add(obj);
            }
            result.forEach(x-> System.out.println(x));
            }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
