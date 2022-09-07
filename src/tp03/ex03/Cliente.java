package tp03.ex03;

import java.util.BitSet;
import java.util.Random;

public class Cliente extends Thread {

    private SistemaConcierto sistema;

    public Cliente(SistemaConcierto sistema)
    {
        this.sistema = sistema;
    }

    @Override
    public void run() 
    {
        elegirButaca();
    }
    
    private void elegirButaca()
    {
        BitSet butacasLibres = sistema.getButacas();
        BitSet eleccion = new BitSet(32);
        Random random = new Random();
        if(butacasLibres.cardinality() != butacasLibres.size())
        do 
        {
            eleccion.clear();
            eleccion.set(random.nextInt(32));
        }
        while( butacasLibres.intersects(eleccion) || !sistema.reservar(eleccion));
    }
}
