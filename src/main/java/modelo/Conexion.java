
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    private final String baseDatos = "cansalas";
    private final String servidor = "jdbc:mysql://localhost/" + baseDatos;
    private final String usuario = "root";
    private final String password = "gabrielMonroy1905";
    
    
    public Connection conectar() {
        Connection cn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(servidor, usuario, password);
        } catch(Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        
        return cn;
    }
    
}
