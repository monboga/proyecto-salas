
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%

    HttpSession sesion = request.getSession();
    String usuario;
    String rol;


%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <title>Home - Empleado</title>
        <!--main css-->
        <link rel="stylesheet" href="../css/estilos-vista.css" />
        <!-- font awesome -->
        <link rel="stylesheet" href="../css/all.min.css" />

        <!-- bootstrap css -->
        <link rel="stylesheet" href="../css/bootstrap.min.css" />

        <!-- imagen del icono, enlace -->
        <link rel="shortcut icon" href="../img/logo-icon.png"/>

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
                        <%                            if (sesion.getAttribute("user") != null && sesion.getAttribute("rol") != null) {
                                usuario = sesion.getAttribute("user").toString();
                                rol = sesion.getAttribute("rol").toString();

                                out.print("<span>Usuario: " + usuario + "</span>");
                            } else {
                                out.print("<script>location.replace('../login.jsp');</script>");

                            }


                        %>
                        <span class="profession">Empleado</span>
                    </div>
                </div>

                <i class="fa-solid fa-arrow-right toggle"></i>
            </header>

            <div class="menu-bar">
                <div class="menu">
                    <div class="bottom-content">
                        <li class="">
                            <a href="../login.jsp?cerrar=true">
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

