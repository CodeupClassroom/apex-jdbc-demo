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
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

            while(rs.next()){
                // We can use indexes to get values from the rs
                System.out.println(rs.getLong(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                // We can use column labels to get values from the rs
                System.out.println(rs.getInt("release_date"));
                System.out.println(rs.getDouble("sales"));
                System.out.println(rs.getString("genre"));
                System.out.println("--------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
