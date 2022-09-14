package tp03.ex04;

public class Actividad {
    
    private final String nombre;
    private boolean ocupada = false;

    public Actividad(String nombre)
    {
        this.nombre = nombre;
    }

    public synchronized boolean usar()
    {
        return ocupada==false ? (ocupada = true) : false;
    }

    public synchronized void dejarDeUsar()  
    {
        ocupada = false;
    }

    public String getNombre()
    {
        return nombre;
    }
}
