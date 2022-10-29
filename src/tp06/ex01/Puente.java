package tp06.ex01;

import java.util.LinkedList;
import java.util.Queue;

// MON
public class Puente {
    
    private final int CAPACIDAD;
    private final int MAX_CONSECUTIVOS;

    private int consecutivosSur;    /**************************/
    private int consecutivosNorte;  /* solo para implementar */
    private int enEsperaSur;        /* ceder el paso        */
    private int enEsperaNorte;      /***********************/

    private final Queue<Integer> filaSur = new LinkedList<>();
    private final Queue<Integer> filaNorte = new LinkedList<>();

    public Puente(int capacidad, int maxConsecutivos)
    {
        this.CAPACIDAD = capacidad;
        this.MAX_CONSECUTIVOS = maxConsecutivos;
    }

    public synchronized void empezarCruzarSur(int id)
    {
        enEsperaSur++;
        while(!filaNorte.isEmpty() || filaSur.size() >= CAPACIDAD || surDebeCederPaso())
            try { wait(); } catch (InterruptedException e) {}
        enEsperaSur--;
        consecutivosSur++;
        consecutivosNorte=0;

        System.out.printf("\u001B[31mCoche [%d] ha comenzado a cruzar hacia el Sur.\n", id);
        filaSur.add(id);
    }

    public synchronized void empezarCruzarNorte(int id)
    {
        enEsperaNorte++;
        while(!filaSur.isEmpty() || filaNorte.size() >= CAPACIDAD || norteDebeCederPaso())
            try { wait(); } catch (InterruptedException e) {}
        enEsperaNorte--;
        consecutivosNorte++;
        consecutivosSur=0;

        System.out.printf("\u001B[31mCoche [%d] ha comenzado a cruzar hacia el Norte.\n", id);
        filaNorte.add(id);
    }

    public synchronized void terminarCruzarSur(int id)
    {
        while(filaSur.peek()!=id)
            try { wait(); } catch (InterruptedException e) {}

        System.out.printf("\u001B[33mCoche [%d] ha terminado de cruzar hacia el Sur.\n", id);
        filaSur.poll();
        notifyAll();
    }

    public synchronized void terminarCruzarNorte(int id)
    {
        while(filaNorte.peek()!=id)
            try { wait(); } catch (InterruptedException e) {}

        System.out.printf("\u001B[33mCoche [%d] ha terminado de cruzar hacia el Norte.\n", id);
        filaNorte.poll();
        notifyAll();
    }

    private boolean surDebeCederPaso()
    {
        boolean ceder;
        if(ceder = (consecutivosSur >= MAX_CONSECUTIVOS && enEsperaNorte > 0))
            System.out.printf("\u001B[34mSur debe ceder el Paso.\n");
        return ceder;
    }

    private boolean norteDebeCederPaso()
    {
        boolean ceder;
        if(ceder = (consecutivosNorte >= MAX_CONSECUTIVOS && enEsperaSur > 0))
            System.out.printf("\u001B[34mNorte debe ceder el Paso.\n");
        return ceder;
    }
}
