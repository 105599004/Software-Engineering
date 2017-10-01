package seoo.module1.demo5;

public class Swordsman extends RpgPerson
{
    @Override
    public void attack()
    {
        System.out.println("ª«²z§ðÀ»!");
    }
    
    @Override
    public void cure()
    {
        System.out.println("³Ü¸É¦åÃÄ!");
    }
    

    public Swordsman(String name, int hp, int mp)
    {
        super(name, hp, mp);
    }
    
}
