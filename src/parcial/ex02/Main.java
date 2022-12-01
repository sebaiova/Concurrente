package parcial.ex02;

public class Main {

    static public void main(String[] args)
    {
        final BufferOscilante buffer = new BufferOscilante();
        final GeneradorHilos generador = new GeneradorHilos(buffer);

        generador.start();
    }
}
