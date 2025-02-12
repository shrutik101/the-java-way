package qa.automation.java.utils;
import java.sql.*;

public class SQLWay {
    // Database connection parameters
    private static final String url = "jdbc:mysql://localhost:3306/ecomm";
    private static final String user = "root";
    private static final String password = "Illuminati$1";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            readFromDB(conn);
//            updateEntry(conn, 3, "Shridhar");
//            readFromDB(conn);
//            insertEntry(conn,"Mike", "Jackvile", "mjv@sql.com");
//            readFromDB(conn);
        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
        }
    }


    public static void readFromDB(Connection conn) {
        String query = "SELECT * FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("user_id") + ", Fist Name: " + rs.getString("first_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading from database!");
            e.printStackTrace();
        }
    }

    public static void updateEntry(Connection conn, int id, String newName) {
        String query = "UPDATE users SET first_name = ? WHERE user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            System.out.println("Error updating entry!");
            e.printStackTrace();
        }
    }

    public static void insertEntry(Connection conn, String firstName, String lastName, String email) {
        String query = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error inserting entry!");
            e.printStackTrace();
        }
    }
}