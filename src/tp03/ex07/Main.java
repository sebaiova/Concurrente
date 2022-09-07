package tp03.ex07;

public class Main {
    
    private static final int PRINTERS_AMOUNT = 3; 

    public static void main(String[] args) throws InterruptedException 
    {
        Printer[] printers = new Printer[PRINTERS_AMOUNT];
        Control control = new Control(PRINTERS_AMOUNT);

        printers[0] = new Printer('A', 2, 0, control);
        printers[1] = new Printer('B', 3, 1, control);
        printers[2] = new Printer('C', 1, 2, control);
    
        for(int i=0; i<PRINTERS_AMOUNT; i++)
            printers[i].start();

        for(int i=0; i<PRINTERS_AMOUNT; i++)
            printers[i].join();
    }
}
