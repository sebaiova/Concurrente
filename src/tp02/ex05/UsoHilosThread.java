package tp02.ex05;

class UsoHilosThread {

    public static void main(String[] args) {

        System.out.println("Hilo principal iniciando.");
        Thread nuevoHilo1 = new MiHiloThread("#1");
        Thread nuevoHilo2 = new MiHiloThread("#2");
        Thread nuevoHilo3 = new MiHiloThread("#3");
        //Finalmente, comienza la ejecución del hilo.
        nuevoHilo1.start();
        nuevoHilo2.start();
        nuevoHilo3.start();
        for (int i=0; i<50;i++){
            System.out.print(" .");
        }
        try{
            Thread.sleep(100);
        }   
        catch (InterruptedException exc){
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
