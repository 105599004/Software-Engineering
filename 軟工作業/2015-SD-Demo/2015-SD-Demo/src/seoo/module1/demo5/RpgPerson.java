package seoo.module1.demo5;

public class RpgPerson
{
    private int hp;

    private int mp;

    private String name;

    public int getHp()
    {
        return hp;
    }

    public int getMp()
    {
        return mp;
    }

    public String getName()
    {
        return name;
    }

    public RpgPerson(String name, int hp, int mp)
    {
        super();
        this.hp = hp;
        this.mp = mp;
        this.name = name;
    }


    public void attack()
    {
        System.out.println("Attack by RpgPerson.");
    }

    public void cure()
    {
        System.out.println("Cure by RpgPerson.");
    }

}
