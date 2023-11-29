
package modelo;

public class Salas {
    
    int idSala;
    String nombreSala;
    String piso;

    public Salas() {
    }

    public Salas(int idSala, String nombreSala, String piso) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.piso = piso;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
    
}
