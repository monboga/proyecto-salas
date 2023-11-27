package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOUsuario extends Conexion {

    public Usuario identificar(Usuario user) throws Exception {
        Usuario usu = null;
        Conexion con;

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select u.idUsuario, r.descripcion from Usuarios u "
                + "inner join Roles r on u.idRol = r.idRol "
                + "where u.nombreUsuario = '" + user.getNombreUsuario() + "' "
                + "and u.contraseña = '" + user.getContraseña() + "'";

        con = new Conexion();

        try {

            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next() == true) {
                usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombreUsuario(user.getNombreUsuario());
                usu.setRol(new Roles());
                usu.getRol().setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
        return usu;
    }

}
