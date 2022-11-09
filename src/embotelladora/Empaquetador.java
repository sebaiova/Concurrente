package embotelladora;

public class Empaquetador extends Thread {
    
    Fabrica fabrica;
    Almacen almacen;
    
    public Empaquetador(Fabrica fabrica, Almacen almacen)
    {   
        this.fabrica = fabrica;
        this.almacen = almacen;
    }

    @Override
    public void run()
    {
        while(true) 
        {
            fabrica.empaquetar();
            almacen.guardarEnAlmacen();
        }
    }

}
