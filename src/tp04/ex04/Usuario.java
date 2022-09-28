package tp04.ex04;

public class Usuario extends Thread {
    
    private final Imprenta imprenta;
    private final int tipo;

    public Usuario(Imprenta imprenta, int tipo)
    {
        this.imprenta = imprenta;
        this.tipo = tipo;
    }

    @Override
    public void run()
    {
        for(int i=0; i<5; i++)
            imprenta.mandarAImprimir(tipo);
    }
}
