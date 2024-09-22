package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing Cliente (Client) records in the database.
 * This class handles CRUD (Create, Read, Update, Delete) operations.
 * @author KeV
 */
public class ClienteDaoJDBC {

    // SQL queries for different operations
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    /**
     * Retrieves a list of all clients from the database.
     * @return List of Cliente objects
     */
    public List<Cliente> listar() {
        Connection conn = null; // Connection to the database
        PreparedStatement stmt = null; // Prepared statement for SQL query
        ResultSet rs = null; // Result set for query results
        Cliente cliente; // Cliente object to hold data
        List<Cliente> clientes = new ArrayList<>(); // List to hold all Cliente objects

        try {
            conn = Conexion.getConnection(); // Get database connection
            stmt = conn.prepareStatement(SQL_SELECT); // Prepare the SQL query
            rs = stmt.executeQuery(); // Execute the query and get results

            // Loop through the results and create Cliente objects
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo); // Create Cliente object
                clientes.add(cliente); // Add Cliente to the list
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if SQL fails
        } finally {
            // Close resources to prevent memory leaks
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes; // Return the list of Cliente objects
    }

    /**
     * Finds a client by its ID.
     * @param cliente Cliente object containing the ID to search for
     * @return The found Cliente object with updated information
     */
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null; // Connection to the database
        PreparedStatement stmt = null; // Prepared statement for SQL query
        ResultSet rs = null; // Result set for query results

        try {
            conn = Conexion.getConnection(); // Get database connection
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID); // Prepare the SQL query
            stmt.setInt(1, cliente.getIdCliente()); // Set the ID parameter
            rs = stmt.executeQuery(); // Execute the query

            // If a result is found, update the Cliente object
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                cliente.setNombre(nombre); // Update name
                cliente.setApellido(apellido); // Update surname
                cliente.setEmail(email); // Update email
                cliente.setTelefono(telefono); // Update phone
                cliente.setSaldo(saldo); // Update balance
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if SQL fails
        } finally {
            // Close resources
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente; // Return the updated Cliente object
    }

    /**
     * Inserts a new client into the database.
     * @param cliente The Cliente object to be inserted
     * @return The number of rows affected by the insertion
     */
    public int insertar(Cliente cliente) {
        Connection conn = null; // Connection to the database
        PreparedStatement stmt = null; // Prepared statement for SQL query
        int rows = 0; // Variable to count affected rows

        try {
            conn = Conexion.getConnection(); // Get database connection
            stmt = conn.prepareStatement(SQL_INSERT); // Prepare the SQL query

            // Set parameters for the prepared statement
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            rows = stmt.executeUpdate(); // Execute the insert and get affected rows

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if SQL fails
        } finally {
            // Close resources
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows; // Return number of affected rows
    }

    /**
     * Updates an existing client in the database.
     * @param cliente The Cliente object with updated information
     * @return The number of rows affected by the update
     */
    public int actualizar(Cliente cliente) {
        Connection conn = null; // Connection to the database
        PreparedStatement stmt = null; // Prepared statement for SQL query
        int rows = 0; // Variable to count affected rows

        try {
            conn = Conexion.getConnection(); // Get database connection
            stmt = conn.prepareStatement(SQL_UPDATE); // Prepare the SQL query

            // Set parameters for the prepared statement
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente()); // Set the ID for the update

            rows = stmt.executeUpdate(); // Execute the update and get affected rows

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if SQL fails
        } finally {
            // Close resources
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows; // Return number of affected rows
    }

    /**
     * Deletes a client from the database.
     * @param cliente The Cliente object to be deleted
     * @return The number of rows affected by the deletion
     */
    public int eliminar(Cliente cliente) {
        Connection conn = null; // Connection to the database
        PreparedStatement stmt = null; // Prepared statement for SQL query
        int rows = 0; // Variable to count affected rows

        try {
            conn = Conexion.getConnection(); // Get database connection
            stmt = conn.prepareStatement(SQL_DELETE); // Prepare the SQL query

            stmt.setInt(1, cliente.getIdCliente()); // Set the ID parameter for deletion

            rows = stmt.executeUpdate(); // Execute the delete and get affected rows

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Print error if SQL fails
        } finally {
            // Close resources
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows; // Return number of affected rows
    }

}
