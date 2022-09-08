package tp03.ex04;

public class Jaula {

    private Actividad[] actividades;

    public Jaula() throws InterruptedException 
    {
        actividades = new Actividad[3];
        actividades[0] = new Actividad("Caja de Comida");
        actividades[1] = new Actividad("Rueda");
        actividades[2] = new Actividad("Hamaca");
    }

    public void usar(int actividad) 
    {
        actividades[actividad].setLibre(false);
    }

    public void dejarDeUsar(int actividad)
    {
        actividades[actividad].setLibre(true);
    }

    public boolean estaLibre(int actividad)
    {
        return actividades[actividad].estaLibre();
    }

    public String getNombreActividad(int actividad)
    {
        return actividades[actividad].getNombre();
    }
}
