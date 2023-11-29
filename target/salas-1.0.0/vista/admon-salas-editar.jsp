
<%@page import="modelo.Salas"%>
<%@page import="modeloDAO.SalasDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="modeloDAO.UsuarioDAO"%>
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

        <title>Salas - Administrador</title>
        <!--main css-->
        <link rel="stylesheet" href="./css/estilos-vista.css" />
        <!-- font awesome -->
        <link rel="stylesheet" href="./css/all.min.css" />

        <!-- bootstrap css -->
        <link rel="stylesheet" href="./bootstrap/bootstrap.min.css" />


        <!-- imagen del icono de enlace -->
        <link rel="shortcut icon" href="./img/logo-icon.png"/>
    </head>
    <body>

        <!-- navbar -->
        <nav class="sidebar">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="./img/LOGO-140-VECTORES-04.png" alt="" />
                    </span>

                    <div class="text header-text">
                        <span class="name">Usuario:

                            <%
                                if (sesion.getAttribute("user") != null && session.getAttribute("rol") != null) {
                                    usuario = sesion.getAttribute("user").toString();
                                    rol = sesion.getAttribute("rol").toString();

                                    out.print(usuario);
                                } else {
                                    out.print("<script>location.replace('../login.jsp');</script>");
                                }


                            %>

                        </span>
                        <span class="profession">Administrador</span>
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
                        <a href="administrador.jsp">
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
                    <li class="menu-link">
                        <span class="text nav-text">Operaciones</span>
                    </li>
                    <li class="nav-link">
                        <a href="admon-usuarios.jsp">
                            <i class="fa-solid fa-users icon"></i>
                            <span class="text nav-text">Usuarios</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="#admon-reservaciones">
                            <i class="fa-solid fa-people-roof icon"></i>
                            <span class="text nav-text">Reservaciones</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="#admon-catalogos">
                            <i class="fa-solid fa-folder-tree icon"></i>
                            <span class="text nav-text">Catalogos</span>
                        </a>
                    </li>
                </div>
            </div>
        </nav>

        <section class="home">

            <div class="text container">
                <div class="col-lg-6">
                    <h1 class="text-primary h1">Catalogo de Salas/Editar</h1>
                    <%                    
                        SalasDAO dao = new SalasDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idUsuario"));

                        Salas s = (Salas) dao.list(id);
                    %>
                    <h1 class="h3">Modificar Sala</h1>
                    <form action="ControladorSala">
                        <label class="label-control fs-7">id: </label><input type="hidden" name="txtId" value="<%= id%>"><br>
                        <input class="form-control" type="text" name="txtSala" value="<%= s.getNombreSala()%>"><br>
                        <input class="form-control" type="text" name="txtPiso" value="<%= s.getPiso()%>"><br>
                   
                        <input class="btn btn-success" type="submit" name="accion" value="Actualizar"><br>
                        <a class="btn btn-primary" href="./ControladorSala?accion=listar">Regresar</a>
                    </form>

                </div>
            </div>

        </section>

        <!-- bootstrap js -->
        <script src="./bootstrap/bootstrap.bundle.min.js"></script>
        <script src="./js/script-panel.js"></script>
    </body>
</html>


