
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Operaciones {
    String driver;
    String url;
    String user;
    String password;
    
    public Operaciones() {
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/cansalas";
        user = "root";
        password = "gabrielMonroy1905";
    }
    
    public int verificar(String usu, String pass) {
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        int rol = 0;
        
        String sql = "SELECT idRol FROM Usuarios WHERE nombreUsuario= '" + usu + "'and contraseña='" + pass + "'";
        
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(
            
                    this.url,
                    this.user,
                    this.password
            );
            
            
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()) {
                rol = rs.getInt(1);
            }
            
            con.close();
            
        } catch(Exception e) {
            
        }
        return rol;
    }
}
