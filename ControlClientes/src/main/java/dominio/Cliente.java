package dominio;

/**
 * Class representing a client with their details.
 * @author KeV
 */
public class Cliente {

    // Unique identifier for the client
    private int idCliente;
    // Client's first name
    private String nombre;
    // Client's last name
    private String apellido;
    // Client's email address
    private String email;
    // Client's phone number
    private String telefono;
    // Client's account balance
    private double saldo;

    // Default constructor (no parameters)
    public Cliente() {
    }

    // Constructor for creating a client with just an ID
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Constructor for creating a new client with name, email, phone, and balance
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    // Constructor for creating a client with all details, including ID
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    // Get the client's ID
    public int getIdCliente() {
        return idCliente;
    }

    // Set the client's ID
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Get the client's first name
    public String getNombre() {
        return nombre;
    }

    // Set the client's first name
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Get the client's last name
    public String getApellido() {
        return apellido;
    }

    // Set the client's last name
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Get the client's email address
    public String getEmail() {
        return email;
    }

    // Set the client's email address
    public void setEmail(String email) {
        this.email = email;
    }

    // Get the client's phone number
    public String getTelefono() {
        return telefono;
    }

    // Set the client's phone number
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Get the client's account balance
    public double getSaldo() {
        return saldo;
    }

    // Set the client's account balance
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Return a string representation of the client
    @Override
    public String toString() {
        return "Cliente{" + 
               "idCliente=" + idCliente + 
               ", nombre=" + nombre + 
               ", apellido=" + apellido + 
               ", email=" + email + 
               ", telefono=" + telefono + 
               ", saldo=" + saldo + 
               '}';
    }
}
