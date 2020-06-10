import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup"
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("show databases");

            while(rs.next()){
                System.out.println("rs.getString(\"Database\") = " + rs.getString("Database"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
