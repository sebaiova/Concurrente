package tp04.ex03;

public class Main {

    private static final int PRINTERS_AMOUNT = 3; 

    public static void main(String[] args) throws InterruptedException 
    {
        CylcedControl control = new CylcedControl(PRINTERS_AMOUNT);
        Printer[] printers = new Printer[PRINTERS_AMOUNT];

        int x = 0;
        printers[x] = new Printer('A', 2, x++, control);
        printers[x] = new Printer('B', 3, x++, control);
        printers[x] = new Printer('C', 1, x++, control);
    
        for(int i=0; i<PRINTERS_AMOUNT; i++)
            printers[i].start();

        for(int i=0; i<PRINTERS_AMOUNT; i++)
            printers[i].join();
    
        System.out.println();
    }
}