package tp03.ex04;

public class Hamster extends Thread {
    
    static int hamsterCounter = 0;

    private final int numero = hamsterCounter++;
    private final Jaula jaula;

    public Hamster(Jaula jaula) 
    {
        this.jaula = jaula;
    }

    public int getNumero() 
    {
        return numero;
    }

    @Override
    public void run()
    {
        int tarea = 0;

        while(tarea < 3)
        {
            if(jaula.estaLibre(tarea))
            {
                System.out.printf("Hamster \"%d\" a empezado a usar \"%s\"\n", numero, jaula.getNombreActividad(tarea));
                jaula.usar(tarea);
                try {sleep(500);} catch (InterruptedException e) { e.printStackTrace(); }
                jaula.dejarDeUsar(tarea);
                System.out.printf("Hamster \"%d\" a dejado de usar \"%s\"\n", numero, jaula.getNombreActividad(tarea));
                tarea++;
            }
        }
    }
}