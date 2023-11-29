package modeloDAO;

import config.Conexion;
import interfaces.CRUDSalas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Salas;

public class SalasDAO implements CRUDSalas {

    Conexion cn = new Conexion();

    Connection con;

    PreparedStatement pst;
    ResultSet rs;
    Salas s = new Salas();

    @Override
    public List listar() {
        ArrayList<Salas> list = new ArrayList<>();
        String sql = "select * from Salas";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Salas sal = new Salas();
                sal.setIdSala(Integer.parseInt(rs.getString("idSala")));
                sal.setNombreSala(rs.getString("nombreSala"));
                sal.setPiso(rs.getString("piso"));
                list.add(sal);
            }
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Salas list(int id) {
        ArrayList<Salas> list = new ArrayList<>();
        //tener cuidado en donde se pone el select **faltaba poner en donde estabas haciendo la busqueda.
        String sql = "select * from Salas where idSala=" + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                s.setNombreSala(rs.getString("nombreSala"));
                s.setPiso(rs.getString("piso"));
            }
        } catch (Exception e) {

        }
        return s;
    }

    @Override
    public boolean add(Salas sala) {
        String sql = "insert into Salas(nombreSala, piso) values('" + sala.getNombreSala() + "','" + sala.getPiso() + "')";

        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean edit(Salas sala) {
        String sql = "update Salas set nombreSala='" + sala.getNombreSala()+ "',piso='" + sala.getPiso() + "' where idSala=" + sala.getIdSala();
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from Salas where idSala=" + id;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {

        }

        return false;
    }

}
