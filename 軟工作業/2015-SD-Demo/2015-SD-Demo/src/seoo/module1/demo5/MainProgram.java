package seoo.module1.demo5;

public class MainProgram
{

    public static void main(String[] args)
    {
        RpgPerson tom = new Swordsman("Tom", 100, 0);
        tom.attack();
        tom.cure();

        RpgPerson mary = new Magacian("Mary", 50, 30);
        mary.attack();
        mary.cure();
    }

}
