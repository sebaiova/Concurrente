package tp06.ex02;

public class Main {
    
    static public void main(String[] args)
    {
        GestorSala gestorSala = new GestorSala();
        GeneradorPersonas generadorPersonas = new GeneradorPersonas(200, gestorSala);
        Termometro termometro = new Termometro(gestorSala, 1000);
        termometro.start();
        generadorPersonas.start();
    }
}
