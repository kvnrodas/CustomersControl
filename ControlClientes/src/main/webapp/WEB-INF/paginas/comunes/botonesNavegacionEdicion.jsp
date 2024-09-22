<section id="actions" class="py-4 mb-4 bg-light"> <!-- Section for action buttons with padding and light background -->
    <div class="container"> <!-- Bootstrap container for layout -->
        <div class="row"> <!-- Bootstrap row for organizing columns -->
            <div class="col-md-3"> <!-- Column for the "Back to Home" button -->
                <a href="index.jsp" class="btn btn-light btn-block"> <!-- Link to go back to the home page -->
                    <i class="fas fa-arrow-left"></i> Regresar al inicio <!-- Icon and text for the button -->
                </a>
            </div>
            <div class="col-md-3"> <!-- Column for the "Save Client" button -->
                <button type="submit" class="btn btn-success btn-block"> <!-- Button to save the client information -->
                    <i class="fas fa-check"></i> Guardar Cliente <!-- Icon and text for the button -->
                </button>
            </div>
            <div class="col-md-3"> <!-- Column for the "Delete Client" button -->
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}" 
                   class="btn btn-danger btn-block"> <!-- Link to delete the client -->
                    <i class="fas fa-trash"></i>Eliminar Cliente <!-- Icon and text for the button -->
                </a>
            </div>            
        </div>
    </div>    
</section>
