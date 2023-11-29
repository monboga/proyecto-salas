package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Salas;
import modeloDAO.SalasDAO;

public class ControladorSala extends HttpServlet {

    String listar = "vista/admon-salas.jsp";
    String add = "vista/admon-salas-add.jsp";
    String edit = "vista/admon-salas-editar.jsp";
    Salas s = new Salas();
    SalasDAO dao = new SalasDAO();
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

            String nombre = request.getParameter("txtSala");
            String piso = request.getParameter("txtPiso");

            
            s.setNombreSala(nombre);
            s.setPiso(piso);
       

            dao.add(s);
            //vuelve a listar.jsp
            acceso = listar;

        } else if (accion.equalsIgnoreCase("editar")) {

            request.setAttribute("idSala", request.getParameter("idSala"));
            acceso = edit;
        } else if (accion.equalsIgnoreCase("Actualizar")) {

            id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtSala");
            String piso = request.getParameter("txtPiso");
            

            s.setIdSala(id);
            s.setNombreSala(nombre);
            s.setPiso(piso);

            dao.edit(s);

            acceso = listar;

        } else if (accion.equalsIgnoreCase("eliminar")) {

            id = Integer.parseInt(request.getParameter("idSala"));
            s.setIdSala(id);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
