package tp06.ex01;

public class Auto extends Thread {

    static int ID = 0;

    private final Puente puente;
    private final int id = ID++;
    private final boolean direccion; 
    private final int velocidad;

    public Auto(boolean direccion, int velocidad, Puente puente)
    {
        this.direccion = direccion;
        this.velocidad = velocidad;
        this.puente = puente;
    }

    @Override
    public void run()
    {
        if(direccion)
        {
            puente.empezarCruzarSur(id);
            try { sleep(1000/velocidad);} catch (InterruptedException e) {}
            puente.terminarCruzarSur(id);
        }
        else
        {
            puente.empezarCruzarNorte(id);
            try { sleep(1000/velocidad);} catch (InterruptedException e) {}
            puente.terminarCruzarNorte(id);
        }
    }
}
