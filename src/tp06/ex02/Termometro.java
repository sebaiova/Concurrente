package tp06.ex02;

import java.util.Random;

public class Termometro extends Thread {
    
    private final GestorSala gestorSala;
    private final Random random = new Random();
    private final int tiempo;

    public Termometro(GestorSala gestorSala, int tiempo)
    {
        this.gestorSala = gestorSala;
        this.tiempo = tiempo;
    }

    @Override
    public void run()
    {
        while(gestorSala.isRunning())
        {
            int temperatura = random.nextInt(30)+10;    // (10,40)
            gestorSala.notificarTemperatura(temperatura);
            try { sleep(tiempo);} catch (InterruptedException e) {}
        }
    }
}
