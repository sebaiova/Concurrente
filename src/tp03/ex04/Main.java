package tp03.ex04;

public class Main {

    static private int HAMSTERS_NUMBER = 5;
    static private Hamster[] hamsters;
    static private Jaula jaula;

    public static void main(String args[]) throws InterruptedException 
    {
        jaula = new Jaula(); 

        hamsters = new Hamster[HAMSTERS_NUMBER];
        for(int i=0; i<HAMSTERS_NUMBER; i++)
        {
            hamsters[i] = new Hamster(jaula);
            hamsters[i].start();
        }

        for(int i=0; i<HAMSTERS_NUMBER; i++)
        {
            hamsters[i].join();
        }
    }
}
