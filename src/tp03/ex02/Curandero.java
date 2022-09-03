package tp03.ex02;

public class Curandero extends Personaje
{
    Personaje target;

    public Curandero(String nombre, Personaje target) 
    {
        super(nombre);
        this.target = target;
    }
    
    @Override
    protected void cast()
    {
        synchronized(target) 
        {
            int currentHP = target.getHP();
            int newHP = currentHP + power;
            target.setHP( newHP );
            System.out.printf("%s ha curado %s (%d) por %d de HP. (Actual: %d)\n", this.nombre, target.getNombre(), currentHP, this.power, newHP);
        }
    }
}
