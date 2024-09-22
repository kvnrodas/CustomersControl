package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Handles database connection and resource management for MySQL.
 * @author KeV
 */
public class Conexion {

    // Database connection URL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    // Database username
    private static final String JDBC_USER = "root";
    // Database password
    private static final String JDBC_PASSWORD = "PasswordTest";

    /**
     * Sets up and returns a DataSource object for connection pooling.
     * This helps manage and reuse database connections.
     * @return DataSource for managing connections
     */
    public static DataSource getDataSource() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Create a BasicDataSource for connection pooling
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL); // Set the database URL
        ds.setUsername(JDBC_USER); // Set the username
        ds.setPassword(JDBC_PASSWORD); // Set the password
        ds.setInitialSize(50); // Set the initial number of connections
        return ds; // Return the DataSource object
    }

    /**
     * Gets a new connection to the database from the connection pool.
     * @return Connection to the database
     * @throws SQLException if there is a problem with the connection
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection(); // Get a connection from the pool
    }

    /**
     * Closes the ResultSet object to free resources.
     * @param rs ResultSet to be closed
     */
    public static void close(ResultSet rs) {
        try {
            rs.close(); // Close the ResultSet
        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if closing fails
        }
    }

    /**
     * Closes the PreparedStatement object to free resources.
     * @param stmt PreparedStatement to be closed
     */
    public static void close(PreparedStatement stmt) {
        try {
            stmt.close(); // Close the PreparedStatement
        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if closing fails
        }
    }

    /**
     * Closes the Connection object to free resources.
     * @param conn Connection to be closed
     */
    public static void close(Connection conn) {
        try {
            conn.close(); // Close the Connection
        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if closing fails
        }
    }

}
