<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"> <!-- Set character encoding to UTF-8 -->
        <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- Responsive design -->
        <title>Control de Clientes</title> <!-- Page title -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> <!-- Bootstrap CSS -->
        <script src="https://kit.fontawesome.com/84fed67ba9.js" crossorigin="anonymous"></script> <!-- Font Awesome for icons -->
    </head>

    <body>
        <!<!-- Cabecero --> 
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/> <!-- Include header -->

        <!<!-- Botones -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/> <!-- Include navigation buttons -->

        <!<!-- Listado Clientes -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/> <!-- Include client list -->

        <!<!-- Footer -->
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/> <!-- Include footer -->

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script> <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script> <!-- Popper.js for tooltips and popovers -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script> <!-- Bootstrap JS -->
    </body>
</html>
