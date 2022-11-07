package tp06.ex04;

class Main {

    static public void main(String[] args)
    {
        Observatorio observatorio = new Observatorio();
        GeneradorPersonas generador = new GeneradorPersonas(observatorio, 100);
        generador.start();
    }
}