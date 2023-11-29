package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;


public class Controlador extends HttpServlet {

    String listar = "vista/admon-usuarios.jsp";
    String add = "vista/admon-usuarios-add.jsp";
    String edit = "vista/admon-usuarios-editar.jsp";
    Usuario u = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (accion.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (accion.equalsIgnoreCase("Agregar")) {
            
            
            String nombre = request.getParameter("txtNombre");
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtPassword");
            int idRol = Integer.parseInt(request.getParameter("txtIdRol"));

            u.setNombreCompleto(nombre);
            u.setNombreUsuario(usuario);
            u.setPassword(password);
            u.setIdRol(idRol);

            dao.add(u);
            //vuelve a listar.jsp
            acceso = listar;
            
            
        } else if (accion.equalsIgnoreCase("editar")) {
            
            request.setAttribute("idUsuario", request.getParameter("idUsuario"));
            acceso = edit;
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            
            id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombre");
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtPassword");
            int idRol = Integer.parseInt(request.getParameter("txtIdRol"));

            u.setIdUsuario(id);
            u.setNombreCompleto(nombre);
            u.setNombreUsuario(usuario);
            u.setPassword(password);
            u.setIdRol(idRol);
            
            dao.edit(u);
            
            acceso = listar;
            
        } else if(accion.equalsIgnoreCase("eliminar")) {
            
            id = Integer.parseInt(request.getParameter("idUsuario"));
            u.setIdUsuario(id);
            dao.eliminar(id);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
