package tp06.ex05;

public class BrazoAuxiliar extends Thread {
    
    private final ContenedorCaja caja; 

    public BrazoAuxiliar(ContenedorCaja caja)
    {
        this.caja = caja;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {caja.retirar();} catch (InterruptedException e) {}
            caja.reponer();
        }
    }
}
