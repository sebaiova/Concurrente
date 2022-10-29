package tp06.ex02;

import java.util.LinkedList;
import java.util.Queue;

public class GestorSala {
    
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    private final int tUmbral = 30;
    private final int capacidadMaxima = 50;
    private final int capacidadLimitada = 35;
    private final Queue<Integer> filaPersonas = new LinkedList<>();
    private final Queue<Integer> filaJubilados = new LinkedList<>();

    private int temperatura = 20;
    private int cantidadPersonas = 0;
    private int capacidad = capacidadMaxima;

    private boolean cerrado = false;

    public synchronized void entrarSala(int id)
    {
        filaPersonas.add(id);
        while( estaLleno() || filaJubilados.size()!=0 || filaPersonas.peek()!=id )
            try { wait(); } catch (InterruptedException e) {}

        filaPersonas.poll();
        cantidadPersonas++;
        System.out.printf("%sPersona [%d] ha entrado a la sala.\n", BLUE, id);
    }

    public synchronized void entrarSalaJubilado(int id)
    {
        filaJubilados.add(id);
        while( estaLleno() || filaJubilados.peek()!=id )
            try { wait(); } catch (InterruptedException e) {}

        filaJubilados.poll();
        cantidadPersonas++;
        System.out.printf("%sJubilado [%d] ha entrado a la sala.\n", BLUE, id);
    }

    public synchronized void salirSala(int id)
    {
        cantidadPersonas--;
        notifyAll();
        System.out.printf("%sPersona [%d] ha salido de la sala.\n", CYAN, id);
    }

    public synchronized void notificarTemperatura(int temp)
    {
        temperatura = temp;
        capacidad = temperatura > tUmbral ? capacidadLimitada : capacidadMaxima;
        notifyAll();
        printState();
    }

    public synchronized void cerrar()
    {
        cerrado = true;
    }

    public synchronized boolean isRunning()
    {
        return !cerrado || cantidadPersonas!=0;
    }

    private boolean estaLleno()
    {
        return cantidadPersonas >= capacidad;
    }

    private void printState()
    {
        System.out.printf("%sFila: [%d/%d] - T: %dº Personas: %d Capacidad: %d.\n", RED, filaPersonas.size(), filaJubilados.size(), temperatura, cantidadPersonas, capacidad);
    }
}
