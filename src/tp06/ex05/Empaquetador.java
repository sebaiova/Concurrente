package tp06.ex05;

public class Empaquetador extends Thread {

    private final Mostrador mostrador;
    private final ContenedorCaja caja;

    public Empaquetador(Mostrador mostrador, ContenedorCaja caja)
    {
        this.mostrador = mostrador;
        this.caja = caja;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try { 
                int peso = mostrador.retirarPastel();
                caja.agregar(peso);
            }
            catch (InterruptedException e) {}
        }
    }
}
