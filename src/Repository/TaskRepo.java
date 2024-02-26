package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaskRepo {
    public static Connection createConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tododatabase", "postgres", "postgresql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
