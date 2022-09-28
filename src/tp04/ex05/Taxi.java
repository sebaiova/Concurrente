package tp04.ex05;

import java.util.concurrent.Semaphore;

public class Taxi {
    
    private final Semaphore semLibre;
    private final Semaphore semOcupado;
    private final Semaphore semFinViaje;

    public Taxi()
    {
        semLibre = new Semaphore(1);
        semOcupado = new Semaphore(0);
        semFinViaje = new Semaphore(0);
    }

    public void tomarTaxi() 
    {
        try { semLibre.acquire(); } catch (InterruptedException e) { }
        System.out.println("El cliente se subió al taxi.");
        semOcupado.release();
        try { semFinViaje.acquire(); } catch (InterruptedException e) { }
        System.out.println("El cliente se bajó del taxi.\n");
    }

    public void realizarViaje()
    {
        try { semOcupado.acquire(); } catch (InterruptedException e) { }
        System.out.println("El taxista se despierta y comienza a conducir");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println("El taxista termina el viaje");
        semFinViaje.release();

        System.out.println("El taxista descansa.");
        semLibre.release();
    }
}
