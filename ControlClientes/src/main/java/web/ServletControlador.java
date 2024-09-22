package web;

import datos.ClienteDaoJDBC;
import dominio.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

/**
 * This servlet handles the requests for managing clients.
 * It controls actions like adding, editing, and deleting clients in the system.
 * @author KeV
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException,
                                                              NumberFormatException {

        // Get the action parameter from the request (e.g., edit, delete)
        String accion = request.getParameter("accion");

        // Check if action is provided, and call the appropriate method
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);  // Edit a client
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);  // Delete a client
                    break;
                default:
                    this.accionDefault(request, response);  // Default action
            }
        } else {
            this.accionDefault(request, response);  // Default action if no action is provided
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // Get the action parameter for POST requests (e.g., insert, modify)
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertar(request, response);  // Insert a new client
                    break;
                case "modificar":
                    this.modificarCliente(request, response);  // Modify an existing client
                    break;
                default:
                    this.accionDefault(request, response);  // Default action
            }
        } else {
            this.accionDefault(request, response);  // Default action if no action is provided
        }
    }

    // Method to insert a new client into the database
    private void insertar(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException,
                                                              NumberFormatException {
        // Retrieve values from the form
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        // Handle the balance (saldo) if provided
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        
        // Create a new client object with the provided data
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        // Insert the new client into the database
        int registroModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registroModificados = " + registroModificados);

        // Redirect to the default action (listing clients)
        this.accionDefault(request, response);
    }

    // Method to modify an existing client in the database
    private void modificarCliente(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException,
                                                                      NumberFormatException {
        // Retrieve values from the form, including the client ID
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        // Handle the balance (saldo) if provided
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        // Create a new client object with the updated data
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        // Update the client in the database
        int registroModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registroModificados = " + registroModificados);

        // Redirect to the default action (listing clients)
        this.accionDefault(request, response);
    }

    // Method to edit a client (fetch client data and forward to the edit form)
    private void editarCliente(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException,
                                                                   NumberFormatException {
        // Retrieve the client ID from the request
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        // Find the client in the database
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));

        // Add the client object to the request to display in the edit form
        request.setAttribute("cliente", cliente);

        // Forward the request to the edit form JSP page
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    // Method to delete a client from the database
    private void eliminarCliente(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException,
                                                                     NumberFormatException {
        // Retrieve the client ID from the request
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        // Create a client object with the ID
        Cliente cliente = new Cliente(idCliente);

        // Delete the client from the database
        int registroModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registroModificados = " + registroModificados);

        // Redirect to the default action (listing clients)
        this.accionDefault(request, response);
    }

    // Method to calculate the total balance (saldo) of all clients
    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;

        // Loop through each client and sum their balances
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    // Default action that lists all clients and their total balance
    private void accionDefault(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of clients from the database
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);

        // Store the list and totals in the session
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));

        // Redirect to the clients listing page
        response.sendRedirect("clientes.jsp");
    }
}
