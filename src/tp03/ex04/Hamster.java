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

    public int getNumero() 
    {
        return numero;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        for(int i=0; i<4; i++)
            try {
                jaula.usar(random.nextInt(3), this);
            } catch (InterruptedException e) {
            }
    }
}
