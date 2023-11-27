
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

    if(session.getAttribute("empleado") != null) {
    
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <title>Sidebar menu</title>
        <!--main css-->
        <link rel="stylesheet" href="../css/main.css" />
        <!-- font awesome -->
        <link rel="stylesheet" href="../css/all.min.css" />

        <!-- bootstrap css -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" />
    </head>
    <body>
        <!-- navbar -->
        <nav class="sidebar">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="../img/LOGO-140-VECTORES-04.png" alt="" />
                    </span>

                    <div class="text header-text">
                        <span class="name">${empleado.nombreUsuario}</span>
                        <span class="profession">${empleado.rol.descripcion}</span>
                    </div>
                </div>

                <i class="fa-solid fa-arrow-right toggle"></i>
            </header>

            <div class="menu-bar">
                <div class="menu">
                    <div class="bottom-content">
                        <li class="">
                            <a href="#">
                                <i
                                    class="fa-solid fa-right-from-bracket fa-rotate-180 icon"
                                    ></i>
                                <span class="text nav-text">Salir</span>
                            </a>
                        </li>
                    </div>
                    <li class="menu-link">
                        <span class="text nav-text">Home</span>
                    </li>
                    <li class="nav-link">
                        <a href="">
                            <i class="fa-solid fa-house icon"></i>
                            <span class="text nav-text">Recepción</span>
                        </a>
                    </li>
                    <li class="menu-link">
                        <span class="text nav-text">Salas</span>
                    </li>
                    <li class="nav-link">
                        <a href="">
                            <i class="fa-solid fa-calendar-days icon"></i>
                            <span class="text nav-text">Eventos</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="">
                            <i class="fa-solid fa-clipboard-list icon"></i>
                            <span class="text nav-text">Reservaciones</span>
                        </a>
                    </li>
                </div>
            </div>
        </nav>

        <section class="home">

            <div class="text">
                Recepcion
            </div>

        </section>

        <!-- bootstrap js -->
        <script src="../js/bootstrap.bundle.min.js"></script>
        <script src="../js/script-panel.js"></script>
    </body>
</html>

<%
    }else {
    response.sendRedirect("login.jsp");
}

%>
