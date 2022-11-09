package embotelladora;

import java.util.Random;

public class Embotellador extends Thread {
    
    Fabrica fabrica;
    Random random = new Random();

    public Embotellador(Fabrica fabrica)
    {
        this.fabrica = fabrica;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {sleep(100);} catch (InterruptedException e) {}
            if(random.nextBoolean())
                try { fabrica.embotellarVino();} catch (InterruptedException e) {}
            else
                try { fabrica.embotellarAgua();} catch (InterruptedException e) {}
        }
    }

}
