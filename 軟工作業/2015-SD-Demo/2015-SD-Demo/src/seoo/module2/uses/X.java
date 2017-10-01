package seoo.module2.uses;

public class X
{

    public void doSomething()
    {
        Y y = new Y();
        System.out.println("1+1=" + y.add(1, 1));
    }

    public static void main(String[] args)
    {
        X x = new X();
        x.doSomething();
    }

}
