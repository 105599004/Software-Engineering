package seoo.module1.demo6;

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

    public static RpgPerson newInstance(String name, String type)
    {
        if ("swordsman".equals(type))
            return new Swordsman(name, 100, 0);
        else if ("magacian".equals(type))
            return new Magacian(name, 50, 100);
        else
            throw new IllegalArgumentException("illegal type!");
    }

}
