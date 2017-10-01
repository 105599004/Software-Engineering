package seoo.module2.isa;

public class X extends Y
{

    public void doSomething()
    {
        System.out.println("1+1=" + add(1, 1));
    }

    public static void main(String[] args)
    {
        X x = new X();
        x.doSomething();
    }

}
