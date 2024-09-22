<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Import JSTL core library for tag support -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- Import JSTL formatting library -->
<fmt:setLocale value="es_GT"/> <!-- Set the locale to Spanish (Guatemala) -->

<section id="clientes"> <!-- Section for displaying clients -->
    <div class="container"> <!-- Bootstrap container for layout -->
        <div class="row"> <!-- Bootstrap row for columns -->
            <div class="col-md-9"> <!-- Main column for client list -->
                <div class="card"> <!-- Card component for styling -->
                    <div class="card-header"> <!-- Header of the card -->
                        <h4>Listado de Clientes</h4> <!-- Title of the client list -->
                    </div>                    
                    <table class="table table-striped"> <!-- Table to display client data -->
                        <thead class="table-dark"> <!-- Table header with dark background -->
                            <tr>
                                <th>#</th> <!-- Column for row number -->
                                <th>Nombre</th> <!-- Column for client name -->
                                <th>Saldo</th> <!-- Column for client balance -->
                                <th></th> <!-- Empty column for actions -->
                            </tr>                            
                        </thead>
                        <tbody>
                            <!-- Loop through the list of clients -->
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td> <!-- Display the row count -->
                                    <td>${cliente.nombre} ${cliente.apellido}</td> <!-- Display the client's full name -->
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td> <!-- Format the balance as currency -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary"> <!-- Link to edit client details -->
                                            <i class="fas fa-angle-double-right"></i>Editar <!-- Edit button with icon -->
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Start of cards for totals -->
            <div class="col-md-3"> <!-- Column for total information -->
                <div class="card text-center bg-danger text-white mb-3"> <!-- Card for total balance -->
                    <div class="card-body">
                        <h3>Saldo Total</h3> <!-- Title for total balance -->
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/> <!-- Format total balance as currency -->
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3"> <!-- Card for total clients -->
                    <div class="card-body">
                        <h3>Total Clientes</h3> <!-- Title for total clients -->
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes} <!-- Display the total number of clients -->
                        </h4>
                    </div>
                </div>        
            </div>
            <!-- End of cards for totals -->            
        </div>
    </div>
</section>

<!-- Include the modal for adding a new client -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>
