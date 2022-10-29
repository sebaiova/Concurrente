package tp06.ex01;

import java.util.Random;

public class GeneradorAutos extends Thread {
    
    private final Puente puente;
    private final int frecuenciaFactor;
    private final Random random;
    private int cantidad;

    public GeneradorAutos(int cantidad, int frecuenciaFactor, Puente puente)
    {
        this.cantidad = cantidad;
        this.puente = puente;
        this.frecuenciaFactor = frecuenciaFactor;
        this.random = new Random();
    }

    @Override
    public void run()
    {
        while(cantidad>0)
        {
            try { sleep(random.nextInt(2000)/frecuenciaFactor);} catch (InterruptedException e) {}
            generar();
            cantidad--;
        }
    }

    private void generar()
    {
        boolean direccion = random.nextBoolean();
        int velocidad = random.nextInt(9)+1;    // 0 > x > 10 

        Auto auto = new Auto(direccion, velocidad, puente);
        auto.start();
    } 
}
