package tp03.ex02;

class Personaje extends Thread
{
    private int HP = 10;
    String nombre;
    int power = 3;

    public Personaje(String nombre)
    {
        this.nombre = nombre;
    }

    public int getHP()
    {
        return HP;
    }

    public void setHP(int HP)
    {
        this.HP = HP;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    protected void cast()
    {

    }

    @Override
    public void run() 
    {        
        for(int i=0; i<5; i++) 
        { 
            try {
                sleep(500);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            cast();
        }
    }
}