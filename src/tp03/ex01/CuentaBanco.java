package tp03.ex01;

public class CuentaBanco 
{
    private int balance = 50;

    public CuentaBanco()
    {

    }

    public int getBalance()
    {
        return balance;
    }

    public void retiroBancario(int retiro)
    {
        balance = balance - retiro;
    }
}