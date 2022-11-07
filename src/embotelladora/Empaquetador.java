package embotelladora;

public class Empaquetador extends Thread {
    
    Fabrica fabrica;

    public Empaquetador(Fabrica fabrica)
    {   
        this.fabrica = fabrica;
    }

    @Override
    public void run()
    {
        while(true)
            fabrica.empaquetar();
    }

}
