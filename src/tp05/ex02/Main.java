package tp05.ex02;

public class Main {

    private static int GATOS = 40;
    private static int PERROS = 50;
    private static int LUGARES = 5;

    static public void main(String[] args) throws InterruptedException
    {
        Veterinaria veterinaria = new Veterinaria(LUGARES);
        Gato[] gato = new Gato[GATOS];
        Perro[] perro = new Perro[PERROS];

        for(int i=0; i<GATOS; i++)
        {
            gato[i] = new Gato(veterinaria);
            gato[i].start();
        }

        for(int i=0; i<PERROS; i++)
        {
            perro[i] = new Perro(veterinaria);
            perro[i].start();
        }

        for(Gato g : gato)
            g.join();

        for(Perro p : perro)
            p.join();
    }

}
