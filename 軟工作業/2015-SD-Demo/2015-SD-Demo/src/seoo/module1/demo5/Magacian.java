package seoo.module1.demo5;

public class Magacian extends RpgPerson
{

    public Magacian(String name, int hp, int mp)
    {
        super(name, hp, mp);
    }

    @Override
    public void attack()
    {
        System.out.println("¬Iªk§ðÀ»!");
    }

    @Override
    public void cure()
    {
        System.out.println("¦^´_©G!");
    }
}
