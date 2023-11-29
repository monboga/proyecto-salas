
package interfaces;

import java.util.List;
import modelo.Salas;


public interface CRUDSalas {
    
    public List listar();
    public Salas list(int id);
    public boolean add(Salas sala);
    public boolean edit(Salas sala);
    public boolean eliminar(int id);
    
    
}
