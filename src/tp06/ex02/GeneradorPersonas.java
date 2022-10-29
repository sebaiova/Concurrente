package tp06.ex02;

import java.util.Random;

public class GeneradorPersonas extends Thread {

    private final GestorSala gestorSala;
    private final Random random;

    private int cantidadPersonas;

    public GeneradorPersonas(int cantidadPersonas, GestorSala gestorSala)
    {
        this.cantidadPersonas = cantidadPersonas;
        this.gestorSala = gestorSala;
        this.random = new Random();
    }

    @Override
    public void run()
    {
        while(cantidadPersonas>0)
        {
            boolean jubilada = (random.nextBoolean() && random.nextBoolean()); // 25%
            int tiempo = random.nextInt(5000);

            Persona persona = new Persona(gestorSala, jubilada, tiempo);
            persona.start();
            cantidadPersonas--;
        }

        gestorSala.cerrar();
    }

}
