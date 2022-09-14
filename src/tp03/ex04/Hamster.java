package tp03.ex04;

import java.util.Random;

public class Hamster extends Thread {
    
    static int hamsterCounter = 0;

    private final int numero = hamsterCounter++;
    private final Jaula jaula;

    public Hamster(Jaula jaula) 
    {
        this.jaula = jaula;
    }

    @Override
    public void run()
    {
        int tareasRealizadas = 0;
        Random random = new Random();
        // Cada hamsters debe realizar cualquier tarea 3 veces.
        while(tareasRealizadas < 3)
        {
            int tarea = random.nextInt(3);
            if(jaula.usar(tarea))
            {
                System.out.printf("Hamster \"%d\" a empezado a usar \"%s\"\n", numero, jaula.getNombreActividad(tarea));
                try {sleep(500);} catch (InterruptedException e) { e.printStackTrace(); }
                System.out.printf("Hamster \"%d\" a dejado de usar \"%s\"\n", numero, jaula.getNombreActividad(tarea));
                jaula.dejarDeUsar(tarea);
                tareasRealizadas++;
            }
        }
    }
}