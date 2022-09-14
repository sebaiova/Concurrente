package tp03.ex06;

class IntWrapper
{
    private int valor;

    public IntWrapper(int valor)
    {
        this.valor = valor;
    }

    public synchronized void sumar(int x)
    {
        this.valor += x; 
    }

    public synchronized int getValor()
    {
        return this.valor;
    }
}