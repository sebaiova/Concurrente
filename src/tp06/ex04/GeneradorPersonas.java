package tp06.ex04;

import java.util.Random;

enum Tipo {
    VISITANTE, SILLA_RUEDA, MANTENIMIENTO, INVESTIGADOR
}

public class GeneradorPersonas extends Thread {
    
    private final Observatorio observatorio;
    private final Random random;
    
    private int personasRestantes;

    public GeneradorPersonas(Observatorio observatorio, int personas)
    {
        this.observatorio = observatorio;
        this.personasRestantes = personas;
        this.random = new Random();
    }
    
    @Override
    public void run()
    {
        while(personasRestantes-- > 0)
        {
            int velocidad = random.nextInt(10);
            try { sleep(20*velocidad);} catch (InterruptedException e) {}
            Tipo tipo = nextTipo();
            switch(tipo)
            {
                case INVESTIGADOR:  new Investigador(velocidad, observatorio).start();  break;
                case VISITANTE:     new Visitante(velocidad, observatorio).start();     break;
                case MANTENIMIENTO: new Mantenimiento(velocidad, observatorio).start(); break;
                case SILLA_RUEDA:   new SillaRuedas(velocidad, observatorio).start();   break;
            }
        }
    }

    private Tipo nextTipo()
    {
        Tipo tipo;
        int i = random.nextInt(10);
        switch (i)
        {
            case 0: 
            case 1: tipo = Tipo.MANTENIMIENTO; break;
            case 2: 
            case 3: 
            case 4: tipo = Tipo.INVESTIGADOR; break;
            case 5: tipo = Tipo.SILLA_RUEDA; break;
            default: tipo = Tipo.VISITANTE; break;
        }
        return tipo;
    }
}
