package tp04.ex04;

public class Main {

    static private final int PRINTERS_A = 2;
    static private final int PRINTERS_B = 1; 
    static private final int PRINTERS_AMOUNT = PRINTERS_A + PRINTERS_B; 

    static private final int USUARIOS_AMOUNT = 3;

    static public void main(String[] args) throws InterruptedException
    {
        Imprenta imprenta = new Imprenta(PRINTERS_A, PRINTERS_B);
        Impresora[] impresoras = new Impresora[PRINTERS_AMOUNT];
        Usuario[] usuarios = new Usuario[USUARIOS_AMOUNT];

        for(int i=0; i<PRINTERS_A; i++) 
        {
            impresoras[i] = new Impresora(imprenta, 0);
            impresoras[i].start();
        }

        for(int i=PRINTERS_A; i<PRINTERS_AMOUNT; i++)
        {
            impresoras[i] = new Impresora(imprenta, 1);
            impresoras[i].start();
        }

        for(int i=0; i<USUARIOS_AMOUNT; i++) 
        {
            usuarios[i] = new Usuario(imprenta, i%3);
            usuarios[i].start();
        }

        for(int i=0; i<PRINTERS_AMOUNT; i++)
            impresoras[i].join();

        for(int i=0; i<USUARIOS_AMOUNT; i++)
            usuarios[i].join();
    }
}
