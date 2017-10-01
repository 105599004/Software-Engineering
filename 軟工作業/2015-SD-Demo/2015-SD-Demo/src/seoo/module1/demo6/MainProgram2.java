package seoo.module1.demo6;

public class MainProgram2
{

    public static void main(String[] args)
    {
        RpgPerson tom = RpgPerson.newInstance("Tom", "swordsman");
        tom.attack();
        tom.cure();

        RpgPerson mary = RpgPerson.newInstance("Mary", "magacian");
        mary.attack();
        mary.cure();
    }

}
