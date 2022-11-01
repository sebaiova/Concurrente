package tp06.ex03;

import java.util.Random;

public class GeneradorSoldados extends Thread {

    private final Random random = new Random();
    private final Cuartel cuartel;
    private int soldadosRestantes;

    public GeneradorSoldados(int cantidadSoldados, Cuartel cuartel)
    {
        this.soldadosRestantes = cantidadSoldados;
        this.cuartel = cuartel;
    }

    @Override
    public void run()
    {
        while(soldadosRestantes-->0)
        {
            try {sleep(random.nextInt(200));} catch (InterruptedException e) {}
            int lentitud = random.nextInt(10)+1;
            Soldado soldado = new Soldado(random.nextBoolean(), lentitud, cuartel);
            soldado.start();
        }
    }
}
