package tp02.ex02;

class TesteoHilosModificado{
    public static void main (String[] args)
    {
        Thread miHilo= new MiEjecucion();
        System.out.println("En el main");
        miHilo.start();
    }
    
}