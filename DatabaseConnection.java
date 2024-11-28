import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "-u root -p", "Parate@5003");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
