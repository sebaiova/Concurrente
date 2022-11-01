package tp06.ex03;

public class Main {
    
    private static final int CANTIDAD_SOLDADOS = 100; 

    static public void main(String[] args)
    {
        Cuartel cuartel = new Cuartel();
        GeneradorSoldados generador = new GeneradorSoldados(CANTIDAD_SOLDADOS, cuartel);
        generador.start();
    } 
}
