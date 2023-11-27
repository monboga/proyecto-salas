<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <title>Login - Canaco Servytur Monterrey</title>

        <!-- Link de Bootstrap CSS-->
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css" />
        <!-- Link de Archivo CSS -->
        <link rel="stylesheet" href="css/estilos.css" />
        <!-- Link de Font Awesome -->
        <link rel="stylesheet" href="css/all.min.css" />
        <!-- imagen del icono en la pestaña del navegador -->
        <link rel="shortcut icon" href="img/logo-icon.png"/>


    </head>

    <body>

        <header class="header">
            <div class="container">
                <!--NavBar-->
                <nav class="navbar navbar-dark navbar-expand-lg bg-transparent">
                    <div class="container">
                        <a class="navbar-brand" href="#">
                            <img src="img/LOGO-140-VECTORES-02.png" alt="" class="img-logo" />
                        </a>
                        <!--boton toggle-->
                        <button
                            class="navbar-toggler shadow-none border-0"
                            type="button"
                            data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasNavbar"
                            aria-controls="offcanvasNavbar"
                            aria-label="Toggle navigation"
                            >
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <!--barra lateral-->
                        <div
                            class="sidebar offcanvas offcanvas-start"
                            tabindex="-1"
                            id="offcanvasNavbar"
                            aria-labelledby="offcanvasNavbarLabel"
                            >
                            <!--barra lateral header-->
                            <div class="offcanvas-header border-bottom">
                                <img
                                    src="img/LOGO-140-VECTORES-04.png"
                                    class="img-sidebar-logo offcanvas-title"
                                    id="offcanvasNavbarLabel"
                                    />
                                <button
                                    type="button"
                                    class="btn-close btn-close-white shadow-none border-0"
                                    data-bs-dismiss="offcanvas"
                                    aria-label="Close"
                                    ></button>
                            </div>
                            <!--cuerpo de barra lateral-->
                            <div class="offcanvas-body d-flex flex-column flex-lg-row p-4">
                                <ul
                                    class="navbar-nav justify-content-end align-items-center fs-6 flex-grow-1 pe-3"
                                    >
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="index.html"
                                           >Home</a>
                                    </li>
                                    <li class="nav-item mx-2">
                                        <a class="nav-link" href="acerca-de.html">Acerca de</a> <!--Puse el link para que se vinculara-->
                                    </li>
                                    <li class="nav-item mx-2">
                                        <a class="nav-link" href="salas.html">Salas</a> <!--Puse el link para que se vinculara-->
                                    </li>
                                    <li class="nav-item mx-2">
                                        <a class="nav-link" href="reservaciones.html">Reservación</a>
                                    </li>
                                    <li class="nav-item mx-2">
                                        <a class="nav-link" href="contacto.html">Contacto</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <!-- seccion del inicio de sesion -->

        <section class="form-login my-5">
            <div class="container">

                <div class="card mb-3 w-100">
                    <div class="row g-0">
                        <div class="col-md-6 bg-primary text-center">
                            <img src="img/img-login.png" class="img-fluid rounded-start img-login" alt="...">
                        </div>
                        <div class="col-md-6">
                            <div class="card-body d-flex flex-column my-5 py-5 px-5">
                                <h1 class="fs-4 text-center fw-bold">Iniciar Sesión</h1>
                                <form action="srvUsuario?accion=verificar" class="row" method="POST">
                                    <div class="mb-3">
                                        <input type="text" class="form-control" name="txtUsuario" placeholder="Nombre de Usuario">
                                    </div>
                                    <div class="mb-3">
                                        <input type="password" class="form-control" name="txtContraseña" placeholder="Contraseña">
                                    </div>
                                    <input type="submit" name="verificar" value="Iniciar Sesion" class="btn btn-primary m-auto py-3 w-auto">

                                    <div class="mb-3">
                                        <p>Verificación de credenciales</p>
                                        <a href="#" class="btn btn-block"><i class="fa fa-info"></i> Mensaje: </a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <!-- link de bootstrap -->
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
