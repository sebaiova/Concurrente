package tp03.ex04;

public class Jaula {

    private int HAMSTERS_NUMBER = 5;
    private Actividad[] actividades;
    private Hamster[] hamsters;

    public Jaula() throws InterruptedException 
    {
        actividades = new Actividad[3];
        actividades[0] = new Actividad("Caja de Comida");
        actividades[1] = new Actividad("Rueda");
        actividades[2] = new Actividad("Hamaca");

        hamsters = new Hamster[HAMSTERS_NUMBER];
        for(int i=0; i<HAMSTERS_NUMBER; i++)
        {
            hamsters[i] = new Hamster(this);
            hamsters[i].start();
        }

        for(int i=0; i<HAMSTERS_NUMBER; i++)
        {
            hamsters[i].join();
        }
    }

    public void usar(int actividad, Hamster hamster) throws InterruptedException
    {
        actividades[actividad].usar(hamster);
    }
}
