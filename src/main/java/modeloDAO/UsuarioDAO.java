package modeloDAO;

import config.Conexion;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO implements CRUD {

    Conexion cn = new Conexion();

    Connection con;

    PreparedStatement pst;
    ResultSet rs;
    Usuario u = new Usuario();

    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from Usuarios";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setNombreCompleto(rs.getString("nombreCompleto"));
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setPassword(rs.getString("contraseña"));
                usu.setIdRol(rs.getInt("idRol"));
                list.add(usu);
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Usuario list(int id) {

        ArrayList<Usuario> list = new ArrayList<>();
        //tener cuidado en donde se pone el select **faltaba poner en donde estabas haciendo la busqueda.
        String sql = "select * from Usuarios where idUsuario=" + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                u.setNombreCompleto(rs.getString("nombreCompleto"));
                u.setNombreUsuario(rs.getString("nombreUsuario"));
                u.setPassword(rs.getString("contraseña"));
                u.setIdRol(rs.getInt("idRol"));
            }
        } catch (Exception e) {

        }
        return u;

    }

    @Override
    public boolean add(Usuario usu) {
        String sql = "insert into Usuarios(nombreCompleto, nombreUsuario, contraseña, idRol) values('" + usu.getNombreCompleto() + "','" + usu.getNombreUsuario() + "','" + usu.getPassword() + "', '" + usu.getIdRol() + "')";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean edit(Usuario usu) {
        String sql = "update Usuarios set nombreCompleto='" + usu.getNombreCompleto() +"',nombreUsuario='" + usu.getNombreUsuario() + "',contraseña='" + usu.getPassword() +"',idRol='" + usu.getIdRol() + "' where idUsuario=" + usu.getIdUsuario();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            
        } catch(Exception e) {
            
        }
        
        return false;

    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Usuarios where idUsuario=" + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            
        }
        
        return false;
    }

}
