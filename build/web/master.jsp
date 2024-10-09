<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String title = ""; 
%>
<!-- master.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= title != null ? title : "Menu" %></title>
    <link rel="stylesheet" href="styles/bootstrap.min.css">
</head>
<body>
    <!-- Cabecera común para todas las páginas -->
    <!--<header class="bg-primary text-white text-center py-3">
        <h1>Menú</h1>
    </header>-->

    <!-- Menú de navegación usando Bootstrap -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="master.jsp">Mi Aplicación</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="puestos.jsp">Puestos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Incluyendo scripts JS de Bootstrap y Popper.js -->
    <script src="js/jquery.min.js"></script>
    <script src="js/sweetalert2.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
