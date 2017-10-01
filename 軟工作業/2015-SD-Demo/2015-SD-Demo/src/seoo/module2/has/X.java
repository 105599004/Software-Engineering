package seoo.module2.has;

public class X
{

    private Y[] yArray = new Y[10];

    public void initializeY()
    {
        for (int i = 0; i < 10; i++)
            yArray[i] = new Y();
        
        for(Y y : yArray)
            System.out.println(y);
    }

    public Y[] getYArray()
    {
        return yArray;
    }
    
    public static void main(String[] args)
    {
        X x = new X();
        x.initializeY();
    }

}
