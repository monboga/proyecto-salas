package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAOUsuario;
import modelo.Usuario;

@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try {

            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarSesion(request, response);
                        break;
                    default:
                        response.sendRedirect("/login.jsp");
                }

            } else {
                response.sendRedirect("/login.jsp");
            }

        } catch (Exception e) {
            try {

            } catch (Exception ex) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion;
        DAOUsuario dao;
        Usuario usuario;

        //metodo para obtener el usuario
        usuario = this.obtenerUsuario(request);

        //instanciar dao usuario
        dao = new DAOUsuario();
        usuario = dao.identificar(usuario);

        if (usuario != null && usuario.getRol().getDescripcion().equals("administrador")) {

            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido al Sistema");

            this.getServletConfig().getServletContext().getRequestDispatcher("../vista/administrador.jsp").forward(request, response);

        } else if (usuario != null && usuario.getRol().getDescripcion().equals("empleado")) {
            sesion = request.getSession();
            sesion.setAttribute("empleado", usuario);

            this.getServletConfig().getServletContext().getRequestDispatcher("../vista/empleado.jsp").forward(request, response);
        } else {
            request.setAttribute("msje", "Credenciales Incorrectas");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);

        sesion.invalidate();
        response.sendRedirect("login.jsp");
    }

    private Usuario obtenerUsuario(HttpServletRequest request) {
        Usuario u = new Usuario();
        u.setNombreUsuario(request.getParameter("txtUsuario"));
        u.setContraseña(request.getParameter("txtContraseña"));
        return u;
    }

}
