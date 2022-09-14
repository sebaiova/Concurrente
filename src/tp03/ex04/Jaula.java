package tp03.ex04;

public class Jaula {

    private Actividad[] actividades;

    public Jaula()  
    {
        actividades = new Actividad[3];
        actividades[0] = new Actividad("Caja de Comida");
        actividades[1] = new Actividad("Rueda");
        actividades[2] = new Actividad("Hamaca");
    }

    public boolean usar(int actividad) 
    {
        return actividades[actividad].usar();
    }

    public void dejarDeUsar(int actividad)
    {
        actividades[actividad].dejarDeUsar();
    }

    public String getNombreActividad(int actividad)
    {
        return actividades[actividad].getNombre();
    }
}
