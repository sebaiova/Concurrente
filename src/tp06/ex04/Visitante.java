package tp06.ex04;

public class Visitante extends Thread {
 
    private static final String tipo = "Visitante";
    private static int ID = 0;

    private final Observatorio observatorio;
    private final int id = ID++;
    private final int velocidad;

    public Visitante(int velocidad, Observatorio observatorio)
    {
        this.velocidad = velocidad;
        this.observatorio = observatorio;
    }

    @Override 
    public void run()
    {
        observatorio.entrar(tipo, id);
        try { sleep(velocidad*500);} catch (InterruptedException e) {}
        observatorio.salir(tipo, id);
    }
}
