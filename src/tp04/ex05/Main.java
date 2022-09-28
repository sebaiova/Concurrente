package tp04.ex05;

public class Main {
    
    static private int CLIENTES = 4; 

    static public void main(String[] args) throws InterruptedException {
        
        Taxi taxi = new Taxi();

        Taxista taxista = new Taxista(taxi);
        Cliente cliente[] = new Cliente[CLIENTES];

        taxista.start();

        for(int i=0; i<CLIENTES; i++)
        {
            cliente[i] = new Cliente(taxi);
            cliente[i].start();
        }

        for(int i=0; i<CLIENTES; i++)
            cliente[i].join();
    }
}
