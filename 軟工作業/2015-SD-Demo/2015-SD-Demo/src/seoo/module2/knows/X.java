package seoo.module2.knows;

public class X
{
    private Y y;
    
    public void doSomething()
    {
        System.out.println("1+1=" + y.add(1, 1));
    }

    public static void main(String[] args)
    {
        X x = new X();
        x.doSomething();
    }

}
