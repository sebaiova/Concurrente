package tp05.ex04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class TrenTuristico {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";  
    public static final String GREEN = "\u001B[32m";

    private final HashMap<Integer, Semaphore> semEsperarTicket;
    private final Queue<Integer> filaComprarTicket;
    
    private final Semaphore semSubir;
    private final Semaphore semBajar;
    private final Semaphore semAndar;
    private final Semaphore semListo;

    private final int lugaresTren;

    public TrenTuristico(int lugaresTren)
    {
        this.semEsperarTicket = new HashMap<>();
        this.filaComprarTicket = new LinkedList<>();

        this.semSubir = new Semaphore(lugaresTren);
        this.semBajar = new Semaphore(0);
        this.semAndar = new Semaphore(0);
        this.semListo = new Semaphore(0);

        this.lugaresTren = lugaresTren;
    }

    public void comprarTicket(int pasajero)
    {
        System.out.printf("%sEl pasajero [%d] hace la fila para comprar un Ticket.\n", RESET, pasajero);
        semEsperarTicket.put(pasajero, new Semaphore(0));
        filaComprarTicket.add(pasajero);

        // Espera que el vendedor lo libere
        try { semEsperarTicket.get(pasajero).acquire();} catch (InterruptedException e) {}
        semEsperarTicket.remove(pasajero);
    }

    public void venderTicket()
    {
        if(!filaComprarTicket.isEmpty()) 
        {
            int pasajero = filaComprarTicket.poll();
            System.out.printf("%sVendido Ticket al pasajero [%d].\n", RESET, pasajero);
            semEsperarTicket.get(pasajero).release();
        }
    }
    
    public void subir(int id)
    {
        try {semSubir.acquire();} catch (InterruptedException e) {}
        System.out.printf("%sPasajero [%d] se ha subido al Tren.\n", BLUE, id);
        semAndar.release();
    }

    public void bajar(int id)
    {
        try {semBajar.acquire(1);} catch (InterruptedException e) {}
        System.out.printf("%sPasajero [%d] se ha bajado del Tren.\n", CYAN, id);
        semBajar.release();
        semListo.release();
    }

    public void viajar()
    {
        try { semAndar.acquire(lugaresTren);} catch (InterruptedException e) {}
        System.out.printf("%sEl Tren empieza el Viaje...\n", RED);
        try {Thread.sleep(2000);} catch (InterruptedException e1) {}
        System.out.printf("%sEl Tren termino el Viaje.\n", PURPLE);
        semBajar.release();
        try {semListo.acquire(lugaresTren);} catch (InterruptedException e) {}
        System.out.printf("%sTodos los pasajeros bajaron. Listo para un nuevo Viaje.\n", GREEN);
        try {semBajar.acquire();} catch (InterruptedException e) {}
        semSubir.release(lugaresTren);
    }
}
