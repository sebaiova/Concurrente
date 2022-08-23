package tp02.ex07;

public class CajeroRunnable implements Runnable {

    private String nombre;
    private Cliente cliente;
    private long initialTime;

    // Constructor, y métodos de acceso

    CajeroRunnable(String nombre, Cliente cliente, long initialTime)
    {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public void run()
    {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() + 
        " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) 
        {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + "del cliente " + this.cliente.getNombre() + "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }

        System.out.println("El cajero" + this.nombre + "HA TERMINADO DE PROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    void esperarXsegundos(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

