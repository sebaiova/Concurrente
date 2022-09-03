package tp03.ex03;

public class Main {

    public static void main(String args[]) throws InterruptedException
    {
        final int NUMBER_CLIENTES = 20; 

        SistemaConcierto sistema = new SistemaConcierto();
        Cliente[] clientes = new Cliente[NUMBER_CLIENTES];

        for(int i=0; i<NUMBER_CLIENTES; i++) 
        {
            clientes[i] = new Cliente(sistema);
            clientes[i].start();
        }

        for(int i=0; i<NUMBER_CLIENTES; i++) 
            clientes[i].join();
        
        System.out.println("Butacas ocupadas: " + sistema.getButacas().cardinality());
        System.out.println("Vista: " + sistema.getButacas().toString()); 
    }
}
