package tp03.ex04;

public class Actividad {
    
    private final String nombre;
    private boolean libre = true;

    public Actividad(String nombre)
    {
        this.nombre = nombre;
    }

    public synchronized boolean estaLibre()
    {
        return libre;
    }

    public synchronized void setLibre(boolean libre)  
    {
        this.libre = libre;
    }

    public String getNombre()
    {
        return nombre;
    }
}
