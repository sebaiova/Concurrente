package tp03.ex06;

import java.util.Random;

public class Main {

    private static final int ARRAY_SIZE = 50000;
    private static final int THREADS_AMOUNT = 11;
    private static final int ELEM_FOR_THREAD = ARRAY_SIZE/THREADS_AMOUNT;
    private static final int ELEM_REST = ARRAY_SIZE%THREADS_AMOUNT;

    private static int sumaSecuencial(int[] array)
    {
        int count = 0;
        for(int i=0; i<ARRAY_SIZE; i++)
            count += array[i];
        return count;
    }

    public static void main(String args[]) throws InterruptedException
    {
        int[] array = new int[ARRAY_SIZE];
        Sumador[] sumadores = new Sumador[THREADS_AMOUNT];
        IntWrapper resultadoFinal = new IntWrapper(0);
        Random random = new Random();

        for(int i=0; i<ARRAY_SIZE; i++)
        {
            array[i] = random.nextInt(10);
        }
        
        for(int i=0; i<THREADS_AMOUNT; i++)
        {
            sumadores[i] = new Sumador(array, ELEM_FOR_THREAD*i, ELEM_FOR_THREAD*(i+1) + (i==THREADS_AMOUNT-1 ? ELEM_REST : 0), resultadoFinal);
            sumadores[i].start();
        }

        for(int i=0; i<THREADS_AMOUNT; i++)
        {
            sumadores[i].join();
        }
        
        System.out.println("Suma concurrente: " + resultadoFinal.getValor());
        System.out.println("Suma secuencial: " + sumaSecuencial(array));
    }
}
