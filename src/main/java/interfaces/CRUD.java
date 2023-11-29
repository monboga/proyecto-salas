
package interfaces;

//Aqui van todas nuestras acciones CRUD

import java.util.List;
import modelo.Usuario;


public interface CRUD {
    
    public List listar();
    public Usuario list(int id);
    public boolean add(Usuario usu);
    public boolean edit(Usuario usu);
    public boolean eliminar(int id);
    
    
    
}
