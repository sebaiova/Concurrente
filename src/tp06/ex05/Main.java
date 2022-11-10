package tp06.ex05;

public class Main {
    
    static private final int CANTIDAD_PASTELES = 100;

    static public void main(String[] args)
    {
        Mostrador mostrador = new Mostrador();
        ContenedorCaja contenedorCaja = new ContenedorCaja(100);

        Horno horno = new Horno(mostrador, CANTIDAD_PASTELES);
        Empaquetador empaquetador = new Empaquetador(mostrador, contenedorCaja);
        BrazoAuxiliar brazo = new BrazoAuxiliar(contenedorCaja);

        horno.start();
        empaquetador.start();
        brazo.start();
    }
}
