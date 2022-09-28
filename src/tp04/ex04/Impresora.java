package tp04.ex04;

public class Impresora extends Thread {
    
    Imprenta imprenta;
    int tipo;

    public Impresora(Imprenta imprenta, int tipo)
    {   
        this.imprenta = imprenta;
        this.tipo = tipo;
    }

    @Override
    public void run()
    {
        while(true)
        {
            imprenta.procesarHoja(tipo);
            System.out.printf("KKAKKKANNNK... (Tipo: %d)\n", tipo);
        }
    }

}
