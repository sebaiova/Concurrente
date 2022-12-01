package embotelladora;

public class Main {
 
    private static final int EMBOTELLADORES = 10;

    static public void main(String[] args)
    {
        Fabrica fabrica = new Fabrica();
        Almacen almacen = new Almacen();
        
        Empaquetador empaquetador = new Empaquetador(fabrica, almacen);
        Camion camion = new Camion(almacen);
        empaquetador.start();
        camion.start();

        Embotellador[] embotellador = new Embotellador[EMBOTELLADORES];
        for(int i=0; i<EMBOTELLADORES; i++)
        {
            embotellador[i] = new Embotellador(fabrica);
            embotellador[i].start();
        }
    }
}
