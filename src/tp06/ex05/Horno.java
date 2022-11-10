package tp06.ex05;

import java.util.Random;

public class Horno extends Thread {
    
    private final Mostrador mostrador;
    private final int[] tipoPastel = {15, 20, 25};
    private       int pastelesRestantes;

    public Horno(Mostrador mostrador, int pastelesRestantes)
    {
        this.mostrador = mostrador;
        this.pastelesRestantes = pastelesRestantes;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        while(pastelesRestantes-- >0)
        {
            try { sleep(100);} catch (InterruptedException e) {}
            mostrador.agregarPastel(new Pastel(tipoPastel[random.nextInt(3)]));
        }

        System.out.println("Todos los pasteles horneados.");
    }

}
