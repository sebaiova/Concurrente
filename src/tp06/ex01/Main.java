package tp06.ex01;

public class Main {

    private static final int AUTOS = 50;
    private static final int FRECUENCIA = 10;   // 1000ms/FRECUENCIA
    private static final int CAPACIDAD_PUENTE = 3;
    private static final int CEDER_PASO = 10;

    static public void main(String[] args)
    {
        Puente puente = new Puente(CAPACIDAD_PUENTE, CEDER_PASO);
        GeneradorAutos generador = new GeneradorAutos(AUTOS, FRECUENCIA, puente);
        generador.start();
    }
}