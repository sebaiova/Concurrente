package tp03.ex06;

public class Sumador extends Thread {

    private int[] array;
    private int begin;
    private int end;
    private IntWrapper resultadoFinal;
    private int sumaParcial;

    public Sumador(int[] array, int begin, int end, IntWrapper resultadoFinal)
    {
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.resultadoFinal = resultadoFinal;
        this.sumaParcial = 0;
    }

    @Override
    public void run() 
    {
        for(int i=begin; i<end; i++)
            sumaParcial += array[i];

        synchronized(resultadoFinal) 
        {
            resultadoFinal.setValor(resultadoFinal.getValor()+sumaParcial);
        }
    }
}
