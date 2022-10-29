package tp06.ex02;

public class Persona extends Thread {
    
    private static int ID = 0; 

    private final GestorSala gestorSala; 
    private final boolean jubilada;
    private final int tiempoQuedarse;
    private final int id;

    public Persona(GestorSala gestorSala, boolean jubilada, int tiempoQuedarse)
    {
        this.gestorSala = gestorSala;
        this.jubilada = jubilada;
        this.tiempoQuedarse = tiempoQuedarse;
        this.id = ID++;
    }

    @Override
    public void run()
    {
        if(jubilada)
            gestorSala.entrarSalaJubilado(id);
        else
            gestorSala.entrarSala(id);

        try {sleep(tiempoQuedarse);} catch (InterruptedException e) {}
        gestorSala.salirSala(id);
    }
}
